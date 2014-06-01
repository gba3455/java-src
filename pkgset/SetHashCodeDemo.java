package pkgset;

import java.util.HashSet;
import java.util.Set;

public class SetHashCodeDemo {
	private int nid;
	private String sname;
	public SetHashCodeDemo(int nid, String sname) {
		super();
		this.nid = nid;
		this.sname = sname;
	}
	/**
	 * 实现set不重复 hashCode方法和equals方法都要实现
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		System.out.println("hashcode this = " + this);
		return nid;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "nid = " + nid + "sname = " + sname;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("equals this = " + this);
		if (obj == this) {
			return true;
		}
		if (obj instanceof SetHashCodeDemo) {
			SetHashCodeDemo shcd = (SetHashCodeDemo)obj;
			if (shcd.nid == this.nid) {
				return true;
			}
			
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetHashCodeDemo shcd1 = new SetHashCodeDemo(1,"xiaoming");
		SetHashCodeDemo shcd2 = new SetHashCodeDemo(2,"long");
		SetHashCodeDemo shcd3 = new SetHashCodeDemo(3,"long3");
		Set set = new HashSet();
		//实现不重复的思路
		//首先添加一个元素 然后保存该元素的hashcode值
		//第二个元素会与集合里面已有的元素的hashcode值进行比较
		//当hashcode重复就用对象的equals比较 equals也重复 则认为两个对象重复
		set.add(shcd1);
		set.add(shcd2);
		set.add(shcd3);
		System.out.println(set);
		
	}

}
