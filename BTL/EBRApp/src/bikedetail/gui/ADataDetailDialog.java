package bikedetail.gui;

import bikedetail.controller.ListBikeInfoController;
import com.ebr.bean.Bike;

import javax.swing.*;
import java.awt.*;

public abstract class ADataDetailDialog<T> extends JDialog {
    protected Bike detail;
    protected GridBagLayout layout = new GridBagLayout();
    protected GridBagConstraints cons = new GridBagConstraints();

    protected ListBikeInfoController controller;

    public ADataDetailDialog(ListBikeInfoController controller, Bike detail){
        super((Frame) null, "Detail", true);
        this.detail = detail;
        this.controller = controller;

        buildControls();
        updateData(detail);
    }

    protected int getLastRowIndex() {
        layout.layoutContainer(getContentPane());
        int[][] dim = layout.getLayoutDimensions();
        int rows = dim[1].length;
        return rows;
    }

    public abstract void buildControls();

    public abstract void updateData(Bike detail);
}
