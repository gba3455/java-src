package pkgswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class TestBorderLayout extends JFrame {
	//边框布局 顶层容器都是边框布局
		//东南西北中 默认居中
	public TestBorderLayout() {
		
		JButton button = new JButton("中间按钮");
		JLabel label = new JLabel("标签北边");
		this.add(button);//相当于//		this.add(button,BorderLayout.CENTER);
		this.add(label,BorderLayout.NORTH);//加了标签后,按钮被覆盖
		this.add("West",new JButton("西边按钮"));
		this.add(new JButton("南边"),BorderLayout.SOUTH);
		this.add("East",new JButton("东边按钮"));
		this.setTitle("边框布局");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(500, 550));
		this.setLocationRelativeTo(null);// 居中
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TestBorderLayout();
	}
}
