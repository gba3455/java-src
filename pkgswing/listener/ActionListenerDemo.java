package pkgswing.listener;
/**
 * 匿名内部类的方法
 */
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ActionListenerDemo extends JFrame{
	public ActionListenerDemo() {
		init();
		this.setTitle("listener Test");
		this.setSize(new Dimension(300,330));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		// TODO Auto-generated constructor stub
	}
	private void init(){
		JPanel panel = new JPanel();
		JButton button = new JButton("button");
		//注册监听器
		button.addActionListener(new ActionListener() {
			
			@Override
			//触发事件后的执行方式
			public void actionPerformed(ActionEvent e) {
				//获得事件源 以上转型对象的形式调用
				Object obj = e.getSource();
				//下朔
				JButton button2 = (JButton)obj;
				if(button2.getText().equals("button")){
					button2.setText("close");
				}
				else{
					button2.setText("button");
				}
			}
		});
		panel.add(button);
		this.add(panel);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ActionListenerDemo();
	}

}
