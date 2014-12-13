package pkgmine.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import pkgmine.panel.FaceJpanel;
import pkgmine.panel.MineJMenuBar;
import pkgmine.panel.MineJPanel;
import pkgmine.timer.TimerActionListener;
import pkgmine.tools.StaticTools;

public class MainFrame extends JFrame{
	static{
				try {
					//将外观设置为系统外观
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	private static final long serialVersionUID = 1L;
	private MineJPanel mineJPanel = new MineJPanel(this);
	private FaceJpanel faceJpanel = new FaceJpanel(this);
	private MineJMenuBar mineJMenuBar = new MineJMenuBar(this);
	//设置定时器
	private TimerActionListener timerActionListener = new TimerActionListener(this);
	private Timer timer = new Timer(1000,timerActionListener);
	public MainFrame(){
		initFrame();
		this.setTitle("扫雷");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	private void initFrame() {
		this.setJMenuBar(mineJMenuBar);
		this.add(faceJpanel,BorderLayout.NORTH);
		this.add(mineJPanel,BorderLayout.CENTER);
	}
	
	public MineJPanel getMineJPanel() {
		return mineJPanel;
	}
	public FaceJpanel getFaceJpanel() {
		return faceJpanel;
	}
	public Timer getTimer() {
		return timer;
	}
	public static void main(String[] args) {
		new MainFrame();
	}
	
	public void reStartGame(){
		//移除面板
		this.remove(faceJpanel);
		this.remove(mineJPanel);
		//停止计时器
		this.timer.stop();
		//还原数据 计时器数字 剩余雷数
		StaticTools.timeCount = 0;
		StaticTools.bombCount = StaticTools.allMineCount;
		StaticTools.isStart = false;
		//重新创建表情面板和雷区面板
		faceJpanel = new FaceJpanel(this);
		mineJPanel = new MineJPanel(this);
		this.add(faceJpanel,BorderLayout.NORTH);
		this.add(mineJPanel,BorderLayout.SOUTH);
		//需要刷新才可以出来
		this.pack();
		this.setLocationRelativeTo(null);
		this.validate();
	}
}
