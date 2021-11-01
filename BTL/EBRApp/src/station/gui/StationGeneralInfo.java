package station.gui;

import com.ebr.bean.Station;
import com.ebr.bean.StationGeneral;

import javax.swing.*;

public class StationGeneralInfo extends InfoPane<StationGeneral> {
    private JLabel name;
    private JLabel address;
    private JLabel id;
    private JLabel title;

    public StationGeneralInfo() {
        super();
    }

    protected void buildControls() {
        int r = getLastRowIndex();
        addTitle("Station ID: ", 0, r);
        id = new JLabel();
        c.gridx = 1;
        c.gridy = r;
        add(id, c);

        r = getLastRowIndex();
        addTitle("Station name: ", 0, r);
        name = new JLabel();
        c.gridx = 1;
        c.gridy = r;
        add(name, c);

        r = getLastRowIndex();
        addTitle("Station address: ", 0, r);
        address = new JLabel();
        c.gridx = 1;
        c.gridy = r;
        add(address, c);

    }

    protected void displayData() {
            id.setText(t.getId());
            name.setText(t.getName());
            address.setText(t.getAddress());
    }

    protected void addTitle(String tit, int x, int y) {
        title = new JLabel(tit);
        c.gridx = x;
        c.gridy = y;
        add(title, c);
    }
}