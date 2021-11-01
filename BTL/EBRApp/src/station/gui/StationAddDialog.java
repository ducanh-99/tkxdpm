package station.gui;

import com.ebr.bean.Station;

import abstractdata.controller.IDataManageController;
import abstractdata.gui.ADataAddDialog;

import javax.swing.*;

@SuppressWarnings("serial")
public class StationAddDialog extends ADataAddDialog<Station> {
	private JTextField idField;
	private JTextField nameField;
	private JTextField addressField;
	private JTextField numOfDocksField;

	public StationAddDialog(Station station, IDataManageController<Station> controller) {
		super(station, controller);
	}

	@Override
	public void buildControls() {
		int row = getLastRowIndex();
		JLabel idLabel = new JLabel("Id");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(idLabel, c);
		idField = new JTextField(15);
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(idField, c);

		row = getLastRowIndex();
		JLabel nameLabel = new JLabel("Name");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(nameLabel, c);
		nameField = new JTextField(15);
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(nameField, c);

		row = getLastRowIndex();
		JLabel addressLabel = new JLabel("Address");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(addressLabel, c);
		addressField = new JTextField(15);
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(addressField, c);

		row = getLastRowIndex();
		JLabel numOfDocksLabel = new JLabel("Number of Docks");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(numOfDocksLabel, c);
		numOfDocksField = new JTextField(15);
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(numOfDocksField, c);
	}

	@Override
	public Station getNewData() {
		t = new Station();
		t.setId(idField.getText());
		t.setName(nameField.getText());
		t.setAddress(addressField.getText());
		t.setNumbOfDocks(Integer.parseInt(numOfDocksField.getText()));
		t = this.defautValue(t);
		return t;
	}

	private Station defautValue(Station station) {
		station.setNumOfVehicle(0);
		station.setNumOfBike(0);
		station.setNumOfEBike(0);
		station.setNumOfTBike(0);
		return station;
	}
	@Override
	public boolean validateInput() {
		return true;
		
	}
}
