package bikedetail.gui;

import javax.swing.*;

public class ListBikeDataPagePane extends JPanel {
    public ListBikeDataPagePane(JPanel searchPane, JScrollPane listPane){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(searchPane);
        this.add(listPane);
    }
}
