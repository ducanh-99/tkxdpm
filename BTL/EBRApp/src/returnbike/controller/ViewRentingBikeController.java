package returnbike.controller;

import com.ebr.bean.Bike;
import com.ebr.bean.Order;
import returnbike.api.API;
import returnbike.api.IReturnBikeAPI;
import returnbike.caculatingmethod.FirstCalculatingMethod;
import returnbike.etc.Notification;
import returnbike.gui.ReturnBikeListPane;
import returnbike.gui.ReturnBikePane;
import returnbike.gui.ReturnBikeSinglePane;
import staticdata.PaymentData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ViewRentingBikeController {
    private final ReturnBikeListPane listPane;
    private final List<ReturnBikeSinglePane> listSinglePane;
    private final IReturnBikeAPI api;
    private ReturnBikePane mainPanel;
    private final ReturnStationController returnStationController;
    private final Thread updateDataThread;

    private static ViewRentingBikeController viewRentingBikeController;

    public static ViewRentingBikeController getInstance() {
        if (viewRentingBikeController==null) {
            synchronized (ViewRentingBikeController.class) {
                viewRentingBikeController = new ViewRentingBikeController();
            }
        }

        viewRentingBikeController.updateDataOnListPane();
        return viewRentingBikeController;
    }

    private ViewRentingBikeController() {
        api = API.getInstance();

        returnStationController = new ReturnStationController(this);

        listSinglePane = new ArrayList<>();
        listPane = new ReturnBikeListPane();
        listPane.setController(this);

        updateDataThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    for (ReturnBikeSinglePane singlePane : listSinglePane) {
                        singlePane.updateData(singlePane.getT());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void updateDataOnListPane() {
        List<Order> orders = api.getListOrder(PaymentData.accountNumber);

        listPane.updateData(orders);
        if (orders == null || orders.size()==0) {
            new Notification("Bạn chưa thuê xe nào");
            return;
        }
        if (!updateDataThread.isAlive()) updateDataThread.start();
    }

    public void onReturnSuccess() {
        updateDataOnListPane();
    }

    public void setSelectedStationID(String id) {
        mainPanel.setReturningStationID(id);
    }

    public ReturnBikeSinglePane createSinglePane(Order order) {
        ReturnBikeSinglePane returnBikeSinglePane = new ReturnBikeSinglePane(order, getBike(order.getBikeID()), new FirstCalculatingMethod());

        listSinglePane.add(returnBikeSinglePane);
        return returnBikeSinglePane;
    }

    public void returnBike(Order order) {
        if (mainPanel.getReturningStationID()==null || mainPanel.getReturningStationID().length()==0) {
            new Notification("Bạn chưa chọn bãi trả xe");
            return;
        }

        new ReturnBikeController(order.getBikeID(), mainPanel.getReturningStationID(), order.getAmount(), this);
    }

    public Bike getBike(String bikeID) {
        return api.getBike(bikeID);
    }

    public JPanel getReturnBikePage() {
        if (mainPanel==null) mainPanel = new ReturnBikePane(returnStationController.getDataPagePane(), listPane);
        return mainPanel;
    }
}
