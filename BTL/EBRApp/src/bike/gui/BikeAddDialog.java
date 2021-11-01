package bike.gui;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ebr.bean.ABike;
import com.ebr.bean.Bike;


import abstractdata.controller.IDataManageController;

@SuppressWarnings("serial")
public class BikeAddDialog extends ABikeAddDialog {
	
	private JTextField typeField;

	public BikeAddDialog(ABike abike, IDataManageController<ABike> controller) {
		super(abike,controller);

	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void buildControls() {
		super.buildControls();
		if (t instanceof Bike) {
			Bike bike = (Bike ) t;
			int row = getLastRowIndex();
	        JLabel nameLabel = new JLabel("type");
	        c.gridx = 0;
	        c.gridy = row;
	        getContentPane().add(nameLabel, c);
	        typeField = new JTextField(15);
	        typeField.setText("bike");
	        typeField.disable();
	        c.gridx = 1;
	        c.gridy = row;
	        getContentPane().add(typeField, c);
		}
		
	}
	
	@Override
	public ABike getNewData() {
		super.getNewData();
		if(t instanceof Bike) {
			Bike bike = (Bike) t;
			bike.setType("bike");
		}
		return t;
	}
}
