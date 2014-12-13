package pkdefault;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator extends JFrame{
	JTextField field1,field2,field3;
	String[] arr = {"+","-","*","/"};
	JComboBox comboBox = new JComboBox(arr);
	
	JPanel panel = new JPanel();
	public Calculator() {
		// TODO Auto-generated constructor stub
		init();
		this.setTitle("test");
		this.setSize(new Dimension(400,100));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
private void init(){
	JButton button = new JButton("=");
	button.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	});
	comboBox.addItemListener(new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			int selected = e.getStateChange();
			System.out.println(selected);
		}
	});
	field1 = new JTextField();
	field1.setPreferredSize(new Dimension(40,24));
	field2 = new JTextField();
	field2.setPreferredSize(new Dimension(40,24));
	field3 = new JTextField();
	field3.setPreferredSize(new Dimension(40,24));
	
	panel.add(field1);
	panel.add(comboBox);
	panel.add(field2);
	panel.add(button);
	panel.add(field3);
	this.add(panel);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator();
	}

}
