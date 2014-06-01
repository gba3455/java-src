package pkginner;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


public class AInner{
	public static void main(String[] args){
		final JFrame frame = new JFrame("匿名内部类测试窗口");
		//匿名内部类 在方法调用的时候把整个类+对象的信息全部实现
		frame.addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent we){
				Color c = new Color(255,20,255);
				frame.setBackground(c);
				frame.addNotify();
			}
			public void windowClosing(WindowEvent we){
				System.out.println("窗口正在关闭。。。。");
				System.exit(0);//退出应用程序
			}
		});
		frame.setSize(200, 200);
		frame.setVisible(true);
	}
}
