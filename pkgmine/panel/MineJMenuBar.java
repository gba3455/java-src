package pkgmine.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import pkgmine.dialog.AboutDialog;
import pkgmine.dialog.HeroDialog;
import pkgmine.dialog.UserDefineDialog;
import pkgmine.frame.MainFrame;
import pkgmine.tools.StaticTools;
/**
 * 菜单类 
 * @author SQZS
 *
 */
public class MineJMenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	MainFrame mainFrame;
	private JMenu menuG = new JMenu("游戏(G)");

	private JMenu menuH = new JMenu("帮助(H)");

	public MineJMenuBar(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		init();
		this.add(menuG);
		this.add(menuH);
	}

	private void init() {
		// TODO Auto-generated method stub
		menuG.setMnemonic(KeyEvent.VK_G);
		
		JMenuItem jmi1 = new JMenuItem("开 局");
		jmi1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.reStartGame();
			}
		});
		JMenuItem jmi2 = new JMenuItem("初 级");
		jmi2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StaticTools.allRows = 9;
				StaticTools.allCols = 9;
				StaticTools.allMineCount = 10;
				mainFrame.reStartGame();
			}
		});
		JMenuItem jmi3 = new JMenuItem("中 级");
		jmi3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StaticTools.allRows = 16;
				StaticTools.allCols = 16;
				StaticTools.allMineCount = 40;
				mainFrame.reStartGame();
			}
		});
		JMenuItem jmi4 = new JMenuItem("高 级");
		jmi4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StaticTools.allRows = 16;
				StaticTools.allCols = 30;
				StaticTools.allMineCount = 99;
				mainFrame.reStartGame();
			}
		});
		JMenuItem jmi5 = new JMenuItem("自定义");
		
		jmi5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new UserDefineDialog(mainFrame);
			}
		});
		
		JMenu jmHero = new JMenu("扫雷英雄榜");
		JMenuItem jmiC = new JMenuItem("初级英雄榜");
		jmiC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new HeroDialog(1, mainFrame);
			}
		});
		JMenuItem jmiZ = new JMenuItem("中级英雄榜");
		jmiZ.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new HeroDialog(2, mainFrame);
			}
		});
		JMenuItem jmiG = new JMenuItem("高级英雄榜");
		jmiG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new HeroDialog(3, mainFrame);
			}
		});
		
		jmHero.add(jmiC);
		jmHero.add(jmiZ);
		jmHero.add(jmiG);
		
		JMenuItem jmi7 = new JMenuItem("退 出(Z)");
		jmi7.setMnemonic(KeyEvent.VK_Z);
		jmi7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		menuG.add(jmi1);
		menuG.add(new JSeparator());//分割线
		menuG.add(jmi2);
		menuG.add(jmi3);
		menuG.add(jmi4);
		menuG.add(jmi5);
		menuG.add(new JSeparator());//分割线
		menuG.add(jmHero);
		menuG.add(new JSeparator());//分割线
		menuG.add(jmi7);
		
		JMenuItem jmi8 = new JMenuItem("关于扫雷");
		jmi8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AboutDialog(mainFrame);
			}
		});
		JMenuItem jmi9 = new JMenuItem("后门进入");
		jmi9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StaticTools.backDoor = true;
				mainFrame.reStartGame();
			}
		});
		menuH.add(jmi8);
		menuH.add(jmi9);
		
	}
	
	
	
}
