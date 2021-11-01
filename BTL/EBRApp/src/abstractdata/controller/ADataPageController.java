package abstractdata.controller;

import java.util.List;
import java.util.Map;

import javax.swing.*;

import abstractdata.gui.ADataListPane;
import abstractdata.gui.ADataPagePane;
import abstractdata.gui.ADataSearchPane;
import abstractdata.gui.ADataSinglePane;

public abstract class ADataPageController<T> {
	private ADataPagePane<T> pagePane;

	public ADataPageController() {

		ADataListPane<T> listPane = createListPane();

		ADataSearchPane searchPane = createSearchPane();

		searchPane.setController(new IDataSearchController() {
			@Override
			public void search(Map<String, String> searchParams) {
				List<? extends T> list = ADataPageController.this.search(searchParams);
				listPane.updateData(list);
			}
		});

		searchPane.fireSearchEvent();

		pagePane = new ADataPagePane<T>(searchPane, listPane);
	}

	public JPanel getDataPagePane() {
		return pagePane;
	}


	protected abstract ADataListPane<T> createListPane();

	public abstract List<? extends T> search(Map<String, String> searchParams);

	public abstract ADataSinglePane<T> createSinglePane();

	public abstract ADataSearchPane createSearchPane();
}
