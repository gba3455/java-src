package pkgset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class TestListEfficiency {
	/**
	 * ArrayList类：
      由一个数组后推而成，适合查询频繁的列表.
	 */
	public static void testArrayListEfficiency(){//991ms
		long start = System.currentTimeMillis();
		ArrayList list = new ArrayList();
		for (int i = 0; i < 100000; i++) {
			list.add(Integer.valueOf(i));
		}
		for (int i = 0; i < 100000; i++) {
			list.remove(Integer.valueOf(i));
		}
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println(diff);
	}
	public static void testLinkedListEfficiency(){//27ms
		/**
		 * 由一个双向链表后推而成，适合插入删除频繁的列表.
		 */
		long start = System.currentTimeMillis();
		LinkedList list = new LinkedList();
		for (int i = 0; i < 100000; i++) {
			list.add(Integer.valueOf(i));
		}
		for (int i = 0; i < 100000; i++) {
			list.remove(Integer.valueOf(i));
		}
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println(diff);
		
	}
	public static void testVectorEfficiency(){//957ms
		/**
		 * Vector
     实现可变长度的对象数组,组件可以使用整型下标访问,线程安全.
		 */
		long start = System.currentTimeMillis();
		Vector list = new Vector();
		for (int i = 0; i < 100000; i++) {
			list.add(Integer.valueOf(i));
		}
		for (int i = 0; i < 100000; i++) {
			list.remove(Integer.valueOf(i));
		}
		long end = System.currentTimeMillis();
		long diff = end - start;
		System.out.println(diff);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testArrayListEfficiency();
		testLinkedListEfficiency();
		testVectorEfficiency();
	}

}
