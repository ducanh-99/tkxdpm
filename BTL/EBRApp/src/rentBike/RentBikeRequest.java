package rentBike;

import java.util.Date;

public class RentBikeRequest {
    String bikeID;
    float deposit;
    String cardNumber;
    Date checkin;

    public RentBikeRequest() {
    }

    public RentBikeRequest(String bikeID, float deposit, String cardNumber, Date checkin) {
        this.bikeID = bikeID;
        this.deposit = deposit;
        this.cardNumber = cardNumber;
        this.checkin = checkin;
    }

    public String getBikeID() {
        return bikeID;
    }

    public void setBikeID(String bikeID) {
        this.bikeID = bikeID;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }
}
