package main.user;

import abstractdata.controller.ADataPageController;
import abstractdata.gui.DataPagePane;
import rentBike.RentBikeController;
import station.controller.StationPageController;
import nav.HomeNavArea;
import nav.StationInfoNavArea;
//import rentBike.RentBikeController;

import javax.swing.*;
import java.awt.*;

public class EBRUserController {
	private EBRUser ebr;
	private JPanel rootPanel;
	private RentBikeController rentBikeController;

	public EBRUserController() {
		rentBikeController = new RentBikeController();
	}

	public JPanel getStationPage() {
		ADataPageController controller = new StationPageController(this);
		return controller.getDataPagePane();
	}
	
	public void setEBRUser(EBRUser ebr) {
		this.ebr = ebr;
	}
	public void setInfoPane(DataPagePane pane) {
		rootPanel = ebr.rootPanel;
		rootPanel.removeAll();
		rootPanel.revalidate();
		BorderLayout layout = new BorderLayout();
		rootPanel.setLayout(layout);
		
		StationInfoNavArea navArea = new StationInfoNavArea(this);
		
		rootPanel.add(navArea, BorderLayout.NORTH);		
		
		rootPanel.add(pane, BorderLayout.CENTER);
	}
	
	public void backHomePage() {
		rootPanel.removeAll();
		rootPanel.revalidate();
		ebr.UBRUserCreateHome(this);
	}

	public HomeNavArea getHomeNavArea(){
		return new HomeNavArea();
	}

	public void showQRCodeDialog(){
			rentBikeController.showBarcodeDialog();
	}

}
