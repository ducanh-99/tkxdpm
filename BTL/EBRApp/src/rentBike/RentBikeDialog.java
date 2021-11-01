package rentBike;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RentBikeDialog extends JDialog {
    private GridBagLayout layout;
    private GridBagConstraints c;

    private JLabel idBikeField, typeBikeField, depositBikeField;
    private JLabel checkInTime, rentBikeParkID;
    private JButton closeButton;
    private JButton rentButton;

    private RentBikeController rentBikeController;

    public RentBikeDialog(RentBikeController controller) {
        this.rentBikeController = controller;
        addControl();
        addEvent();
    }

    private void addEvent() {
        rentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rentBikeController.getRentBikeEntity().setId(idBikeField.getText());
                rentBikeController.getRentBikeEntity().setDeposit(Float.parseFloat(depositBikeField.getText()));
                rentBikeController.getRentBikeEntity().setIdStation(rentBikeParkID.getText());
                rentBikeController.getRentBikeEntity().setCheckin(new Date());
                rentBikeController.showBankDialog();
            }
        });
    }

    private void addControl() {

        this.setTitle("Chi tiết thuê xe");
        this.getContentPane().removeAll();

        this.add(GUI());


        this.revalidate();
        this.repaint();
        this.pack();
        this.setResizable(false);
    }

    private JPanel GUI() {
        JPanel jPanel = new JPanel();
        layout = new GridBagLayout();
        jPanel.setLayout(layout);
        c = new GridBagConstraints();

        c.insets = new Insets(10, 0, 5, 0);
        c.gridx = 0;
        c.gridy = 0;
        jPanel.add(new JLabel("Mã xe:"), c);
        c.gridx = 1;
        c.gridy = 0;
        idBikeField = new JLabel();
        idBikeField.setHorizontalAlignment(SwingConstants.CENTER);
        idBikeField.setToolTipText(idBikeField.getText());
        idBikeField.setPreferredSize(new Dimension(100, 20));
        idBikeField.setText("null");
        jPanel.add(idBikeField, c);

        c.insets = new Insets(10, 0, 5, 0);
        c.gridx = 0;
        c.gridy = 1;
        jPanel.add(new JLabel("Loại xe:"), c);
        c.gridx = 1;
        c.gridy = 1;
        typeBikeField = new JLabel();
        typeBikeField.setText("null");
        jPanel.add(typeBikeField, c);

        c.insets = new Insets(10, 0, 5, 0);
        c.gridx = 0;
        c.gridy = 2;
        jPanel.add(new JLabel("Tiền cọc:"), c);
        c.gridx = 1;
        c.gridy = 2;
        depositBikeField = new JLabel();
        depositBikeField.setText("null");
        jPanel.add(depositBikeField, c);

        c.insets = new Insets(10, 0, 5, 0);
        c.gridx = 0;
        c.gridy = 3;
        jPanel.add(new JLabel("Mã bãi lấy xe: "), c);
        c.gridx = 1;
        c.gridy = 3;
        rentBikeParkID = new JLabel();
        rentBikeParkID.setText("null");
        jPanel.add(rentBikeParkID, c);

        c.insets = new Insets(10, 0, 5, 0);
        c.gridx = 0;
        c.gridy = 4;
        jPanel.add(new JLabel("Thời điểm lấy xe: "), c);
        c.gridx = 1;
        c.gridy = 4;
        checkInTime = new JLabel();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String strDate = formatter.format(date);
        checkInTime.setText(strDate);
        jPanel.add(checkInTime, c);

        c.insets = new Insets(10, 0, 5, 0);
//        c.gridx = 0;
//        c.gridy = 5;
//        closeButton = new JButton("Thoát");
//        jPanel.add(closeButton, c);
        c.gridx = 1;
        c.gridy = 5;
        rentButton = new JButton("Thuê");
        jPanel.add(rentButton, c);

        return jPanel;
    }

    public JLabel getIdBikeField() {
        return idBikeField;
    }

    public void setIdBikeField(JLabel idBikeField) {
        this.idBikeField = idBikeField;
    }

    public JLabel getTypeBikeField() {
        return typeBikeField;
    }

    public void setTypeBikeField(JLabel typeBikeField) {
        this.typeBikeField = typeBikeField;
    }

    public JLabel getDepositBikeField() {
        return depositBikeField;
    }

    public void setDepositBikeField(JLabel depositBikeField) {
        this.depositBikeField = depositBikeField;
    }

    public JLabel getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(JLabel checkInTime) {
        this.checkInTime = checkInTime;
    }

    public JLabel getRentBikeParkID() {
        return rentBikeParkID;
    }

    public void setRentBikeParkID(JLabel rentBikeParkID) {
        this.rentBikeParkID = rentBikeParkID;
    }
}
