package pkgiostream;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestFileGui extends JFrame{
	JPanel panelNorth = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelNorthLeft = new JPanel();
	JPanel panelNorthLeft1 = new JPanel();
	JPanel panelNorthLeft2 = new JPanel();
	JPanel panelNorthRight = new JPanel();
	JTextArea textArea = new JTextArea(14,24);
	JLabel label = new JLabel("输入目录:   ");
	JLabel labelEx = new JLabel("输入扩展名:");
	JTextField pathField = new JTextField();
	JTextField pathFieldEx = new JTextField();
	JButton dir_Btn = new JButton("Get");
	public TestFileGui() {
		init();
		this.setTitle("TestFileGui");
		this.setSize(new Dimension(300,330));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.pack();
	}
	private void init(){
		pathField.setPreferredSize(new Dimension(180,24));
		pathFieldEx.setPreferredSize(new Dimension(180,24));
		dir_Btn.setPreferredSize(new Dimension(40,60));
		TestFileActionListener tfal = new TestFileActionListener(this);
		dir_Btn.addActionListener(tfal);
		panelNorthLeft.setLayout(new BorderLayout());
		panelNorthLeft1.add(label);
		panelNorthLeft1.add(pathField);
		panelNorthLeft2.add(labelEx);
		panelNorthLeft2.add(pathFieldEx);
		panelNorthLeft.add(panelNorthLeft1,BorderLayout.NORTH);
		panelNorthLeft.add(panelNorthLeft2);
		panelNorthRight.add(dir_Btn);
		panelNorth.add(panelNorthLeft);
		panelNorth.add(panelNorthRight);
		panelCenter.add(new JScrollPane(textArea));
		this.add(panelNorth,BorderLayout.NORTH);
		this.add(panelCenter);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestFileGui();
	}

}
