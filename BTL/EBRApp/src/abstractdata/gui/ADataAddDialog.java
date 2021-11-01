package abstractdata.gui;

import javax.swing.*;

import com.ebr.bean.Bike;

import abstractdata.controller.IDataManageController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

@SuppressWarnings("serial")
public abstract class ADataAddDialog<T> extends JDialog {
	public T t ;
    protected GridBagLayout layout;
    protected GridBagConstraints c = new GridBagConstraints();

    public ADataAddDialog(T t, IDataManageController<T> controller) {
        super((Frame) null, "Add", true);

        this.t = t;
        setContentPane(new JPanel());
        layout = new GridBagLayout();
        getContentPane().setLayout(layout);
        
        this.buildControls();

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                T newT = getNewData();
                controller.onAct(newT);
                ADataAddDialog.this.dispose();
            }
        });

        c.gridx = 1;
        c.gridy = getLastRowIndex();
        getContentPane().add(saveButton, c);

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    protected int getLastRowIndex() {
        layout.layoutContainer(getContentPane());
        int[][] dim = layout.getLayoutDimensions();

        return dim[1].length;
    }

    public abstract void buildControls();

    public abstract T getNewData();
    
    public abstract boolean validateInput();
}
