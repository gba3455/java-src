package pkgmine.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.swing.ImageIcon;

import pkgmine.bean.HeroBean;

public class StaticTools {
	//定义总行数
	public static int allRows = 9;
	//定义总列数
	public static int allCols = 9;
	//定义雷数
	public static int allMineCount = 10;
	//统计剩下的雷数
	public static int bombCount = allMineCount;
	//Timer
	public static int timeCount = 0;
	
	public static boolean isStart = false;
	
	public static boolean backDoor = false;
	
	public static ImageIcon[] countImageIcons = new ImageIcon[9];
	
	public static ImageIcon[] timeImageIcons = new ImageIcon[11];
	
	public static ImageIcon blankIcon = new ImageIcon("src/pkgmine/image/blank.gif");
	
	public static ImageIcon smileIcon = new ImageIcon("src/pkgmine/image/face0.gif");
	
	public static ImageIcon smileDownIcon = new ImageIcon("src/pkgmine/image/face1.gif");
	
	public static ImageIcon bloodIcon = new ImageIcon("src/pkgmine/image/blood.gif");
	
	public static ImageIcon clickIcon = new ImageIcon("src/pkgmine/image/face2.gif");
	
	public static ImageIcon deadIcon = new ImageIcon("src/pkgmine/image/face3.gif");
	
	public static ImageIcon winIcon = new ImageIcon("src/pkgmine/image/face4.gif");

	public static ImageIcon mineIcon = new ImageIcon("src/pkgmine/image/mine.gif");
	
	public static ImageIcon errorIcon = new ImageIcon("src/pkgmine/image/error.gif");

	public static ImageIcon flagIcon = new ImageIcon("src/pkgmine/image/flag.gif");
	
	public static ImageIcon askIcon = new ImageIcon("src/pkgmine/image/ask.gif");
	
	public static ImageIcon askDownIcon = new ImageIcon("src/pkgmine/image/ask1.gif");
	
	public static ImageIcon holeIcon = new ImageIcon("src/pkgmine/image/hole.gif");
	
	static{
		for (int i = 0; i < countImageIcons.length; i++) {
			countImageIcons[i] = new ImageIcon("src/pkgmine/image/" + i + ".gif");
		}
		for (int i = 0; i < timeImageIcons.length; i++) {
			timeImageIcons[i] = new ImageIcon("src/pkgmine/image/d" + i + ".gif");
		}
	}
	
	public static TreeSet<HeroBean> treeSetC = new TreeSet<HeroBean>();
	public static TreeSet<HeroBean> treeSetZ = new TreeSet<HeroBean>();
	public static TreeSet<HeroBean> treeSetG = new TreeSet<HeroBean>();
	
	static{
		treeSetC.add(new HeroBean(999,"匿名"));
		treeSetZ.add(new HeroBean(999,"匿名"));
		treeSetG.add(new HeroBean(999,"匿名"));
	}
	
	
	public static int getLevel(){
		if(allRows == 9 && allCols == 9 && allMineCount == 10){
			return 1;
		}
		else if(allRows == 16 && allCols == 16 && allMineCount == 40){
			return 2;
		}else if(allRows == 16 && allCols == 30 && allMineCount == 99){
			return 3;
		}else{
			return 0;
		}
	}
}
