package pkgmine.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import pkgmine.bean.MineLabel;
import pkgmine.frame.MainFrame;
import pkgmine.listener.MineLabelMouseListener;
import pkgmine.tools.LayMines;
import pkgmine.tools.StaticTools;
/**
 * 雷区类
 * @author SQZS
 *
 */
public class MineJPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	//换成自己封装的MineLabel类型 
	private MineLabel[][] mineLabels;
	private MineLabelMouseListener labelMouseListener;
	private MainFrame mainFrame;
	public MineJPanel(MainFrame mainFrame){
		this.mainFrame = mainFrame;
		init();
	}
	public void init(){
		mineLabels = new MineLabel[StaticTools.allRows][StaticTools.allCols];
		Border border1 = BorderFactory.createLoweredBevelBorder();
		JPanel panel = new JPanel(new GridLayout(StaticTools.allRows,StaticTools.allCols));
		
		labelMouseListener = new MineLabelMouseListener(mineLabels,mainFrame);
		
		for(int i = 0; i < mineLabels.length; i++){
			for(int j = 0; j <mineLabels[i].length; j++){
				mineLabels[i][j] = new MineLabel(i,j);
				mineLabels[i][j].setIcon(StaticTools.blankIcon);
				mineLabels[i][j].addMouseListener(labelMouseListener);
				panel.add(mineLabels[i][j]);
			}
		}
		
		Border border = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		
		panel.setBorder(border1);
		panel.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new BorderLayout());
		this.add(panel);
		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(border);
		//调用布雷方法
//		LayMines.layMines(mineLabels);
	}
/**
 * 布雷
 * @param row
 * @param col
 */
	public static void setBomb(int row,int col){
		
	}
}
