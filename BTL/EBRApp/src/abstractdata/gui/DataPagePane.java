package abstractdata.gui;

import javax.swing.*;

public class DataPagePane extends JPanel{
	public DataPagePane(JPanel panel1, JPanel panel2) {
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);		
		
		this.add(panel1);
		this.add(panel2);
				
		layout.putConstraint(SpringLayout.WEST, panel1, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, panel1, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, panel1, -5, SpringLayout.EAST, this);
		
		
		layout.putConstraint(SpringLayout.WEST, panel2, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, panel2, 5, SpringLayout.SOUTH, panel1);
		layout.putConstraint(SpringLayout.EAST, panel2, -5, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, panel2, -5, SpringLayout.SOUTH, this);
	}
}
