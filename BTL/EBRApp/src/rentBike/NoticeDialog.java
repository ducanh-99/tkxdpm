package rentBike;

import javax.swing.*;
import java.awt.*;

public class NoticeDialog  extends JDialog {
    private GridBagLayout layout;
    private GridBagConstraints c;

    private JLabel noticeLabel;

    private NoticeDialog mySelf;

    private RentBikeController controller;

    public NoticeDialog() {
        layout = new GridBagLayout();
        this.setLayout(layout);
        c = new GridBagConstraints();
        addControl();
        addEvent();
    }
    private void addEvent() {
    }
    private void addControl() {
        mySelf = this;
        this.setTitle("THÔNG Báo");
        this.getContentPane().removeAll();
        c.insets = new Insets(10, 0, 5, 0);
        c.gridx = 0;
        c.gridy = 0;
        noticeLabel = new JLabel("Không tồn tại thông tin !");
        add(noticeLabel, c);

        this.revalidate();
        this.repaint();
        this.pack();
        this.setResizable(false);
    }
}
