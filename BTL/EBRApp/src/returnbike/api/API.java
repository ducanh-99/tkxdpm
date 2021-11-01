package returnbike.api;


import api.EBRApi;
import com.ebr.bean.Bike;
import com.ebr.bean.Order;
import com.google.gson.Gson;
import rentBike.RentBikeEntity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class API implements IReturnBikeAPI {
    private static final String PATH = "https://server-ebr.herokuapp.com/";
    private static API api;

    private API() {

    }

    public static API getInstance() {
        if (api==null) {
            synchronized (API.class) {
                if (api==null) {
                    api = new API();
                }
            }
        }
        return api;
    }

    public List<Order> getListOrder(String cardNumber) {
        StringBuilder response = new StringBuilder();
        List<Order> orders = null;
        try {
            URL url= new URL(PATH+"/rentingbike/"+cardNumber);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            connection.connect();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;

                while ((inputLine=in.readLine()) != null) {
                    response.append(inputLine);
                }

                System.out.println("got order: "+response);
                Gson gson = new Gson();
                Order order = gson.fromJson(response.toString(), Order.class);
                if (order.getBikeID()!=null) {
                    orders = new ArrayList<>();
                    orders.add(order);
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (orders==null) System.out.println("nulllllllllllllllllllllllllllllllllll");
        return orders;
    }

    public Bike getBike(String bikeID) {
        Bike bike = new Bike();

        EBRApi api = new EBRApi();
        RentBikeEntity rentBikeEntity = api.getRentBike(bikeID);

        bike.setId(rentBikeEntity.getId());
        bike.setType(rentBikeEntity.getType());

        return bike;
    }

    public boolean returnBike(String bikeID, String stationID, float amount, String accountNumber) {
        ReturnBikeEntity entity = new ReturnBikeEntity(bikeID, stationID, amount, accountNumber);
        Gson gson = new Gson();
        String json = gson.toJson(entity);
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL("http://server-ebr.herokuapp.com/pay");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setDoOutput(true);

            DataOutputStream stream = new DataOutputStream(connection.getOutputStream());
            stream.writeBytes(json);

            connection.connect();

            if (connection.getResponseCode()==HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            System.out.println(json+"\n:"+response.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Response res = gson.fromJson(response.toString(), Response.class);

        if (res!=null && res.getStatus()==1) {
            System.out.println(String.format("Đã trả xe %s tại bãi %s với số tiền thanh toán %f được gửi vào tài khoản %s", bikeID, stationID, amount, accountNumber));
            return true;
        }
        return false;
    }

    private class ReturnBikeEntity {
        private String bikeID;
        private String stationID;
        private float amount;
        private String cardNumber;

        public ReturnBikeEntity() {

        }

        public ReturnBikeEntity(String bikeID, String stationID, float amount, String accountNumber) {
            this.bikeID = bikeID;
            this.stationID = stationID;
            this.amount = amount;
            this.cardNumber = accountNumber;
        }

        public String getBikeID() {
            return bikeID;
        }

        public void setBikeID(String bikeID) {
            this.bikeID = bikeID;
        }

        public String getStationID() {
            return stationID;
        }

        public void setStationID(String stationID) {
            this.stationID = stationID;
        }

        public float getAmount() {
            return amount;
        }

        public void setAmount(float amount) {
            this.amount = amount;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }
    }

    private class Response {
        private int status;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
