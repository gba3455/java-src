package pkgswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TestGirdLayout extends JFrame {
	//网状方式显示
	public TestGirdLayout() {
		init();
		this.setTitle("网格布局");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(500, 550));
		this.setLocationRelativeTo(null);// 居中
		this.setVisible(true);
		//自动调整最佳尺寸
		this.pack();
	}
	private void init(){
		JPanel panel = new JPanel(new GridLayout(4, 5));
//		JPanel panel = new JPanel(new GridLayout(4, 5,1,1));//指定间距
		for(int i = 1; i <= 4; i++){
			for(int j = 1; j <= 5; j++){
				JButton button = new JButton(i + "*" + j);
				panel.add(button);
			}
		}
		this.add(panel);
	}
	public static void main(String[] args) {
		new TestGirdLayout();
	}
}
