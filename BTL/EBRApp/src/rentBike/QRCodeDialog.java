package rentBike;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class QRCodeDialog extends JDialog {
    private GridBagLayout layout;
    private GridBagConstraints c;

    private JTextField idBikeField;
    private JButton closeButton;
    private JButton rentButton;
    private RentBikeController controller;

    private QRCodeDialog mySelf;

    public QRCodeDialog(RentBikeController controller) {
        this.controller = controller;
        layout = new GridBagLayout();
        this.setLayout(layout);
        c = new GridBagConstraints();
        addControl();
        addEvent();
    }

    private void addEvent() {
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.shutDownQRCodePane(mySelf);
            }
        });

        rentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller= new RentBikeController();

                controller.showRentBikePane(controller.getRentBikeEntity(idBikeField.getText()));
             //   controller.shutDownQRCodePane(mySelf);
            }
        });
    }

    private void addControl() {

        mySelf = this;
        this.setTitle("Quét mã vạch");
        this.getContentPane().removeAll();
        c.insets = new Insets(10, 0, 5, 0);
        c.gridx = 0;
        c.gridy = 0;
        add(new JLabel("Nhập mã xe"), c);
        c.gridx = 1;
        c.gridy = 0;
        idBikeField = new JTextField(15);
        add(idBikeField, c);

        c.insets = new Insets(0, 0, 5, 0);
        c.gridx = 0;
        c.gridy = 1;
        closeButton = new JButton("Thoát");
        add(closeButton, c);
        c.gridx = 1;
        c.gridy = 1;
        rentButton = new JButton("Thuê");
        add(rentButton, c);

        this.revalidate();
        this.repaint();
        this.pack();
        this.setResizable(false);
    }


}
