package pkgswing;

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

public class TestFlowLayout extends JFrame {
	// 默认居中显示 一排一排的排列
	// 当超过边界 自动换行排列
	//调用控件的getPreferredSize()方法构建控件的大小
	public TestFlowLayout() {
		this.setLayout(new FlowLayout());
		
		JButton button = new JButton("按钮");
		JLabel label = new JLabel("标签");
		button.setPreferredSize(new Dimension(80,20));
		this.add(button);
		this.add(label);
		this.setTitle("流式布局");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(500, 550));
		this.setLocationRelativeTo(null);// 居中
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TestFlowLayout();
	}
}
