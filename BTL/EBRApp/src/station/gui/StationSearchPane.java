package station.gui;

import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTextField;

import abstractdata.gui.ADataSearchPane;

@SuppressWarnings("serial")
public class StationSearchPane extends ADataSearchPane {
	private JTextField idField;
	private JTextField nameField;
	private JTextField addressField;

	public StationSearchPane() {
		super();
	}

	@Override
	public void buildControls() {
		JLabel idLabel = new JLabel("Id");
		idField = new JTextField(15);
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(idLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(idField, c);

		JLabel nameLabel = new JLabel("Name");
		nameField = new JTextField(15);
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(nameLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(nameField, c);

		JLabel addressLabel = new JLabel("Address");
		addressField = new JTextField(15);
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(addressLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(addressField, c);
	}

	@Override
	public Map<String, String> getQueryParams() {
		Map<String, String> res = super.getQueryParams();

		if (!idField.getText().trim().equals("")) {
			res.put("id", idField.getText().trim());
		}
		if (!nameField.getText().trim().equals("")) {
			res.put("name", nameField.getText().trim());
		}
		if (!addressField.getText().trim().equals("")) {
			res.put("address", addressField.getText().trim());
		}

		return res;
	}
}
