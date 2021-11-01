package bikedetail.gui;

import abstractdata.gui.ADataSinglePane;
import com.ebr.bean.Bike;

import javax.swing.*;
import java.awt.*;

public class BikeSinglePane extends ADataSinglePane<Bike> {

	private JLabel bikeID;
	private JLabel name;
	private JLabel type;
	private JLabel cost;
	private JLabel status;

	public BikeSinglePane() {
		super();
	}

	public BikeSinglePane(Bike info) {
		this();
		this.t = info;
		displayData();
	}

	protected int getLastRowIndex() {
		layout.layoutContainer(this);
		int[][] dim = layout.getLayoutDimensions();
		int rows = dim[1].length;
		return rows;
	}

	@Override
	public void buildControls() {
		super.buildControls();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;

		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		bikeID = new JLabel();
		add(bikeID, c);

		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		name = new JLabel();
		add(name, c);

		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		type = new JLabel();
		add(type, c);

		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		cost = new JLabel();
		add(cost, c);

		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		status = new JLabel();
		add(status, c);

	}

	@Override
	public void displayData() {
		bikeID.setText("Bike ID: " + t.getId());
		name.setText("Name: " + t.getName());
		type.setText("Type: " + t.getType());
		cost.setText("Cost: " + t.getCost());
		status.setText("Status: " + t.getStatus());
	}

	public Bike getInfo() {
		return null;
	}
}
