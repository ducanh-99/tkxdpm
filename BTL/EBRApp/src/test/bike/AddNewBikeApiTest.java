package test.bike;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.ebr.bean.ABike;
import com.ebr.bean.Bike;
import com.ebr.bean.Station;

import api.EBRApi;

public class AddNewBikeApiTest {
	private EBRApi api = new EBRApi();

//	@Test
//	public void testStation() {
//		ArrayList<Station> stations = api.getStations(null);
//		assertEquals(stations.size(), 6);
//	}
//
//	@Test
//	public void test() {
//		ArrayList<Bike> bikes = api.getBikes(null);
//		assertEquals(bikes.size(), 0);
//
//	}

	@Test
	public void testAddBike() throws ParseException {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("20/12/2020");
		Bike bike = new Bike("1","2","3",400,"11A1111","BachKHoa",(Float.valueOf("2")),date,"public","bike");
		api.addNewBike(bike);
	}

}
