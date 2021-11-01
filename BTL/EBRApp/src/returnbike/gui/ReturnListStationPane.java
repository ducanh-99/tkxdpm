package returnbike.gui;


import abstractdata.gui.ADataListPane;
import abstractdata.gui.ADataSinglePane;
import com.ebr.bean.Station;
import returnbike.controller.ReturnStationController;
import returnbike.etc.Notification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnListStationPane extends ADataListPane {
    private ReturnStationController controller;

    public ReturnListStationPane(ReturnStationController controller){
        super.setController(controller);
        this.controller = controller;
    }

    @Override
    public void decorateSinglePane(ADataSinglePane singlePane) {
        JButton button = new JButton("Chọn bãi xe này");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (((Station)singlePane.getData()).getNumOfBike() >= ((Station)singlePane.getData()).getNumbOfDocks()) {
                    new Notification("Bãi xe đã hết chỗ");
                    return;
                }

                String stationId = ((Station)singlePane.getData()).getId();
                controller.getSelectStationID(stationId);
            }
        });
        singlePane.addDataHandlingComponent(button);
    }
}
