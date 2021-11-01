package abstractdata.gui;

import javax.swing.*;

import abstractdata.controller.IDataManageController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public abstract class ADataEditDialog<T> extends JDialog {
	protected T t;
	protected GridBagLayout layout;
	protected GridBagConstraints c = new GridBagConstraints();

	public ADataEditDialog(T t, IDataManageController<T> controller) {
		super((Frame) null, "Edit", true);

		this.t = t;

		setContentPane(new JPanel());

		layout = new GridBagLayout();
		getContentPane().setLayout(layout);

		this.buildControls();

		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validateInput()) {
					T newT = getNewData();
					controller.onAct(newT);
					ADataEditDialog.this.dispose();
				} else {
					JOptionPane.showMessageDialog(ADataEditDialog.this, "Các trường nhập vào không đúng!");
				}
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
