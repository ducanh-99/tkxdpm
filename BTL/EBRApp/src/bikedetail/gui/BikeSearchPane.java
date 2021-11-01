package bikedetail.gui;

import abstractdata.gui.ADataSearchPane;

import javax.swing.*;
import java.util.Map;

@SuppressWarnings("serial")
public class BikeSearchPane extends ADataSearchPane {
    private JTextField bikeIDField;
    private JTextField nameField;
    private JTextField typeField;
    private JTextField statusField;

    public BikeSearchPane() {
        super();
    }

    @Override
    public void buildControls() {

        JLabel bikeIDLabel = new JLabel("ID");
        bikeIDField = new JTextField(15);
        int row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        add(bikeIDLabel,c);
        c.gridx = 1;
        c.gridy = row;
        add(bikeIDField, c);

        JLabel nameLabel = new JLabel("Name");
        nameField = new JTextField(15);
        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        add(nameLabel,c);
        c.gridx = 1;
        c.gridy = row;
        add(nameField,c);

        JLabel typeLabel = new JLabel("Type");
        typeField = new JTextField(15);
        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        add(typeLabel,c);
        c.gridx = 1;
        c.gridy = row;
        add(typeField,c);

        JLabel statusLabel = new JLabel("Status");
        statusField = new JTextField(15);
        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        add(statusLabel,c);
        c.gridx = 1;
        c.gridy = row;
        add(statusField,c);
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> res = super.getQueryParams();

        if (!bikeIDField.getText().trim().equals("")){
            res.put("ID", bikeIDField.getText().trim());
        }

        if (!nameField.getText().trim().equals("")){
            res.put("name", nameField.getText().trim());
        }

        if (!typeField.getText().trim().equals("")){
            res.put("type", typeField.getText().trim());
        }

        if (!statusField.getText().trim().equals("")){
            res.put("status", statusField.getText().trim());
        }

        return res;
    }
}
