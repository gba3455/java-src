package pkgswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
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

public class TestBoxLayout extends JFrame {
	//网状方式显示
	public TestBoxLayout() {
		northPanel();
		init();
		this.setTitle("盒式布局");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(500, 550));
		this.setLocationRelativeTo(null);// 居中
		this.setVisible(true);
		//自动调整最佳尺寸
		this.pack();
	}
	
	private void northPanel(){
		Box box = Box.createHorizontalBox();
		box.add(Box.createHorizontalStrut(20));//横向撑开20
		box.add(Box.createVerticalStrut(50));//纵向撑开50
		box.add(new JButton("按钮1"));
		box.add(Box.createHorizontalGlue());//让按钮之间自动分开
		box.add(new JLabel("标签1"));
		box.add(Box.createHorizontalGlue());//让按钮之间自动分开
		box.add(new JButton("按钮1"));
		box.add(Box.createHorizontalStrut(20));//横向撑开20
		box.setBorder(BorderFactory.createLineBorder(Color.red));
		
		this.add("North",box);
	}
	private void init(){
		JPanel panel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxLayout);
		for(int i = 1; i <= 4; i++){
			for(int j = 1; j <= 5; j++){
				JButton button = new JButton(i + "*" + j);
				panel.add(button);
			}
		}
		this.add(panel);
	}
	public static void main(String[] args) {
		new TestBoxLayout();
	}
}
