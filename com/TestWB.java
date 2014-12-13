package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;

public class TestWB {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWB window = new TestWB();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestWB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TestWB.class.getResource("/pkgqq/image/client/total/qqbanner1.jpg")));
		panel.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		JLabel label_1 = new JLabel("账号:");
		panel_3.add(label_1);
		
		textField = new JTextField();
		textField.setText("00001");
		textField.setColumns(10);
		panel_3.add(textField);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.NORTH);
		
		JLabel label_2 = new JLabel("密码:");
		panel_5.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_5.add(textField_1);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.NORTH);
		
		JButton button = new JButton("设置");
		button.setSelectedIcon(new ImageIcon(TestWB.class.getResource("/pkgqq/image/client/total/mouseover.gif")));
		button.setIcon(new ImageIcon(TestWB.class.getResource("/pkgqq/image/client/total/mousenormal.gif")));
		panel_7.add(button);
		
		Component horizontalStrut = Box.createHorizontalStrut(80);
		panel_7.add(horizontalStrut);
		
		JButton button_1 = new JButton("登陆");
		panel_7.add(button_1);
		
		JPanel panel_9 = new JPanel();
		panel_6.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.Y_AXIS));
		
		JPanel panel_8 = new JPanel();
		panel_9.add(panel_8);
		
		JLabel label_3 = new JLabel("IP地址:");
		panel_8.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setText("127.0.0.1");
		textField_2.setColumns(10);
		panel_8.add(textField_2);
		
		JPanel panel_10 = new JPanel();
		panel_9.add(panel_10);
		
		JLabel label_4 = new JLabel("端口号");
		panel_10.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setText("8099");
		textField_3.setColumns(10);
		panel_10.add(textField_3);
	}

}
