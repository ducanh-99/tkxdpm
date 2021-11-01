package returnbike.controller;

import abstractdata.gui.ADataListPane;
import returnbike.gui.ReturnListStationPane;
import station.controller.StationController;

/**
 * @author phong.cv173298
 * @created 19/12/2020 - 2:21 PM
 * @project EBRApp
 */
public class ReturnStationController extends StationController {
    private ViewRentingBikeController viewRentingBikeController;

    public ReturnStationController(ViewRentingBikeController controller) {
        viewRentingBikeController = controller;
    }

    @Override
    public ADataListPane createListPane() {
        return new ReturnListStationPane(this);
    }

    public void getSelectStationID(String id) {
        viewRentingBikeController.setSelectedStationID(id);
    }
}
