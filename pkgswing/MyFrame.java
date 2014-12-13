package pkgswing;

import java.awt.Color;
import java.awt.Dimension;
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

public class MyFrame extends JFrame{
	public MyFrame(){
				JPanel panel = new JPanel();
//				JPanel容器特性:
//					需加入JFrame才可见
//					 默认可见;
//					 默认布局: FlowLayout;
//					JPanel与JPanel可相互嵌套;
				
				//按钮
				JButton button = new JButton("按钮");
				button.setText("我的按钮");
				String getText = button.getText();
				System.out.println("text = " + getText);
				button.setPreferredSize(new Dimension(80,23));
				//设置文本到边界距离
				button.setMargin(new Insets(0, 0, 0, 0));
				button.setEnabled(false);//禁用按钮
				
				//文本框
				JTextField textField = new JTextField("文本框");
				textField.setForeground(Color.blue);
				//设置控件的首选大小
				textField.setPreferredSize(new Dimension(100,25));
				
				//标签
				JLabel label = new JLabel("标签");
				
				//图标
				Icon icon = new ImageIcon("./image/image.jpg");
				//设置图标
				label.setIcon(icon);
				//图片和图标还没排在一起
				//设置文字和图片的显示距离
				label.setHorizontalTextPosition(0);
				
				//密码框
				JPasswordField passwordField = new JPasswordField("888888",8);
				//设置显示字符
				passwordField.setEchoChar('*');
//				String password = passwordField.getText();//已经过时了
				String password = String.valueOf(passwordField.getPassword());
				System.out.println("密码" + password);
				//		passwordField.getPassword().toString();
				//文本域
				JTextArea textArea = new JTextArea("文本域是\n多行的文本框",10,20);
				//设置自动换行
				textArea.setLineWrap(true);
				//加入到滚动面板 滚动面板加入到中间面板
				JScrollPane scrollpane = new JScrollPane(textArea);
				//设置通用方法:不可编辑
				textArea.setEditable(true);
				//下拉框
				String[] arr = new String[]{"高中","初中","小学"};
				JComboBox comboBox = new JComboBox(arr);
				comboBox.setPreferredSize(new Dimension(90,22));
				//单选按钮
				JRadioButton radioButtonMan = new JRadioButton("男");
				JRadioButton radioButtonWoman = new JRadioButton("女");
				//互斥控件(否则2个同时可以选)
				ButtonGroup buttonGroup = new ButtonGroup();
				buttonGroup.add(radioButtonMan);
				buttonGroup.add(radioButtonWoman);
				
				JPanel panelSex = new JPanel();
				panelSex.add(new JLabel("性别:"));
				panelSex.add(radioButtonMan);
				panelSex.add(radioButtonWoman);
				panelSex.setBackground(Color.blue);
				
				panel.add(button);
				panel.add(textField);
				panel.add(label);
				panel.add(passwordField);
				panel.add(scrollpane);
				panel.add(comboBox);
				panel.add(panelSex);
				panel.setBackground(Color.WHITE);
				
				//边框
				Border border = BorderFactory.createTitledBorder("边框");
				Border borderEmpty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
//				Border borderEmpty = BorderFactory.createTitledBorder("边框2");
				//组合边框
				Border borderCom = BorderFactory.createCompoundBorder(borderEmpty, border);
				panel.setBorder(borderCom);
				//控件加入中间容器  --> 顶层容器

				Image image = new ImageIcon("./image/blood.gif").getImage();
				//设置窗口显示的图标
				this.setIconImage(image);
				this.add(panel);
				this.setTitle("我自己的窗口");
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setSize(new Dimension(500,550));
				this.setLocationRelativeTo(null);//居中
				this.setVisible(true);
				
//				//对话框
//				//JDialog具有和JFrame一样的特性
//				//JDialog分有模无模
//				//依附于窗口执行
				JDialog dialog = new JDialog(this,"第一个对话框");
				dialog.setSize(new Dimension(130,150));
				dialog.setSize(130, 150);
//				//关闭模式
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setLocationRelativeTo(this);
//				//默认无模
//				//设置有模
				dialog.setModal(true);
//				//可视化应该放在最后面
				dialog.setVisible(true);//对话框会占用当前的线程执行权,导致下面无法输出.对话框关闭后输出
//				
				System.out.println("main程序结束...");
	}
	public static void main(String[] args) {
		new MyFrame();
	}
}
