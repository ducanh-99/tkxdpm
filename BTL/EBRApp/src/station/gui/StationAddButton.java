package station.gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class StationAddButton extends JButton {

	public StationAddButton() {
		super();
	}

	public StationAddButton(String text) {
		super(text);
	}
	
	@Override
	public void addActionListener(ActionListener l) {
		super.addActionListener(l);
	}

}
