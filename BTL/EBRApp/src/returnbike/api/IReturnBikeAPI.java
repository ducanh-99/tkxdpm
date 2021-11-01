package returnbike.api;

import com.ebr.bean.Bike;
import com.ebr.bean.Order;

import java.util.List;

/**
 * @author phong.cv173298
 * @created 22/12/2020 - 12:56 PM
 * @project EBRApp
 */
public interface IReturnBikeAPI {
    public List<Order> getListOrder(String cardNumber);

    public Bike getBike(String bikeID);

    public boolean returnBike(String bikeID, String stationID, float amount, String accountNumber);
}
