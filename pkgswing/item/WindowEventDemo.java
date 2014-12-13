package pkgswing.item;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class WindowEventDemo extends JFrame{
	public WindowEventDemo() {
		// TODO Auto-generated constructor stub
		this.setTitle("WindowEvent");
		this.setSize(new Dimension(300,330));
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
//		this.addWindowListener(new WindowListener() {

//			@Override
//			public void windowOpened(java.awt.event.WindowEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("windowOpened");
//			}
//
//			@Override
//			public void windowClosing(java.awt.event.WindowEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("windowClosing");
//				System.exit(0);//安全退出
////				WindowEventDemo.this.dispose();//销毁窗口
//				
//			}
//
//			@Override
//			public void windowClosed(java.awt.event.WindowEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("windowClosed");
//				
//			}
//
//			@Override
//			public void windowIconified(java.awt.event.WindowEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("windowIconified");
//				
//			}
//
//			@Override
//			public void windowDeiconified(java.awt.event.WindowEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("windowDeiconified");
//				
//			}
//
//			@Override
//			public void windowActivated(java.awt.event.WindowEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("windowActivated");
//				
//			}
//
//			@Override
//			public void windowDeactivated(java.awt.event.WindowEvent e) {
//				// TODO Auto-generated method stub
//				System.out.println("windowDeactivated");
//				
//			}
			
//		});
		//适配器 实现接口的抽象类
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("trying to closing");
				System.exit(0);
			}
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Closed");
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WindowEventDemo();
	}

}
