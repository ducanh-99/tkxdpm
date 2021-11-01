package nav;

import main.user.EBRUserController;
import returnbike.controller.ViewRentingBikeController;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeNavArea extends NavArea {
	JButton thuexe;
	EBRUserController controller;
	JFrame rentingBike;
	public HomeNavArea() {
		super();
		setNavAreaLabel("Danh sách bãi xe ");
		thuexe = new JButton("Thuê xe");
		JButton xemxe = new JButton("Xem xe đang thuê");
		this.add(thuexe);
		this.add(xemxe);
		controller = new EBRUserController();

		//ptn cđl Phạm Thành Nam bắt đầu ở đây ! - thuê xe
		thuexe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					controller.showQRCodeDialog();
			}
		});

		xemxe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = createRentingBikeFrame();

				frame.setVisible(true);
			}
		});
	}

	private JFrame createRentingBikeFrame() {
		if (rentingBike != null) {
			ViewRentingBikeController.getInstance().updateDataOnListPane();
			return rentingBike;
		}
		JFrame frame = new JFrame();
		frame.setTitle("Xem xe đang thuê");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		ViewRentingBikeController controller = ViewRentingBikeController.getInstance();
		JPanel rootPanel = new JPanel();
		frame.setContentPane(rootPanel);
		BorderLayout layout = new BorderLayout();
		rootPanel.setLayout(layout);
		rootPanel.add(controller.getReturnBikePage(), BorderLayout.CENTER);

		rentingBike = frame;
		return rentingBike;
	}

}
