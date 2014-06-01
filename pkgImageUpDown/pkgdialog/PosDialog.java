package pkgImageUpDown.pkgdialog;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pkgImageUpDown.pkgframe.MainFrame;
import pkgImageUpDown.pkgtools.StaticTools;

public class PosDialog extends JDialog{
	private JLabel label_x1;
	private JLabel label_x2;
	private JLabel label_y1;
	private JLabel label_y2;
	private JPanel jPanel;
	MainFrame mainFrame = null;
	public PosDialog(MainFrame mainFrame){
		this.mainFrame = mainFrame;
		this.add(getPanel());
		this.setSize(new Dimension(100,50));
		this.setBounds(0, 20, 100, 50);
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	}

	public JLabel getLabel_x1() {
		return label_x1;
	}

	public JLabel getLabel_x2() {
		return label_x2;
	}

	public JLabel getLabel_y1() {
		return label_y1;
	}

	public JLabel getLabel_y2() {
		return label_y2;
	}

	private JPanel getPanel() {
		label_x1 = new JLabel();
		label_x2 = new JLabel();
		label_y1 = new JLabel();
		label_y2 = new JLabel();
		
		label_x1.setText("x1:" + StaticTools.x1);
		label_y1.setText("y1:" + StaticTools.y1);
		label_x2.setText("x2:" + StaticTools.x2);
		label_y2.setText("y2:" + StaticTools.y2);
		
		Box boxLeft = Box.createVerticalBox();
		boxLeft.add(label_x1);
		boxLeft.add(Box.createVerticalGlue());
		boxLeft.add(label_y1);
		
		Box boxRight = Box.createVerticalBox();
		boxRight.add(label_x2);
		boxRight.add(Box.createVerticalGlue());
		boxRight.add(label_y2);
		
		Box box = Box.createHorizontalBox();
		box.add(boxLeft);
		box.add(Box.createHorizontalGlue());
		box.add(boxRight);
		
		jPanel = new JPanel();
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
		jPanel.add(box);
		return jPanel;
		
	}
	public static void main(String[] args) {
//		new PosDialog(mainFrame);
	}
}
