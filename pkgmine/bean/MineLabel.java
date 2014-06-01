package pkgmine.bean;

import javax.swing.JLabel;

import pkgmine.listener.MineLabelMouseListener;

public class MineLabel extends JLabel{
	//是否是雷
	private boolean mineTag;
	//是否展开
	private boolean expendTag;
	//是否是旗子
	private boolean flagTag;
	//数组下标X
	private int rowx;
	//数组下标Y
	private int coly;
	//周围雷数
	private int countAround;
	//右键点击次数
	private int rightClickCount;
	//是否可以编辑
	private boolean editable;
	//创建监听对象
//	private MineLabelMouseListener labelMouseListener;
	public MineLabel(int rowx,int coly) {
		this.rowx = rowx;
		this.coly = coly;
		//在创建标签的时候创建监听对象
//		labelMouseListener = new MineLabelMouseListener(this);
//		//注册监听
//		this.addMouseListener(labelMouseListener);
	}
	public boolean isMineTag() {
		return mineTag;
	}
	public void setMineTag(boolean mineTag) {
		this.mineTag = mineTag;
	}
	public boolean isExpendTag() {
		return expendTag;
	}
	public void setExpendTag(boolean expendTag) {
		this.expendTag = expendTag;
	}
	public boolean isFlagTag() {
		return flagTag;
	}
	public void setFlagTag(boolean flagTag) {
		this.flagTag = flagTag;
	}
	public int getRowx() {
		return rowx;
	}
	public void setRowx(int rowx) {
		this.rowx = rowx;
	}
	public int getColy() {
		return coly;
	}
	public void setRowy(int rowy) {
		this.coly = rowy;
	}
	public int getCountAround() {
		return countAround;
	}
	public void setCountAround(int countAround) {
		this.countAround = countAround;
	}
	public int getRightClickCount() {
		return rightClickCount;
	}
	public void setRightClickCount(int rightClickCount) {
		this.rightClickCount = rightClickCount;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
}
