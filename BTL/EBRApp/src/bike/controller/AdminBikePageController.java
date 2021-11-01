package bike.controller;

import java.util.List;
import java.util.Map;

import com.ebr.bean.ABike;
import com.ebr.bean.Bike;

import abstractdata.controller.ADataPageController;
import abstractdata.gui.ADataListPane;
import abstractdata.gui.ADataSearchPane;
import abstractdata.gui.ADataSinglePane;

public class AdminBikePageController extends ADataPageController<ABike> {

	
	@Override
	protected ADataListPane<ABike> createListPane() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends ABike> search(Map<String, String> searchParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ADataSinglePane<ABike> createSinglePane() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ADataSearchPane createSearchPane() {
		// TODO Auto-generated method stub
		return null;
	}

}
