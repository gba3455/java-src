package pkgswing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Login extends JFrame{
	Login(){
		init();
		this.setTitle("用户登录");
		this.setSize(new Dimension(300,500));
		this.setPreferredSize(new Dimension(300,500));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
//		this.pack();
	}
	private void init(){
		menu();
		center();
		
	}
	private void center(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JPanel userPanel = new JPanel();
		JPanel passPanel1 = new JPanel();
		JPanel passPanel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		
		
		JLabel label = new JLabel("用户名:");
		panel.setBounds(1, 1, 100, 23);
		JTextField textField = new JTextField(15);
		textField.setBounds(1, 2, 100, 23);
		
		JLabel passlabel = new JLabel("密码:");
		JPasswordField passworld1 = new JPasswordField(15);
		passworld1.setEchoChar('*');
		
		JLabel cofirmpasslabel = new JLabel("确认密码:");
		JPasswordField passwrold2 = new JPasswordField(15);
		passwrold2.setEchoChar('*');
		userPanel.add(label);
		userPanel.add(textField);
		
		passPanel1.add(passlabel);
		passPanel1.add(passworld1);
		
		passPanel2.add(cofirmpasslabel);
		passPanel2.add(passwrold2);
		
		JLabel sex = new JLabel("性别:");
		
		JRadioButton man = new JRadioButton("男");
		JRadioButton woman = new JRadioButton("女");
		ButtonGroup bg = new ButtonGroup();
		bg.add(man);
		bg.add(woman);
		panel3.add(sex);
		panel3.add(man);
		panel3.add(woman);
		
		panel.add(userPanel);
		panel.add(passPanel1);
		panel.add(passPanel2);
		panel.add(panel3);
		this.add(panel);
	}
	private void menu(){
		JMenuBar menuBar = new JMenuBar();
		
		JMenu jmenu1 = new JMenu("文件(F)");
		JMenu jmenu2 = new JMenu("帮助(H)");
		
		JMenuItem item1 = new JMenuItem("打开(N)");
		JMenuItem item2 = new JMenuItem("导入(I)");
		JMenuItem item3 = new JMenuItem("导出(O)");
		JMenuItem item4 = new JMenuItem("关闭(X)");
		jmenu1.add(item1);
		jmenu1.add(item2);
		jmenu1.add(item3);
		jmenu1.add(item4);
		
		JMenuItem item5 = new JMenuItem("帮助(H)");
		JMenuItem item6 = new JMenuItem("关于(A)");
		jmenu2.add(item5);
		jmenu2.add(item6);
		
		menuBar.add(jmenu1);
		menuBar.add(jmenu2);
		
		this.add(menuBar,BorderLayout.NORTH);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new Login();
	}

}
