package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.ebr.bean.ABike;
import com.ebr.bean.Bike;
import com.ebr.bean.Station;

import api.EBRApi;

public class EbrApiTest {
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
	public void testAddStation() {
		Station station = new Station("1", "1", "1", 5, 5, 1, 1, 3);
		api.addNewStation(station);
	}

}
