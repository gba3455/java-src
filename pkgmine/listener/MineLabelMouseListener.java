package pkgmine.listener;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import pkgmine.bean.MineLabel;
import pkgmine.dialog.NameDialog;
import pkgmine.frame.MainFrame;
import pkgmine.panel.MineJPanel;
import pkgmine.tools.LayMines;
import pkgmine.tools.StaticTools;

public class MineLabelMouseListener implements MouseListener {
	MineLabel[][] mineLabels;
	MainFrame mainFrame;
	private boolean isDoubleClick = false;
	
	public MineLabelMouseListener(MineLabel[][] mineLabels, MainFrame mainFrame) {
		this.mineLabels = mineLabels;
		this.mainFrame = mainFrame;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		MineLabel mineLabel = (MineLabel) e.getSource();
		int row = mineLabel.getRowx();
		int col = mineLabel.getColy();
//		int onmask = MouseEvent.BUTTON3_DOWN_MASK | MouseEvent.BUTTON1_DOWN_MASK;
//		  if(e.getModifiersEx() == 4352){
//				isDoubleClick = true;
//				doubleClickFun(row,col);
//		}
//		// Left Click
//		else 
		if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
			if (!mineLabel.isExpendTag() && !mineLabel.isFlagTag()) {
				mineLabel.setIcon(StaticTools.countImageIcons[0]);
			}
			mainFrame.getFaceJpanel().getFaceLabel()
					.setIcon(StaticTools.clickIcon);
		} else if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
			// Right Click
			if (!mineLabel.isExpendTag()) {
				// 判断没展开标注的红旗,获得右键点击次数
				int rightClickCount = mineLabel.getRightClickCount();
				rightClickCount++;
				if (rightClickCount == 1) {
					// 修改红旗标志ture
					// 修改点击次数
					// 修改红旗图片
					// 修改表情面板剩余雷数
					mineLabel.setIcon(StaticTools.flagIcon);
					mineLabel.setFlagTag(true);
					mineLabel.setRightClickCount(1);
					StaticTools.bombCount--;
					mainFrame.getFaceJpanel().setRemainNumber(
							StaticTools.bombCount);
				} else if (rightClickCount == 2) {
					mineLabel.setFlagTag(false);
					mineLabel.setIcon(StaticTools.askIcon);
					mineLabel.setRightClickCount(2);
					StaticTools.bombCount++;
					mainFrame.getFaceJpanel().setRemainNumber(
							StaticTools.bombCount);
				} else {
					mineLabel.setIcon(StaticTools.blankIcon);
					mineLabel.setRightClickCount(0);
				}
			}
		}
	}

	private void doubleClickFun(int row, int col) {
		for(int i = Math.max(row - 1, 0); i <= Math.min(row + 1, StaticTools.allRows); i++){
			for(int j = Math.max(col - 1, 0); j <= Math.min(col + 1, StaticTools.allCols); j++){
				//没展开没标旗
				if(mineLabels[i][j].isExpendTag() == false
						&& mineLabels[i][j].isFlagTag() == false){
					//是否是问号
					if(mineLabels[i][j].getRightClickCount() == 2){
						//是问号,换成下沉问号
						mineLabels[i][j].setIcon(StaticTools.askDownIcon);
					}else{
						//换成空图片
						mineLabels[i][j].setIcon(StaticTools.countImageIcons[0]);
					}
				}
			}
		}
	}

	private void expend(int x, int y) {
		int count = mineLabels[x][y].getCountAround();
		// 判断是否已经展开
		if (!mineLabels[x][y].isExpendTag() && !mineLabels[x][y].isFlagTag()) {
			// 展开 修改标志
			mineLabels[x][y].setIcon(StaticTools.countImageIcons[count]);
			mineLabels[x][y].setExpendTag(true);
			// 判断周围雷数是否为0
			// 是否需要展开周围8个位置.
			if (count == 0) {
				for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1,
						mineLabels.length - 1); i++) {
					for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1,
							mineLabels[x].length - 1); j++) {
						expend(i, j);
					}
				}
			}
			// else{//周围雷数不为零,翻开自己,修改展开标志
			// mineLabels[x][y].setIcon(StaticTools.countImageIcons[count]);
			// mineLabels[x][y].setExpendTag(true);
			// }
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		MineLabel mineLabel = (MineLabel) e.getSource();
		int row = mineLabel.getRowx();
		int col = mineLabel.getColy();
		if(isDoubleClick){
			//还原双击标志
			isDoubleClick = false;
			mainFrame.getFaceJpanel().getFaceLabel()
			.setIcon(StaticTools.smileIcon);
			//没开 还原(空白,红旗,问号)
			if(mineLabel.isExpendTag() == false){
				returnIcon(row,col);
			}else{//展开
				boolean isEquals = isEquals(row,col);
				if(isEquals){//展开
					doubleExpend(row,col);
				}else{//标旗数与周围雷数不相等,还原
					returnIcon(row,col);
				}
			}
		}
		else if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
			//第一次点击后布雷
			if(StaticTools.isStart == false){
				LayMines.layMines(mineLabels, row, col);
				//开始后修改标志
				StaticTools.isStart = true;
			}
			// Timer Start
			mainFrame.getTimer().start();
			// 没张开,没有红旗才可以操作.
			if (!mineLabel.isExpendTag() && !mineLabel.isFlagTag()) {
				// 点击是雷的时候
				if (mineLabel.isMineTag()) {
					bombAction(row, col);
					// mineLabel.setIcon(StaticTools.bloodIcon);
				} else// Isn't Mine
				{
					mainFrame.getFaceJpanel().getFaceLabel()
							.setIcon(StaticTools.smileIcon);
					expend(row, col);
					mineLabel.setIcon(StaticTools.countImageIcons[mineLabel
							.getCountAround()]);
					mineLabels[row][col].setExpendTag(true);
				}
			}
		}
		//鼠标释放的时候判断是否赢了
		isWin();
	}

	private void isWin() {
		//计算展开的块数与实际需要展开的块数是否相等
		int needCount = StaticTools.allCols * StaticTools.allRows - StaticTools.allMineCount;
		int expendCount = 0;
		for(int i = 0; i < mineLabels.length; i++){
			for(int j = 0; j < mineLabels[i].length; j++){
				if(mineLabels[i][j].isExpendTag()){
					expendCount++;
				}
			}
		}
		if(needCount == expendCount){
			//win
			for(int i = 0; i < mineLabels.length; i++){
				for(int j = 0; j < mineLabels[i].length; j++){
					if(mineLabels[i][j].isMineTag() && !mineLabels[i][j].isFlagTag()){
						mineLabels[i][j].setIcon(StaticTools.flagIcon);
						mineLabels[i][j].setFlagTag(true);
					}
				}
			}
			//剩余雷数归零
			mainFrame.getFaceJpanel().setRemainNumber(0);
			//Timer Stop
			mainFrame.getTimer().stop();
			//移除监听
			for(int i = 0; i < mineLabels.length; i++){
				for(int j = 0; j < mineLabels[i].length; j++){
					mineLabels[i][j].removeMouseListener(this);
					}
				}
			mainFrame.getFaceJpanel().getFaceLabel().setIcon(StaticTools.winIcon);
			//记录成绩 名字输入框
			int level = StaticTools.getLevel();
			if(level == 1){
				new NameDialog(1,mainFrame);
			}else if(level == 2){
				new NameDialog(2,mainFrame);
			}else{
				new NameDialog(3,mainFrame);
			}
		}
	}

	private void doubleExpend(int row, int col) {
		//双击展开 是雷(标旗与没标旗(爆炸)) 
		boolean isBombFlag = false;
		for(int i = Math.max(row - 1, 0); i <= Math.min(row + 1, StaticTools.allRows); i++){
			for(int j = Math.max(col - 1, 0); j <= Math.min(col + 1, StaticTools.allCols); j++){
				if(mineLabels[i][j].isMineTag()){
					if(!mineLabels[i][j].isFlagTag()){
						if(isBombFlag == false){
							bombAction(row, col);
							isBombFlag = true;
						}
						//红的爆炸图片
						mineLabels[i][j].setIcon(StaticTools.bloodIcon);
					}
				}else{//不是雷(标旗(标错) 没标旗(展开))
					if(!mineLabels[i][j].isFlagTag()){
						expend(i, j);
					}
				}
			}
		}
	}

	private void returnIcon(int row, int col) {
		//红旗不动 0还原空白 ?改回
		for(int i = Math.max(row - 1, 0); i <= Math.min(row + 1, StaticTools.allRows); i++){
			for(int j = Math.max(col - 1, 0); j <= Math.min(col + 1, StaticTools.allCols); j++){
				if(!mineLabels[i][j].isFlagTag() || !mineLabels[i][j].isExpendTag()){
					int rightClickCount = mineLabels[i][j].getRightClickCount();
					if(rightClickCount == 2){
						mineLabels[i][j].setIcon(StaticTools.askIcon);
					}else{
						mineLabels[i][j].setIcon(StaticTools.countImageIcons[0]);
					}
				}
			}
		}
	}

	//计算标旗数量是否与周围雷数相等
	private boolean isEquals(int row, int col) {
		//取得所点位置周围雷数
		int countSelf = mineLabels[row][col].getCountAround();
		int flagCount = 0;
		for(int i = Math.max(row - 1, 0); i <= Math.min(row + 1, StaticTools.allRows); i++){
			for(int j = Math.max(col - 1, 0); j <= Math.min(col + 1, StaticTools.allCols); j++){
				if(mineLabels[i][j].isFlagTag()){
					flagCount++;
				}
			}
		}
		if(countSelf == flagCount){
			return true;
		}
		return false;
	}

	// 踩到雷后
	private void bombAction(int row, int col) {
		mineLabels[row][col].setIcon(StaticTools.bloodIcon);
		// GameOver 显示剩余所有的雷
		for (int x = 0; x <= StaticTools.allRows - 1; x++) {
			for (int y = 0; y <= StaticTools.allCols - 1; y++) {
				if (!(x == row && y == col)) {
					if (mineLabels[x][y].isMineTag()) {
						if (!mineLabels[x][y].isFlagTag()) {
							mineLabels[x][y].setIcon(StaticTools.mineIcon);
						}
					} else {
						if (mineLabels[x][y].isFlagTag()) {
							mineLabels[x][y].setIcon(StaticTools.errorIcon);
						}
					}
				}
			}
		}
		// 修改脸
		mainFrame.getFaceJpanel().getFaceLabel().setIcon(StaticTools.deadIcon);
		// 停时间
		mainFrame.getTimer().stop();
		// 移除监听
		for (int x = 0; x <= StaticTools.allRows - 1; x++) {
			for (int y = 0; y <= StaticTools.allCols - 1; y++) {
				// 只加一个鼠标监听
				mineLabels[x][y].removeMouseListener(this);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
