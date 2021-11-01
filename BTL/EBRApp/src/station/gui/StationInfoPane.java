package station.gui;

import com.ebr.bean.Station;
import com.ebr.bean.StationGeneral;

import javax.swing.*;

public class StationInfoPane extends StationGeneralInfo {
	private JLabel ebike;
	private JLabel bike;
	private JLabel tbike;

	public StationInfoPane() {
		super();
	}

	protected void buildControls() {
		super.buildControls();

		int r=0;
		addTitle("Number of Bikes: ", 2, r);
		bike = new JLabel();
		c.gridx = 3;
		c.gridy = r;
		add(bike, c);

		r+=1;
		addTitle("Number of EBikes: ", 2, r);
		ebike = new JLabel();
		c.gridx = 3;
		c.gridy = r;
		add(ebike, c);

		r+=1;
		addTitle("Number of Twin Bike: ", 2, r);
		tbike = new JLabel();
		c.gridx = 3;
		c.gridy = r;
		add(tbike, c);

	}

	protected void displayData() {
		super.displayData();
		if (t instanceof Station) {
			Station station = (Station) t;
			bike.setText(Integer.toString(station.getNumOfBike()));
			ebike.setText(Integer.toString(station.getNumOfEBike()));
			tbike.setText(Integer.toString(station.getNumOfTBike()));
		}

	}
}
