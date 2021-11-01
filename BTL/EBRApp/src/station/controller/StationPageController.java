package station.controller;

//import com.oms.bean.Media;

import abstractdata.gui.ADataListPane;
import abstractdata.gui.DataPagePane;
import com.ebr.bean.Station;
import com.ebr.bean.StationGeneral;
import main.user.EBRUserController;
import station.gui.*;
import bikedetail.controller.ListBikeInfoController;
import javax.swing.*;

public class StationPageController extends StationController {
	public StationPageController() {
		super();
	}
	public StationPageController(EBRUserController controller) {
		super(controller);
	}

	public ADataListPane createListPane() {
		return new ListStationPane(this);
	}


	public void getStationInfoPage(StationGeneral station) {

		StationGeneralInfo infoPane;
		if (station instanceof Station){
			infoPane = new StationInfoPane();
		}
		else {
			infoPane = new StationGeneralInfo();
		}
		infoPane.updateData(station);

		ListBikeInfoController BikeController = new ListBikeInfoController(Integer.parseInt(station.getId()));
		JPanel bikepane = BikeController.getDataPagePane(); // them pane chi tiet xe

		DataPagePane fullinfoPane = new DataPagePane(infoPane, bikepane);


		ebrController.setInfoPane(fullinfoPane);
	}

}
