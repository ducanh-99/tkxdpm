package returnbike.gui;

import abstractdata.gui.ADataSinglePane;
import com.ebr.bean.Order;
import returnbike.controller.ViewRentingBikeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ReturnBikeListPane extends JScrollPane {
    private LayoutManager layout;
    protected JPanel pane;

    protected ViewRentingBikeController controller;

    public ReturnBikeListPane() {
        pane = new JPanel();
        layout = new BoxLayout(pane, BoxLayout.Y_AXIS);
        pane.setLayout(layout);

        this.setViewportView(pane);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.getVerticalScrollBar().setUnitIncrement(20);
        this.getHorizontalScrollBar().setUnitIncrement(20);
    }

    public void decorateSinglePane(ADataSinglePane singlePane) {
        JButton button = new JButton("Trả xe này");
        singlePane.addDataHandlingComponent(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.returnBike((Order)singlePane.getData());
            }
        });
    }

    public void setController(ViewRentingBikeController controller) {
        this.controller = controller;
    }

    public void updateData(List<Order> list) {
        pane.removeAll();
        pane.revalidate();
        pane.repaint();

        if (list==null) return;

        for (Order order: list) {
            ReturnBikeSinglePane singlePane = controller.createSinglePane(order);
            decorateSinglePane(singlePane);
            pane.add(singlePane);
            pane.add(Box.createRigidArea(new Dimension(0, 20)));
        }
    }
}
