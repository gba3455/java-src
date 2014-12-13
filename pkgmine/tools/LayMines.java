package pkgmine.tools;

import pkgmine.bean.MineLabel;
import pkgmine.panel.MineJPanel;
//row,col指被点击的时候标签下标不能为雷
public class LayMines {
	public static void layMines(MineLabel[][] mineLabels,int row,int col) {
//		System.out.println("布雷前" + row + "," + col);
		int count = 0;
		while (count < StaticTools.allMineCount) {
			int x = (int) (Math.random() * StaticTools.allRows);
			int y = (int) (Math.random() * StaticTools.allCols);
			if (mineLabels[x][y].isMineTag() == false && !(x == row && y == col)) {
				mineLabels[x][y].setMineTag(true);
				// 调试
//				mineLabels[x][y].setCountAround(9);
				if(StaticTools.backDoor){
					mineLabels[x][y].setIcon(StaticTools.holeIcon);
				}
				count++;
//				System.out.println("随机数" + x + "," + y);
			}
		}
//		System.out.println("布雷后");
//		for (int i = 0; i < mineLabels.length; i++) {
//			for (int j = 0; j < mineLabels[i].length; j++) {
//				System.out.print(mineLabels[i][j].getCountAround());
//			}
//		}
		// 计算非雷块周围雷数
//		System.out.println("计算周围雷数后");
		countMines2_for(mineLabels);
	}
	/*
	 * 计算周围雷数
	 */
	public static void countMines2_for(MineLabel[][] mineLabels) {
		for (int x = 0; x < mineLabels.length; x++) {
			for (int y = 0; y < mineLabels[x].length; y++) {
				if(mineLabels[x][y].isMineTag() == false){
					int aroundCount = 0;
					for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1, StaticTools.allRows - 1); i++) {
						for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1, StaticTools.allCols - 1); j++) {
							if(mineLabels[i][j].isMineTag()){
								aroundCount++;
							}
						}
					}
					mineLabels[x][y].setCountAround(aroundCount);
				}
//				System.out.print(mineLabels[x][y].getCountAround());
			}
		}
	}
}
