package station.controller;

import java.util.List;
import java.util.Map;

import com.ebr.bean.Station;

import abstractdata.controller.ADataPageController;
import abstractdata.controller.IDataManageController;
import abstractdata.gui.ADataListPane;
import abstractdata.gui.ADataSinglePane;
import api.EBRApi;
import api.crud.station.EBRGetStationApi;
import api.inteface.IEBRApiGet;
import com.ebr.bean.StationGeneral;
import station.gui.AdminStationListPane;
import station.gui.StationEditDialog;
import station.gui.StationSearchPane;
import station.gui.StationSinglePane;

public class AdminStationPageController extends ADataPageController<Station> {
	private IEBRApiGet api;

//	public AdminStationPageController() {
//		super();
//	}

	public AdminStationPageController(IEBRApiGet api) {
		super();
		this.api = (EBRGetStationApi) api;
	}

	@Override
	public List<Station> search(Map<String, String> searchParams) {
		api = EBRGetStationApi.getInstance();
		return api.getStations(searchParams);
	}

	public ADataListPane<Station> createListPane() {
		return new AdminStationListPane(this);
	}

	@Override
	public StationSearchPane createSearchPane() {
		return new StationSearchPane();
	}

	@Override
	public ADataSinglePane createSinglePane() {
		return new StationSinglePane();
	}

	public Station updateStation(Station station) {
		return new EBRApi().updateStation(station);
	}

	public void onEdit(ADataSinglePane<Station> singlePane) {
		IDataManageController<Station> manageController = new IDataManageController<Station>() {

			@Override
			public void onAct(Station station) {
				Station newStation = updateStation(station);
				singlePane.updateData(newStation);
			}
		};

		new StationEditDialog(singlePane.getData(), manageController);
	}
	
}
