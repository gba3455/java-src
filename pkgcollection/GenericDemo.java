package pkgcollection;

import java.util.ArrayList;
import java.util.Iterator;
/*
 * 泛型:JDK1.5版本以后,出现新特性.用于解决安全问题.是一个安全机制.
 * 好处:
 * 1:将运行时期出现问题ClassCastException,转移到了编译时期.
 * 方便于程序员解决问题.让运行时问题减少.安全.
 * 2:避免强制转换麻烦.
 * 
 * 泛型格式:通过<>来定义要操作的引用数据类型.
 * 
 * 在使用java提供的对象时,什么时候使用泛型呢?
 * 通常在集合框架中很常见,只要见到<>就要定义泛型.
 * 其实<>就是用来接受类型的.当使用集合时,将集合中
 * 要存储的数据类型作为参数传递到<>中即可.
 */
public class GenericDemo {
	public static void main(String[] args) {
//		ArrayList al = new ArrayList();
		ArrayList<String> al = new ArrayList<String>();
		al.add("fdas");
		al.add("fdas");
		al.add("fdas");
//		al.add(1);//JDK1.5后自动包装类al.add(new Integer(1));
		
//		Iterator it = al.iterator();
		Iterator<String> it = al.iterator();
		while(it.hasNext()){
//			String str = (String)it.next();
			String str = it.next();
			System.out.println(str);
		}
	}
}
