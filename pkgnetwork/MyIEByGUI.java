package pkgnetwork;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;

public class MyIEByGUI extends JFrame{
	private Frame f;
	private TextField tf;
	private Button but;
	private TextArea ta;
	private Dialog d;
	private Label lab;
	private Button okBut;
public MyIEByGUI() {
	init();
}
	
	private void init() {
		f = new Frame("my window");
		f.setBounds(300, 100, 600, 500);
		f.setLayout(new FlowLayout());
		
		tf = new TextField(60);
		
		but = new Button("转到");
		
		ta = new TextArea(25,60);
		
		d = new Dialog(f,"提示信息-self",true);
		d.setBounds(400, 200, 240, 150);
		d.setLayout(new FlowLayout());
		lab = new Label();
		okBut = new Button("确定");
		
		d.add(lab);
		d.add(okBut);
		
		f.add(tf);
		f.add(but);
		f.add(ta);
		
		myEvent();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
}

	private void myEvent() {
		okBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				d.setVisible(false);
			}
		});
		d.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				d.setVisible(false);
			}
		});
		tf.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					showDir();
				}
			}
		});
		but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showDir();
			}

		});
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}
		});
	}
		private void showDir() {
			ta.setText("");
			//目录浏览
//			String dirPath = tf.getText();
//			File dir = new File(dirPath);
//			
//			if(dir.exists() && dir.isDirectory()){
//				ta.setText("");
//				String[] names = dir.list();
//				for(String name : names){
//					ta.append(name + "\r\n");
//				}
//			}else{
//				String info = "Error For The Path of" + dirPath ;
//				lab.setText(info);
//				d.setVisible(true);
//			}
			//网页内容浏览
//			String url = tf.getText();//http://192.168.1.101:8080/index.html
			
//			int index1 = url.indexOf("//") + 2;
//			
//			int index2 = url.indexOf("/",index1);
//			
//			String str = url.substring(index1,index2);
//			
//			String[] arr = str.split(":");
//			
//			String host = arr[0];
//			int port = Integer.parseInt(arr[1]);
//			
//			String path = url.substring(index2);
//			
//			ta.append(str + "\r\n");
//			ta.append(path);
//			
//			try {
//				Socket s = new Socket(host, port);
//				PrintWriter out = new PrintWriter(s.getOutputStream(),true);
//				
//				out.println("GET / HTTP/1.1");
//				out.println("Host: 192.168.1.101:8080 DNT: 1 ");
//				out.println("Connection: keep-alive");
//				out.println("Accept:*/*");
//				out.println("Accept-Language: zh-cn");
//				
//				out.println();//这2个空行一定要.告诉服务器,http头已经结束.
//				out.println();
//				
//				System.out.println("2");
//				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//				String temp = null;
//				while((temp = br.readLine()) != null){
//					System.out.println(str);
//				}
//				System.out.println("3");
//				
//				s.close();
//			} catch (UnknownHostException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			String urlPath = tf.getText();//http://192.168.1.101:8080/index.html
			try {
				URL url = new URL(urlPath);
				
//				InputStream in = url.openStream();
//				
//				byte[] buf = new byte[1024 * 1024 * 5];
//				
//				int len = in.read(buf);
//				
//				ta.setText(new String(buf,0,len));
				
//				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
//				
//				String temp = null;
//				while((temp = br.readLine()) != null){
//					ta.append(temp + "\r\n");
//				}
				
				ta.setText((String)url.getContent());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	public static void main(String[] args) {
		new MyIEByGUI();
	}

}
