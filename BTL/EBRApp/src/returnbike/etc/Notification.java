package returnbike.etc;

import javax.swing.*;
import java.awt.*;

/**
 * @author phong.cv173298
 * @created 21/12/2020 - 11:58 PM
 * @project EBRApp
 */
public class Notification extends JDialog {
    private JLabel result;

    public Notification(String result) {
        this.result = new JLabel(result);

        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);

        this.add(this.result, BorderLayout.CENTER);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }
}
