package bikedetail.gui;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import abstractdata.gui.*;
import bikedetail.controller.ListBikeInfoController;
import com.ebr.bean.Bike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BikeListPane extends JScrollPane {
    private LayoutManager layout;
    protected JPanel pane;
    private ListBikeInfoController controller;
    public BikeListPane(ListBikeInfoController controller){
        this.controller = controller;
        pane = new JPanel();
        layout = new BoxLayout(pane, BoxLayout.Y_AXIS);
        pane.setLayout(layout);

        this.setViewportView(pane);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.getVerticalScrollBar().setUnitIncrement(20);
        this.getHorizontalScrollBar().setUnitIncrement(20);
    }

//    public void setController(ListBikeInfoController controller){
//        this.controller = controller;
//    }

    public void decorateSinglePane(ADataSinglePane<Bike> singlePane){
        JButton button = new JButton("View detail");
        singlePane.addDataHandlingComponent(button);
        button.setBackground(Color.gray);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BikeDetailDialog(controller, singlePane.getData());
            }
        });
    }

    public void updateData(List<Bike> list){
        pane.removeAll();
        pane.revalidate();
        pane.repaint();

        for (Bike bike : list) {
            ADataSinglePane singlePane = controller.createSinglePane();
            decorateSinglePane(singlePane);
            singlePane.updateData(bike);
            pane.add(singlePane);
            pane.add(Box.createRigidArea(new Dimension(0, 20)));
        }
    }


}
