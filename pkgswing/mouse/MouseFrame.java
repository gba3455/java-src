package pkgswing.mouse;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseFrame extends JFrame{
	Icon iconStart = new ImageIcon("./image/serverstart.gif");
	Icon iconStop = new ImageIcon("./image/serverstop.gif");
	JLabel label = new JLabel(iconStart);
	public MouseFrame() {
		JPanel panel = new JPanel();
		label.setBorder(BorderFactory.createLineBorder(Color.blue));
		label.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("释放");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("按下");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("退出");
				label.setIcon(iconStart);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("进入");				
				//图片变静止
				label.setIcon(iconStop);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("点击");				
			}
		});
		panel.add(label);
		this.add(panel);
		this.setTitle("鼠标事件");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(300,330));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new MouseFrame();
	}
}
