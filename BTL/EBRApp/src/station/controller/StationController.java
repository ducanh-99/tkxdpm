package station.controller;

import api.EBRApi;
import com.ebr.bean.Station;
import com.ebr.bean.StationGeneral;
import main.user.EBRUserController;
import abstractdata.gui.*;
import abstractdata.controller.*;
import station.gui.*;

import java.util.List;
import java.util.Map;

public abstract class StationController extends ADataPageController<StationGeneral>{
    protected EBRUserController ebrController;
    public StationController() {
        this.ebrController=null;
    }
    public StationController(EBRUserController controller) {
        this.ebrController= controller;
    }

    public abstract ADataListPane createListPane();

    public ADataSearchPane createSearchPane() {
        return new StationSearchPane();
    }
    public ADataSinglePane createSinglePane() {
        return new StationGeneralSinglePane();
    }

    public List<? extends StationGeneral> search(Map<String, String> searchParams) {
		return new EBRApi().getStations(searchParams);
    }


}
