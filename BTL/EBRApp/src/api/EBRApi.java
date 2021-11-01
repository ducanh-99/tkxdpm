package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
//import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;

import com.ebr.bean.*;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import rentBike.RentBikeEntity;
import rentBike.RentBikeRequest;

public class EBRApi {
    	public static final String PATH = "https://server-ebr.herokuapp.com/";
//    public static final String PATH = "http://localhost:5000/";
    private Client client;

    public EBRApi() {
        client = ClientBuilder.newClient();
    }

    public ArrayList<Station> getStations(Map<String, String> queryParams) {
        WebTarget webTarget = client.target(PATH).path("stations");

        if (queryParams != null) {
            for (String key : queryParams.keySet()) {
                String value = queryParams.get(key);
                webTarget = webTarget.queryParam(key, value);
            }
        }

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.accept("application/json").get();
        ArrayList<Station> res = response.readEntity(new GenericType<ArrayList<Station>>() {
        });
        ArrayList<Station> list = new ArrayList<>();

        boolean flag = true;
        String id="";
        String address="";
        String name="";
        for (String key : queryParams.keySet()) {
            String value = queryParams.get(key).trim();
            if (value.equals(null) || value.equals("")){
                continue;
            }
            else {
                flag = false;
                if(key.toLowerCase().equals("id")){
                    id = value.toLowerCase();
                }
                else
                    if(key.toLowerCase().equals("name")){
                        name = value.toLowerCase();
                    }
                    else
                        if (key.toLowerCase().equals("address")) {
                            address = value.toLowerCase();
                        }
            }
        }
        if (flag == true) return res;
        for (Station station: res) {
            if (station.getId().toLowerCase().contains(id) && station.getName().toLowerCase().contains(name) && station.getAddress().toLowerCase().contains(address)){
                list.add(station);
            }
        }
        return list;

    }

    public void addNewStation(Station station) {
        WebTarget webTarget = client.target(PATH).path("stations");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        System.out.println("test");
        invocationBuilder.post(Entity.entity(station, MediaType.APPLICATION_JSON));
    }
    
    public Bike addNewBike(Bike bike) {
    	WebTarget webTarget = client.target(PATH).path("bike");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        System.out.println("test");
        Response response=invocationBuilder.post(Entity.entity(bike, MediaType.APPLICATION_JSON));
        
//        Bike resBike = response.readEntity(Bike.class);
        return bike;
    }

    public Station updateStation(Station station) {
        WebTarget webTarget = client.target(PATH).path("station").path(station.getId());

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(station, MediaType.APPLICATION_JSON));

        Station res = response.readEntity(Station.class);
        return res;
    }

    public ArrayList<Bike> searchBikes(Map<String, String> queryParams, Integer id) {
        WebTarget webTarget = client.target(PATH).path("bike").path("station").path(String.valueOf(id));

        if (queryParams != null) {
            for (String key : queryParams.keySet()) {
                String value = queryParams.get(key);
                webTarget = webTarget.queryParam(key, value);
            }
        }

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.accept("application/json").get();

        ArrayList<Bike> res = response.readEntity(new GenericType<ArrayList<Bike>>() {
        });
        ArrayList<Bike> list = new ArrayList<>();

        boolean flag = true;
        String bikeID = "";
        String name = "";
        String type = "";
        String status = "";

        for (String key : queryParams.keySet()){
            String value = queryParams.get(key).trim();
            if (value.equals(null) || value.equals("")){
                continue;
            }
            else {
                flag = false;
                if(key.toLowerCase().equals("id")){
                    bikeID = value.toLowerCase();
                }
                else if(key.toLowerCase().equals("name")){
                    name = value.toLowerCase();
                }
                else if (key.toLowerCase().equals("type")) {
                    type = value.toLowerCase();
                }
                else if (key.toLowerCase().equals("status")) {
                    status = value.toLowerCase();
                }
            }
        }
        if (flag == true) return res;
        for (Bike bike : res) {
            if (bike.getId().toLowerCase().contains(bikeID) && bike.getName().toLowerCase().contains(name) && bike.getType().toLowerCase().contains(type) && bike.getStatus().toLowerCase().contains(status)){
                list.add(bike);
            }
        }
        return list;
    }

    // Gá»�i api láº¥y xe thuÃª
    public RentBikeEntity getRentBike(String idBike) {
        RentBikeEntity rentBikeEntity = new RentBikeEntity();
        try {
            URL url = new URL("https://server-ebr.herokuapp.com/bike/" + idBike);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                Object obj = JSONValue.parse(response.toString());
                JSONObject jsonObject = (JSONObject) obj;
                rentBikeEntity.setId((String) jsonObject.get("id"));
                rentBikeEntity.setType((String) jsonObject.get("type"));
                rentBikeEntity.setDeposit((int) (long) jsonObject.get("cost"));
                rentBikeEntity.setIdStation((String) jsonObject.get("stationID"));
                //System.out.println(rentBikeEntity.toString());
                return rentBikeEntity;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return rentBikeEntity;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rentBikeEntity;
    }

    // gá»�i api thanh toÃ¡n xe thuÃª
    public Boolean payRentBike(RentBikeEntity entity, String cardNumber) {
//        if (idBike == 1 && accountNumber == 123)
//            return true;
//        else return false;
        boolean flag = false;
        try {
            URL url = new URL("https://server-ebr.herokuapp.com/rent");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setRequestProperty("Accept", "*/*");
            connection.setDoOutput(true);

            String jsonInputString = new Gson().toJson(new RentBikeRequest(
                    entity.getId()+"",
                    entity.getDeposit(),
                    cardNumber+"",
                    entity.getCheckin()
            ));

            System.out.println(jsonInputString);

            OutputStream os = connection.getOutputStream();
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);

            StringBuilder response = new StringBuilder();
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                Object obj = JSONValue.parse(response.toString());
                JSONObject jsonObjectResponse = (JSONObject) obj;
                if ((int) (long) jsonObjectResponse.get("status") == 1) flag = true;

                System.out.println(jsonObjectResponse.toJSONString());

                return flag;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return flag;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return flag;
    }
}
