package returnbike.gui;

import abstractdata.gui.ADataSinglePane;
import com.ebr.bean.Bike;
import com.ebr.bean.Order;
import returnbike.caculatingmethod.CalculatingMethod;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReturnBikeSinglePane extends ADataSinglePane<Order> {
    private JPanel panel;
    private final Bike bike;
    private JLabel bikeID;
    private JLabel checkin;
    private JLabel difference;
    private JLabel current;
    private JLabel amount;
    private long diffmilis;
    private final CalculatingMethod calculatingMethod;

    public ReturnBikeSinglePane(Order order, Bike bike, CalculatingMethod calculatingMethod) {
        this.calculatingMethod = calculatingMethod;
        this.t = order;
        this.bike = bike;
        buildControl();
        updateData(order);
    }

    public void buildControl() {
        super.buildControls();

        layout = new GridBagLayout();
        this.setLayout(layout);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        c.ipady=10;

        c.weightx = 1;

        int row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        bikeID = new JLabel();
        add(bikeID, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        checkin = new JLabel();
        add(checkin, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        current = new JLabel();
        add(current, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        difference = new JLabel();
        add(difference, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        amount = new JLabel();
        add(amount, c);

        setFont();
    }

    private void setFont() {
        Font font = new Font("Serif", Font.BOLD, 20);

        bikeID.setFont(font);
        checkin.setFont(font);
        difference.setFont(font);
        current.setFont(font);
        amount.setFont(font);
    }

    public void updateData(Order order) {
        this.t = order;
        bikeID.setText("ID của xe: "+order.getBikeID());
        checkin.setText("Thời điểm lấy xe: "+formatDate(order.getCheckin()));
        current.setText("Thời gian hiện tại: "+formatDate(new Date()));
        difference.setText("Tổng thời gian thuê: "+getDifference());
        amount.setText("Tổng số tiền: "+calculateAmount());
    }

    @Override
    public void displayData() {
        updateData(t);
    }

    public void addDataHandlingComponent(Component component) {
        if (panel == null) {
            int row = getLastRowIndex();
            c.gridx = 0;
            c.gridy = row;
            panel = new JPanel();
            this.add(panel, c);
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        }

        panel.add(component);
    }

    public Order getT() {
        return this.t;
    }

    private String getDifference() {
        Date current = new Date();
        diffmilis = Math.abs(current.getTime() - t.getCheckin().getTime());

        return String.format("%02d:%02d:%02d", diffmilis/(3600*1000),
                diffmilis/(60*1000) % 60,
                diffmilis/1000 % 60);
    }

    private String formatDate(Date date) {
        String pattern = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        return simpleDateFormat.format(date);
    }

    private float calculateAmount() {
        getDifference();

        long seconds = (diffmilis/1000);

        t.setAmount(calculatingMethod.count(seconds, bike.getType()));

        return t.getAmount();
    }
}
