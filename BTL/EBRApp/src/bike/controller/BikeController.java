package bike.controller;

import java.util.List;
import java.util.Map;

import com.ebr.bean.ABike;
import com.ebr.bean.Bike;

import abstractdata.controller.ADataPageController;
import abstractdata.gui.ADataListPane;
import abstractdata.gui.ADataSearchPane;
import abstractdata.gui.ADataSinglePane;
import api.EBRApi;

public class BikeController  {
	
	public Bike createBike(Bike bike) {
		return new EBRApi().addNewBike(bike);
	}

}
