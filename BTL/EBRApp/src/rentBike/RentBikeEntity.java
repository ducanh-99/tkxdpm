package rentBike;

import java.util.Date;

public class RentBikeEntity {
    String id;
    String type;
    float deposit;
    String idStation;
    Date checkin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public String getIdStation() {
        return idStation;
    }

    public void setIdStation(String idStation) {
        this.idStation = idStation;
    }


    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    @Override
    public String toString() {
        return "RentBikeEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", deposit=" + deposit +
                ", idStation=" + idStation +
                ", checkin=" + checkin +
                '}';
    }
}
