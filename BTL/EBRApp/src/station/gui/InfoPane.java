package station.gui;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public abstract class InfoPane<T> extends JPanel {
	protected GridBagLayout layout;
	protected GridBagConstraints c;
	T t;
	public InfoPane() {
		layout = new GridBagLayout();
		this.setLayout(layout);

		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;		
		buildControls();
		int row = getLastRowIndex();
		int column = getLastColumnIndex();
		c.weightx = 1;
		c.gridx = column;
		c.gridy = row - 1;
		add(new JLabel(), c);
	}
	protected abstract void buildControls(); 
	protected abstract void displayData();
	
	public void updateData(T t) {
		this.t =t;
		displayData();
	}
	
	protected int [][] getGridIndex(){
		layout.layoutContainer(this);
		int[][] dim = layout.getLayoutDimensions();
		return dim;
	}
	protected int getLastRowIndex() {
	    return getGridIndex()[1].length;
	}
	protected int getLastColumnIndex() {
	    return getGridIndex()[0].length;
	}
}
