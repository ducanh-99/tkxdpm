package bike.gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ebr.bean.ABike;


import abstractdata.controller.IDataManageController;
import abstractdata.gui.ADataAddDialog;

@SuppressWarnings("serial")
public class ABikeAddDialog extends ADataAddDialog<ABike>  {
	
	private JTextField station_idField;
	private JTextField nameField;
	private JTextField weighField;
	private JTextField licensePlateField;
	private JTextField manufacturingDateField;
	private JTextField producerField;
	private JTextField costField;
	
	public ABikeAddDialog(ABike aBike, IDataManageController<ABike> controller) {
		super(aBike,controller);
	}

	@Override
	public void buildControls() {
		int row = getLastRowIndex();
		JLabel stationLabel = new JLabel("Station ID");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(stationLabel, c);
        station_idField = new JTextField(15);
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(station_idField, c);
		
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
        JLabel weightLabel = new JLabel("Weight");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(weightLabel, c);
        weighField = new JTextField(15);
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(weighField, c);
        
        row = getLastRowIndex();
        JLabel liJLabelLabel = new JLabel("liecense_plate");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(liJLabelLabel, c);
        licensePlateField = new JTextField(15);
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(licensePlateField, c);
        
        row = getLastRowIndex();
        JLabel maunafacturinJLabel  = new JLabel("Manuafacturing date");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(maunafacturinJLabel, c);
        manufacturingDateField = new JTextField(15);
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(manufacturingDateField, c);
        
        row = getLastRowIndex();
        JLabel producerJLabel = new JLabel("Producer");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(producerJLabel, c);
        producerField = new JTextField(15);
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(producerField, c);
        
        row = getLastRowIndex();
        JLabel costLabel = new JLabel("Cost");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(costLabel, c);
        costField = new JTextField(15);
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(costField, c);
	}

	@Override
	public ABike getNewData() {
		t.setName(nameField.getText());
		t.setCost(Integer.valueOf(costField.getText()) );
		t.setLicensePlate(licensePlateField.getText());
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(manufacturingDateField.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		t.setManufacturingDate(date1);
		t.setProducer(producerField.getText());
		t.setWeight(Float.parseFloat(weighField.getText()));
        t.setStationID(station_idField.getText());
		return t;
	}
	
	@Override
	public boolean validateInput() {
		String nameString = nameField.getText();
		Integer costInteger= Integer.valueOf(costField.getText());
		String licensePlateString = licensePlateField.getText();
		String producerString=producerField.getText();
		Float weightFloat = Float.parseFloat(weighField.getText());
		String staiongIdString = station_idField.getText();
		
		if(nameString.length() == 0) return false;
		if(costInteger  <= 0) return false;
		if(licensePlateString.length() == 0) return false;
		if(producerString.length() == 0) return false;
		if(weightFloat <=0) return false;
		if (staiongIdString.length() == 0) return false;
		return true;
		
	}
	
}
