package pkgswing.timer;

import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class TimerDemo extends JFrame{
	JButton buttonStart = new JButton("开始");
	JButton buttonStop = new JButton("停止");
	JTextArea textArea = new JTextArea(10,20);
	int count = 0;
	Timer timer = null;
	public TimerDemo(){
		JPanel panel = new JPanel();
		buttonStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.start();
			}
		});
		buttonStop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				count = 0;
				textArea.setText("");
			}
		});
		textArea.setEditable(false);
		panel.add(buttonStart);
		panel.add(buttonStop);
		panel.add(new JScrollPane(textArea));
		this.add(panel);
		this.setTitle("定时器");
		this.setSize(new Dimension(300,330));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		//间隔多少毫秒执行监听器里的内容
		timer = new Timer(1000,new MyTimerListener());
	}
	class MyTimerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			count++;
			textArea.append(count + "\n");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TimerDemo();
	}

}
