package pkgswing.listener;
/**
 *外部类的方法
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ActionListenerDemo2 extends JFrame{
	JButton button = new JButton("button");
	JButton buttonSet = new JButton("设置");
	JTextField textField = new JTextField("文本框");
	JPanel panelSouth = new JPanel();
	
	public ActionListenerDemo2() {
		init();
		this.setTitle("listener Test");
		this.setSize(new Dimension(300,330));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		// TODO Auto-generated constructor stub
	}
	private void init(){
		Button_ActionLIstener actionlistener = new Button_ActionLIstener(this);
		JPanel panel = new JPanel();
		textField.setPreferredSize(new Dimension(120,24));
		//注册监听器
		button.addActionListener(actionlistener);
		buttonSet.addActionListener(actionlistener);
		//设置标志位
		button.setActionCommand("close");
		
		buttonSet.setActionCommand("SouthPanel is open");
		panel.add(buttonSet);
		panel.add(button);
		panel.add(textField);
		
		JTextArea textArea = new JTextArea(10,20);
		JScrollPane scrollPane = new JScrollPane(textArea);
		panelSouth.add(scrollPane);
//		panelSouth.setVisible(false);
		this.add(panel);
		//设置首选大小
		panelSouth.setPreferredSize(new Dimension(300, 230));
		this.add(panelSouth,BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ActionListenerDemo2();
	}

}
