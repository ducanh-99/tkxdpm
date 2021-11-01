package station.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.ebr.bean.Station;

import abstractdata.controller.ADataPageController;
import abstractdata.gui.ADataListPane;
import abstractdata.gui.ADataSinglePane;
import station.controller.AdminStationPageController;

@SuppressWarnings("serial")
public class AdminStationListPane extends ADataListPane<Station> {
	public AdminStationListPane(ADataPageController<Station> controller) {
		this.controller = controller;
	}

	@Override
	public void decorateSinglePane(ADataSinglePane<Station> singlePane) {
		JButton viewButton = new JButton("View");
		viewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// go to Station Pane
			}
		});

		singlePane.addDataHandlingComponent(viewButton);
		viewButton.setPreferredSize(new Dimension(100, 20));

		JButton editButton = new JButton("Edit");
		singlePane.addDataHandlingComponent(editButton);
		editButton.setPreferredSize(new Dimension(100, 20));

		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((AdminStationPageController) controller).onEdit(singlePane);
			}
		});
	}
}
