package main.admin;

import abstractdata.controller.IDataManageController;
import api.EBRApi;
import bike.controller.BikeController;
import bike.gui.BikeAddDialog;
import station.gui.StationAddButton;
import station.gui.StationAddDialog;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.ebr.bean.Bike;
import com.ebr.bean.ABike;
import com.ebr.bean.Station;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class EBRAdmin extends JFrame {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 550;
	public static JLabel titleLabel;
	public static JButton titleButton;
	public static JPanel pagePane;
	public static JButton addBikeButton;

	public EBRAdmin(EBRAdminController controller) {
		JPanel rootPanel = new JPanel();
		setContentPane(rootPanel);
		BorderLayout layout = new BorderLayout();
		rootPanel.setLayout(layout);
		rootPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());

		titleLabel = new JLabel("Station manager");
		titleButton = new JButton("Add new Station");
		titleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onAdd();
			}

		});
		
		addBikeButton = new JButton("Add new Bike");
		addBikeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addBike();
			}
		});

		titlePanel.add(titleLabel, BorderLayout.WEST);
		titlePanel.add(titleButton, BorderLayout.EAST);

		titlePanel.add(addBikeButton, BorderLayout.CENTER);

		rootPanel.add(titlePanel, BorderLayout.NORTH);

		pagePane = controller.getStationPage();

		rootPanel.add(pagePane, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("EBR for Admin");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new EBRAdmin(new EBRAdminController());
			}
		});
	}
}
