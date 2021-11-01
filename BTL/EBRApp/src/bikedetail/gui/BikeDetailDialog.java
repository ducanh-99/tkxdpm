package bikedetail.gui;

import bikedetail.controller.ListBikeInfoController;
import com.ebr.bean.Bike;
import rentBike.RentBikeController;
import rentBike.RentBikeEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BikeDetailDialog extends ADataDetailDialog<Bike> {
    private JButton rent;
    private JLabel bikeID;
    private JLabel name;
    private JLabel type;
    private JLabel cost;
    private JLabel licensePlate;
    private JLabel producer;
    private JLabel weight;
    private JLabel manufacturingDate;
    private JLabel status;
    private RentBikeController rentBikeController;
    private  BikeDetailDialog mySelf;

    public BikeDetailDialog(ListBikeInfoController controller, Bike detail) {
        super(controller, detail);
    }

    protected int getLastRowIndex() {
        layout.layoutContainer(getContentPane());
        int[][] dim = layout.getLayoutDimensions();
        int rows = dim[1].length;
        return rows;
    }

    @Override
    public void buildControls() {
        mySelf = this;
        setContentPane(new JPanel());
        getContentPane().setLayout(layout);
        cons.fill = GridBagConstraints.HORIZONTAL;

        int row = getLastRowIndex();
        cons.gridx = 0;
        cons.gridy = row;
        bikeID = new JLabel();
        getContentPane().add(bikeID, cons);

        row = getLastRowIndex();
        cons.gridx = 0;
        cons.gridy = row;
        name = new JLabel();
        getContentPane().add(name, cons);

        row = getLastRowIndex();
        cons.gridx = 0;
        cons.gridy = row;
        type = new JLabel();
        getContentPane().add(type, cons);

        row = getLastRowIndex();
        cons.gridx = 0;
        cons.gridy = row;
        cost = new JLabel();
        getContentPane().add(cost, cons);

        row = getLastRowIndex();
        cons.gridx = 0;
        cons.gridy = row;
        licensePlate = new JLabel();
        getContentPane().add(licensePlate, cons);

        row = getLastRowIndex();
        cons.gridx = 0;
        cons.gridy = row;
        producer = new JLabel();
        getContentPane().add(producer, cons);

        row = getLastRowIndex();
        cons.gridx = 0;
        cons.gridy = row;
        weight = new JLabel();
        getContentPane().add(weight, cons);

        row = getLastRowIndex();
        cons.gridx = 0;
        cons.gridy = row;
        manufacturingDate = new JLabel();
        getContentPane().add(manufacturingDate, cons);

        row = getLastRowIndex();
        cons.gridx = 0;
        cons.gridy = row;
        status = new JLabel();
        getContentPane().add(status, cons);

        row = getLastRowIndex();
        cons.gridx = 0;
        cons.gridy = row;
        rent = new JButton();
        getContentPane().add(rent, cons);
        rent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rentBikeController = new RentBikeController();
                rentBikeController.showRentBikePane(rentBikeController.getRentBikeEntity(detail.getId()));
                mySelf.setVisible(false);
            }
        });

    }

    @Override
    public void updateData(Bike detail) {
        this.detail = detail;
        bikeID.setText("ID: " + detail.getId());
        name.setText("Name: " + detail.getName());
        type.setText("Type: " + detail.getType());
        cost.setText("Cost: " + detail.getCost());
        licensePlate.setText("License Plate: " + detail.getLicensePlate());
        producer.setText("Producer: " + detail.getProducer());
        weight.setText("Weight: " + detail.getWeight());
        manufacturingDate.setText("Manufacturing Date: " + detail.getManufacturingDate().toString());
        status.setText("Status: " + detail.getStatus());
        rent.setText("Rent");
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }
}
