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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

public class TestJMenu extends JFrame {
	//网状方式显示
	public TestJMenu() {
		addJMenu();
		northPanel();
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
	private void addJMenu(){
		//菜单条
		JMenuBar menuBar = new JMenuBar();
		//菜单项
		JMenu menuG = new JMenu("游戏");
		JMenuItem menuItem1 = new JMenuItem("开始");
		JMenuItem menuItem2 = new JMenuItem("初级");
		JMenuItem menuItem3 = new JMenuItem("中级");
		JMenuItem menuItem4 = new JMenuItem("高级");
		JMenuItem menuItem7 = new JMenuItem("退出");
		menuG.add(menuItem1);
		menuG.addSeparator();//加入分割线
		menuG.add(menuItem2);
		menuG.addSeparator();//加入分割线
		menuG.add(menuItem3);
		menuG.addSeparator();//加入分割线
		menuG.add(menuItem4);
		menuG.addSeparator();//加入分割线
		menuG.add(menuItem7);
		JMenu menuH = new JMenu("Help");
		
		JMenuItem menuItem5 = new JMenuItem("关于扫雷");
		JMenuItem menuItem6 = new JMenuItem("帮助信息");
		menuH.add(menuItem5);
		menuH.addSeparator();//加入分割线
		menuH.add(menuItem6);
		//菜单项加入菜单
		menuBar.add(menuG);
		menuBar.add(menuH);
		//把菜单条设置给窗口
		this.setJMenuBar(menuBar);
		
	}
	public static void main(String[] args) {
//		//设置皮肤
		//[The Microsoft Windows Look and Feel - com.sun.java.swing.plaf.windows.WindowsLookAndFeel] not supported on this platform
		// com.sun.java.swing.plaf.motif.MotifLookAndFeel
		//com.sun.java.swing.plaf.windows.WindowsLookAndFeel
		// javax.swing.plaf.metal.MetalLookAndFeel
//		try {
//			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//获取系统默认皮肤
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InstantiationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (UnsupportedLookAndFeelException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		new TestJMenu();
	}
}
