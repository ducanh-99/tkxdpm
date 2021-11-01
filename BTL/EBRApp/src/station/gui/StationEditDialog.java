package station.gui;

import com.ebr.bean.Station;

import abstractdata.controller.IDataManageController;
import abstractdata.gui.ADataEditDialog;

import javax.swing.*;

@SuppressWarnings("serial")
public class StationEditDialog extends ADataEditDialog<Station> {
	private JTextField nameField;
	private JTextField addressField;
	private JTextField numOfDocksField;

	public StationEditDialog(Station station, IDataManageController<Station> controller) {
		super(station, controller);
	}

	@Override
	public void buildControls() {
		int row = getLastRowIndex();

		JLabel nameLabel = new JLabel("Name");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(nameLabel, c);
		nameField = new JTextField(15);
		nameField.setText(t.getName());
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(nameField, c);

		row = getLastRowIndex();
		JLabel addressLabel = new JLabel("Address");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(addressLabel, c);
		addressField = new JTextField(15);
		addressField.setText(t.getAddress());
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(addressField, c);

		row = getLastRowIndex();
		JLabel numOfDocksLabel = new JLabel("Number of Docks");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(numOfDocksLabel, c);
		numOfDocksField = new JTextField(15);
		numOfDocksField.setText(String.valueOf(t.getNumbOfDocks()));
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(numOfDocksField, c);
	}

	@Override
	public Station getNewData() {
		t.setName(nameField.getText());
		t.setAddress(addressField.getText());
		t.setNumbOfDocks(Integer.parseInt(numOfDocksField.getText()));

		return t;
	}

	@Override
	public boolean validateInput() {
		String name = nameField.getText();
		String address = addressField.getText();
		String numOfDocks = numOfDocksField.getText();

		if (name.length() == 0 || name.length() >15) return false;

		if (address.length() == 0 || address.length() > 100) return false;

		if (numOfDocks.length() == 0) return false;

		return Integer.parseInt(numOfDocks) > 0;
	}

	// for testing
	public JTextField getNameField() {
		return nameField;
	}

	public JTextField getAddressField() {
		return addressField;
	}

	public JTextField getNumOfDocksField() {
		return numOfDocksField;
	}
}
