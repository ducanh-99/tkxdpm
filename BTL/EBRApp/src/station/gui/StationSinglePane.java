package station.gui;

import javax.swing.JLabel;

import com.ebr.bean.Station;

import abstractdata.gui.ADataSinglePane;
import com.ebr.bean.StationGeneral;

@SuppressWarnings("serial")
public class StationSinglePane extends StationGeneralSinglePane {
	private JLabel labelNumOfBike;
	private JLabel labelNumOfEBike;
	private JLabel labelNumOfTBike;

	public StationSinglePane() {
		super();
	}

	public StationSinglePane(Station station) {
		this();
		this.t = station;

		displayData();
	}

	@Override
	public void buildControls() {
		super.buildControls();
		int row = getLastRowIndex();
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelNumOfBike = new JLabel();
		add(labelNumOfBike, c);

		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelNumOfEBike = new JLabel();
		add(labelNumOfEBike, c);

		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelNumOfTBike = new JLabel();
		add(labelNumOfTBike, c);

	}

	@Override
	public void displayData() {
		super.displayData();
		if (t instanceof Station) {
			Station station = (Station) t;
			int a = station.getNumOfBike();
			labelNumOfBike.setText("Number of Bike: " + String.valueOf(a));

			labelNumOfEBike.setText("Number of EBike: " + String.valueOf(station.getNumOfEBike()));
			labelNumOfTBike.setText("Number of TBike: " + String.valueOf(station.getNumOfTBike()));
		}
	}


}
