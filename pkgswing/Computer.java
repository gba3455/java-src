package pkgswing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

public class Computer extends JFrame{
	Computer(){
		init();
		this.setTitle("java计算器");
		this.setSize(new Dimension(300,250));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		this.pack();//fail
	}
	private void init(){
		northPanel();
		middlePanel();
	}
	private void northPanel(){
		JTextField textField = new JTextField(10);
		this.add("North",textField);
		
	}
	private void middlePanel(){
//		JPanel panel = new JPanel(new BorderLayout());
//		JPanel panelNorth = new JPanel();
//		JLabel label = new JLabel();
//		label.setPreferredSize(new Dimension(60,25));
//		label.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
//		JPanel centerPanel = new JPanel(new GridLayout(4, 5, 2, 2));
//		String[][] arr = new String[][]{{"7","8","9","/","sqrt"},
//											{"4","5","6","*","%"},
//											{"1","2","3","-","1/x"},
//											{"0","+/-",".","+","="}};
//		for(int i = 0; i < 4; i++){
//			for(int j = 0; j < 5; j++){
//				centerPanel.add(new JButton(arr[i][j]));
//			}
//		}
//		panelNorth.add(label);
//		panelNorth.add(new JButton("BackSpace"));
//		panelNorth.add(new JButton("CE"));
//		panelNorth.add(new JButton("C"));
//		panel.add("North",panelNorth);
//		panel.add("Center",centerPanel);
//		this.add(panel);
		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel north = new JPanel();
		JPanel center = new JPanel(new GridLayout(4, 5));
		JLabel label = new JLabel();
		label.setPreferredSize(new Dimension(60,20));
		label.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		north.add(label);
		north.add(new JButton("BackSpace"));
		north.add(new JButton("CE"));
		north.add(new JButton("C"));
		String[][] arr = new String[][]{
				{"7","8","9","/","sqrt"},
				{"4","5","6","*","%"},
				{"1","2","3","-","1/x"},
				{"0","+/-",".","+","="}
		};
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 5; j++){
				center.add(new JButton(arr[i][j]));
			}
		}
		panel.add("North",north);
		panel.add(center,BorderLayout.CENTER);
		this.add("Center",panel);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Computer();
	}

}
