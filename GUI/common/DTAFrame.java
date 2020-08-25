package common;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import main.DTAPath;

@SuppressWarnings("serial")
public class DTAFrame extends JFrame {
	
	public DTAFrame() {
		//Set Attributes
		setIconImage(new ImageIcon(DTAPath.FRAME_ICON_IMAGE).getImage());
	}

}
