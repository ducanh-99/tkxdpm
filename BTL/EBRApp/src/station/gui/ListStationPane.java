package station.gui;

import abstractdata.gui.ADataListPane;
import abstractdata.gui.ADataSinglePane;
import station.controller.StationPageController;
import com.ebr.bean.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@SuppressWarnings("serial")
public class ListStationPane<T> extends ADataListPane<T> {
	private StationPageController controller;
//	public ListStationPane(){
//		super();
//	}
	public ListStationPane(StationPageController controller){
		setController(controller);
	}
	public void decorateSinglePane(ADataSinglePane<T> singlePane) {
		JButton button = new JButton("Xem chi tiet");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StationGeneral station = ((StationGeneral)singlePane.getData());
				controller.getStationInfoPage(station);
			}
		});
		singlePane.addDataHandlingComponent(button);		
	}

	public void setController(StationPageController controller) {
		super.setController(controller);
		this.controller = controller;
	}
}
