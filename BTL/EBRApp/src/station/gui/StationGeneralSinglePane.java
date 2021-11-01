package station.gui;

import com.ebr.bean.Station;
import com.ebr.bean.StationGeneral;
import abstractdata.gui.ADataSinglePane;

import javax.swing.*;

public class StationGeneralSinglePane extends ADataSinglePane<StationGeneral> {

    private JLabel labelId;
    private JLabel labelName;
    private JLabel labelAddress;
    private JLabel labelNumOfDocks;
    private JLabel labelNumOfVehicle;

    public StationGeneralSinglePane() {
        super();
    }

    public StationGeneralSinglePane(StationGeneral station) {
        this();
        this.t = station;

        displayData();
    }

    @Override
    public void buildControls() {
        super.buildControls();

        int row = getLastRowIndex();

        c.gridx = 0;
        c.gridy = row;
        labelId = new JLabel();
        add(labelId, c);

        row = getLastRowIndex();

        c.gridx = 0;
        c.gridy = row;
        labelName = new JLabel();
        add(labelName, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelAddress = new JLabel();
        add(labelAddress, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelNumOfDocks = new JLabel();
        add(labelNumOfDocks, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelNumOfVehicle = new JLabel();
        add(labelNumOfVehicle, c);
    }

    @Override
    public void displayData() {
        labelId.setText("Id: " + t.getId());
        labelName.setText("Name: " + t.getName());
        labelAddress.setText("Address: " + t.getAddress());
        labelNumOfDocks.setText("Number of Docks: " + t.getNumbOfDocks());
        labelNumOfVehicle.setText("Number of Vehicle: " + t.getNumOfVehicle());
    }

}
