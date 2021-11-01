package nav;

import javax.swing.*;

public class NavArea extends JPanel{
	private JLabel label = new JLabel("USER");
	
	public NavArea() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(Box.createVerticalGlue());
		add(label);
		label.setText("Danh sach");
		
//	    JPanel twoButton = new JPanel();
//	    twoButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
//	    twoButton.setLayout(new BoxLayout(twoButton, BoxLayout.X_AXIS)); 
//	    JButton ok = new JButton("Thuê xe");       
//	    JButton close = new JButton("Xe đang thuê");
	
//	    twoButton.add(ok);
//	    twoButton.add(close);
//		add(twoButton);
	}
	public void setNavAreaLabel(String str) {
		this.label.setText(str);
	}
}
