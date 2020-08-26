package common;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;

import main.DTAColor;

@SuppressWarnings("serial")
public class ScrollableList<E> extends JScrollPane {
	// Component
	private JList<E> list = new JList<>();

	public ScrollableList(String name) {
		// Set View
		setBackground(DTAColor.BACKGROUND);
		setBorder(new TitledBorder(new LineBorder(DTAColor.BORDER), name));
		
		// Set Component Attributes
		list.setBackground(Color.WHITE);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Set Attributes
		setBackground(Color.WHITE);
		setViewportView(list);
		setPreferredSize(new Dimension(250, 695));
	}

	public void setListData(Vector<E> listData) {
		list.setListData(listData);
		list.updateUI();
	}

	public void addListSelectionListener(ListSelectionListener l) {
		list.addListSelectionListener(l);
	}

	public int getSelectedIndex() {
		return list.getSelectedIndex();
	}

	public void previous() {
		// Exception Processing
		if (list.getSelectedIndex() < 1) { return; }
		
		list.setSelectedIndex(list.getSelectedIndex() - 1);
		list.updateUI();
	}

	public void next() {
		// Exception Processing
		if (list.getSelectedIndex() + 1 == list.getModel().getSize()) { return; }
		
		list.setSelectedIndex(list.getSelectedIndex() + 1);
		list.updateUI();
	}

	public void setSelectedIndex(int i) {
		list.setSelectedIndex(i);
	}

}
