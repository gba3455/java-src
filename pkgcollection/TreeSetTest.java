package pkgcollection;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.*;
/*
 * 练习:按照字符串长度排序.
 * 字符串本身具备比较性.但是他的比较方式不是所需要的.
 * 这时就只能使用比较器.
 */
public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet(new StringCompare());
//		TreeSet ts = new TreeSet(new Comparator(){//也可以写成匿名内部类.
//			public int compare(Object o1,Object o2){
//				String s1 = (String)o1;
//				String s2 = (String)o2;
//				int res = new Integer(s1.length()).compareTo(new Integer(s2.length()));
//				if(res == 0){
//					return s1.compareTo(s2);
//				}
//				return res;
////				return -(s1.length() - s2.length());
//			}
//		});
		
		ts.add("abcd");
		ts.add("cc");
		ts.add("cba");
		ts.add("aaa");
		ts.add("z");
		ts.add("hahaha");
		
		Iterator it = ts.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
class StringCompare implements Comparator{
	public int compare(Object o1,Object o2){
		String s1 = (String)o1;
		String s2 = (String)o2;
		int res = new Integer(s1.length()).compareTo(new Integer(s2.length()));
		if(res == 0){
			return s1.compareTo(s2);
		}
		return res;
//		return -(s1.length() - s2.length());
	}
}
