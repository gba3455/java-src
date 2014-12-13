package pkgcollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class GenericDemo6 {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("fda1");
		al.add("fda2");
		al.add("fda3");
		printColl2(al);
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		al1.add(1);
		al1.add(2);
		al1.add(3);
		printColl2(al1);
//		IteratorMtd(al1);
	}
	
	//免去写2个迭代器,吧迭代器封装到方法里.
	public static void printColl(ArrayList<String> al){
		Iterator<String> it = al.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	//为了通用所有符号,可以加一个占位符
	public static void printColl2(ArrayList<?> al){
		Iterator<?> it = al.iterator();
		while(it.hasNext()){
//			? a = it.next();//这个不可以.
			System.out.println(it.next());
		}
	}
	//↑↓这2个函数?和T有什么区别?区别是T是个类型,可以在里面操作他.
	public static <T> void printColl3(ArrayList<T> al){
		Iterator<T> it = al.iterator();
		while(it.hasNext()){
			T t = it.next();//可以在这里操作数据.?就不可以.
			System.out.println(t);
		}
	}
	
	
	
	public static <T> void IteratorMtd(T t){
		Iterator<T> it = ((Collection<T>)t).iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
