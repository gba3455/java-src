package pkgswing;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class FenGeMianBan extends JFrame{
	private void init(){
//		//标题面板
//		JTabbedPane tabbedPane = new JTabbedPane();
//		tabbedPane.add("title1", new JButton("title1"));
//		tabbedPane.add("title2", new JButton("title2"));
//		this.add(tabbedPane);
		
		//分割面板
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel1.add(new JButton("button1"));
		panel2.add(new JButton("button2"));
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panel1,panel2);
		//设置分割线的位置 
		splitPane.setDividerLocation(100);
		//在默认情况下值为0表示右边/底部的组件获得所有额外空间（左边/顶部的组件固定）
		//而值为1表示左边/顶部的组件获得所有额外空间（右边/底部的组件固定）
		splitPane.setResizeWeight(1);
		this.add(splitPane);
	}
	public FenGeMianBan() {
		// TODO Auto-generated constructor stub
		init();
		this.setTitle("title");
		this.setSize(new Dimension(300, 330));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FenGeMianBan();
	}

}
