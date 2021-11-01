package returnbike.controller;

import returnbike.api.API;
import returnbike.api.IReturnBikeAPI;
import returnbike.etc.Notification;
import returnbike.payment.IPaymentController;
import returnbike.payment.PaymentDialog;

public class ReturnBikeController implements IPaymentController {
    private String bikeID;
    private String returnStationID;
    private float amount;
    private String accountNumber;
    private IReturnBikeAPI api;
    private ViewRentingBikeController viewRentingBikeController;

    public ReturnBikeController(String bikeID, String returnStationID, float amount, ViewRentingBikeController viewRentingBikeController) {
        this.viewRentingBikeController = viewRentingBikeController;
        this.bikeID = bikeID;
        this.returnStationID = returnStationID;
        this.amount = amount;
        api = API.getInstance();
        new PaymentDialog(this::pay);
    }

    public boolean returnBike() {
        boolean result = api.returnBike(bikeID, returnStationID, amount, accountNumber);

        if (result) {
            viewRentingBikeController.onReturnSuccess();
            new Notification("Thành công!");
        } else new Notification("Bãi xe đã hết chỗ rùi :(");

        return result;
    }

    @Override
    public boolean pay(String accountNumber) {
        this.accountNumber = accountNumber;
        return returnBike();
    }
}
