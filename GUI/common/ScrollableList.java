package common;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import file.Localization;
import main.DTAColor;
import main.DTAText;

@SuppressWarnings("serial")
public class ScrollableList<E> extends JScrollPane {

	// Component
	private JList<E> list = new JList<>();

	public ScrollableList(String name) {
		// Set View
		this.setBackground(DTAColor.BACKGROUND);
		this.list.setBackground(Color.WHITE);
		this.list.setBorder(new TitledBorder(new LineBorder(DTAColor.BORDER), name));

		// Set Attributes
		this.setBackground(Color.WHITE);
		this.setViewportView(list);
		this.setPreferredSize(new Dimension(250, 830));
	}
	
	public void setListData(Vector<E> listData) {
		this.list.setListData(listData);
		this.list.updateUI();
	}

}
