package pkgswing.item;

import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ItemEvnetDemo extends JFrame{
	JPanel panel = new JPanel();
	JTextField textField = new JTextField();
	String[] arr = {"初中","高中","大学"};
	JComboBox comboBox = new JComboBox(arr);
	ItemEvnetDemo(){
		init();
		this.setTitle("ItemEvent");
		this.setSize(new Dimension(300,330));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	private void init(){
		comboBox.addItemListener(new ItemListener() {
		//取消或选定时触发该事件	
			@Override
			public void itemStateChanged(ItemEvent e) {
				// 选定或取消的类型 int 1:选中 2:取消
				int selected = e.getStateChange();
				if(selected == 1){					
					String str = comboBox.getSelectedItem().toString();
					textField.setText(str);
				}
			}
		});
		textField.setPreferredSize(new Dimension(100,24));
		panel.add(comboBox);
		panel.add(textField);
		this.add(panel);
	}
	public static void main(String[] args) {
		new ItemEvnetDemo();
	}
}
