package pkgmine.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import pkgmine.frame.MainFrame;
import pkgmine.tools.StaticTools;

/**
 * 笑脸类
 * 
 * @author SQZS
 * 
 */
public class FaceJpanel extends JPanel {
	private static final long serialVersionUID = 1L;
	MainFrame mainFrame;

	private JLabel faceLabel = new JLabel();
	private Box box = null;
	// 定义实例变量
	private JLabel labelCountG = new JLabel();
	private JLabel labelCountS = new JLabel();
	private JLabel labelCountB = new JLabel();
	private JLabel labelTimeG = new JLabel();
	private JLabel labelTimeS = new JLabel();
	private JLabel labelTimeB = new JLabel();

	private boolean downPress = false;

	private boolean isIn = false;
	private boolean stop = false;

	public FaceJpanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setLayout(new BorderLayout());
		Border border = BorderFactory.createEmptyBorder(5, 5, 2, 5);
		Border border1 = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
		Border border3 = BorderFactory.createEmptyBorder(5, 2, 2, 2);
		Border border2 = BorderFactory.createCompoundBorder(border1, border3);
		JPanel jp = new JPanel(new BorderLayout());
		jp.setBackground(Color.LIGHT_GRAY);
		jp.add(getBox());
		jp.setBorder(border2);
		this.add(jp);
		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(border);
	}

	public Box getBox() {
		box = Box.createHorizontalBox();
		box.add(Box.createHorizontalStrut(5));
		box.add(labelCountB);
		box.add(labelCountS);
		box.add(labelCountG);
		box.add(Box.createHorizontalGlue());
		box.add(faceLabel);
		box.add(Box.createHorizontalGlue());
		box.add(labelTimeB);
		box.add(labelTimeS);
		box.add(labelTimeG);
		box.add(Box.createHorizontalStrut(5));
		
		setRemainNumber(StaticTools.allMineCount);
		
		setTime(StaticTools.timeCount);

		faceLabel.setIcon(StaticTools.smileIcon);
		faceLabel.addMouseListener(new FaceLabel_MouseListener());
		return box;
	}

	class FaceLabel_MouseListener extends MouseAdapter {
		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
				faceLabel.setIcon(StaticTools.smileIcon);
				mainFrame.getTimer().start();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// 换成下层表情
			if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
				faceLabel.setIcon(StaticTools.smileDownIcon);
				mainFrame.getTimer().stop();
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {

			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getModifiers() == MouseEvent.BUTTON1_MASK) {
				mainFrame.reStartGame();
			}
		}
	}

	// 修改时间Method
	public void setTime(int count) {
		int g = count % 10;
		int s = count / 10 % 10;
		int b = count / 100;

		labelTimeG.setIcon(StaticTools.timeImageIcons[g]);
		labelTimeS.setIcon(StaticTools.timeImageIcons[s]);
		labelTimeB.setIcon(StaticTools.timeImageIcons[b]);
	}

	// 修改数量
	public void setRemainNumber(int count) {
		int b = 0;
		if (count < 0) {
			b = 10;
		} else {
			b = count / 100;
		}
		int g = Math.abs(count) % 10;
		int s = Math.abs(count) / 10 % 10;

		labelCountG.setIcon(StaticTools.timeImageIcons[g]);
		labelCountS.setIcon(StaticTools.timeImageIcons[s]);
		labelCountB.setIcon(StaticTools.timeImageIcons[b]);
	}

	public JLabel getFaceLabel() {
		return faceLabel;
	}

	public void setFaceLabel(JLabel faceButton) {
		this.faceLabel = faceButton;
	}
}
