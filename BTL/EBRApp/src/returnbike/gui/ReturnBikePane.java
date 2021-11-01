package returnbike.gui;

import javax.swing.*;
import java.awt.*;

public class ReturnBikePane extends JPanel {
    private JLabel returningStationID;
    private String stationID;
    GridBagLayout layout;
    GridBagConstraints c;

    public ReturnBikePane(JPanel searchPane, JScrollPane listPane) {
        returningStationID = new JLabel("Chưa chọn bãi trả xe");

        listPane.setMinimumSize(new Dimension(800, 200));
        searchPane.setMinimumSize(new Dimension(800, 200));

        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(layout);
        this.add(searchPane);
        this.add(returningStationID);
        this.add(listPane);
    }

    protected int getLastRowIndex() {
        layout.layoutContainer(this);
        int[][] dim = layout.getLayoutDimensions();
        int rows = dim[1].length;
        return rows;
    }

    public void setReturningStationID(String id) {
        this.stationID = id;
        returningStationID.setText("Bãi trả xe hiện chọn: " + stationID);
    }

    public String getReturningStationID() {
        return stationID;
    }
}
