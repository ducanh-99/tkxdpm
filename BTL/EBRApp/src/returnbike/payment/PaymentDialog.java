package returnbike.payment;

import rentBike.NoticeDialog;
import staticdata.PaymentData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentDialog extends JDialog {
    private JLabel viewNumber;
    private JLabel viewName;
    private JTextField number;
    private JTextField name;

    private GridBagLayout layout;
    private GridBagConstraints c;

    private IPaymentController controller;


    public PaymentDialog(IPaymentController controller) {
        super((Frame) null, "Payment", true);

        viewNumber = new JLabel("Số tài khoản: ");
        viewName = new JLabel("Tên chủ tài khoản: ");
        name = new JTextField(15);
        number = new JTextField(15);

        try {
            if (PaymentData.owner.length() != 0) {
                name.setText(PaymentData.owner);
            }

            if (PaymentData.accountNumber.length() != 0) {
                number.setText(PaymentData.accountNumber);
            }

            System.out.println("PaymentDialog được khởi tạo");
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        this.controller = controller;

        setContentPane(new JPanel());
        layout = new GridBagLayout();
        getContentPane().setLayout(layout);
        c = new GridBagConstraints();

        c.gridy = getLastRowIndex();
        c.gridx = 1;
        getContentPane().add(viewName, c);
        c.gridx = 2;
        getContentPane().add(name, c);


        c.gridy = getLastRowIndex();
        c.gridx = 1;
        getContentPane().add(viewNumber, c);
        c.gridx = 2;
        getContentPane().add(number, c);

        JButton submitButton = new JButton("Xác nhận");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (new CheckAccountParams().checkPaymentParams(name.getText(), number.getText())) {
                    PaymentData.owner = name.getText();
                    PaymentData.accountNumber = number.getText();
                    controller.pay(PaymentData.accountNumber);
                    PaymentDialog.this.dispose();
                } else {
                    System.out.println("Nhập sai định dạng tài khoản ! :)");
                    new NoticeDialog().setVisible(true);
                }
            }

        });
        c.gridx = 1;
        c.gridy = getLastRowIndex();
        getContentPane().add(submitButton, c);

        JButton cancelButton = new JButton("Hủy bỏ");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaymentDialog.this.dispose();
            }
        });
        c.gridx = 2;
        getContentPane().add(cancelButton, c);

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    private int getLastRowIndex() {
        layout.layoutContainer(getContentPane());
        int[][] dim = layout.getLayoutDimensions();

        int rows = dim[1].length;
        return rows;
    }


}
