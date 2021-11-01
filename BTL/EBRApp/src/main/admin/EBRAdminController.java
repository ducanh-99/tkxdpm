package main.admin;

import javax.swing.*;

import com.ebr.bean.ABike;
import com.ebr.bean.Bike;
import com.ebr.bean.Station;

import abstractdata.controller.IDataManageController;
import api.EBRApi;
import api.crud.bike.EBRAddBikeApi;
import api.crud.station.EBRAddStationApi;
import api.crud.station.EBRGetStationApi;
import api.inteface.IEBRApiAdd;
import bike.controller.BikeController;
import bike.gui.BikeAddDialog;
import station.controller.AdminStationPageController;
import station.gui.StationAddDialog;

public class EBRAdminController {
	private IEBRApiAdd<Station> apiAdd;
	private IEBRApiAdd<ABike> apiAddBike;
	public JPanel getStationPage() {
		AdminStationPageController controller = new AdminStationPageController(EBRGetStationApi.getInstance());

		return controller.getDataPagePane();
	}

	public void onAdd() {
		IDataManageController<Station> stationController = new IDataManageController<Station>() {

			@Override
			public void onAct(Station station) {
				apiAdd = EBRAddStationApi.getInstance();
//				api.addNewStation(station);
				apiAdd.add(station);
				System.out.println("created Station!");
			}

		};
		new StationAddDialog(new Station(), stationController);
	}
	
	public void addBike() {
		IDataManageController<ABike> bikeController = new IDataManageController<ABike>() {

			@Override
			public void onAct(ABike t) {
				if (t instanceof Bike) {
					Bike bike = (Bike) t;
					apiAddBike = EBRAddBikeApi.getInstance();
					apiAddBike.add(bike);
					System.out.println("created Bike!");
				}
			}
		};
		new BikeAddDialog(new Bike(), bikeController);
	}
}
