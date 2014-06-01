package pkgset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * 扩展Collection接口
不允许重复元素
没有排序
允许一个null值
对 add()、equals() 和 hashcode() 方法添加了限制
HashSet是其实现类
其实是有顺序的，只不过无法掌握他的顺序，所以是无序的
不同的jdk版本顺序不一样
 * @author SQZS
 *
 */

public class TestSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set set = new HashSet();
		set.add("a");//添加元素
		set.add("a");//重复，没加进去
		set.add("a");//重复，没加进去
		set.add("ab");
		set.add("ac");
		set.add("ad");
		System.out.println("set = " + set);//重写了toString（）方法
		int size = set.size();//3
		boolean isEmpty = set.isEmpty();
		//参数与集合里面每个元素进行比较 equals
		boolean contains = set.contains(new String("a"));//true调用equals方法判断
		System.out.println("contains = " + contains);
//		set.clear();
//		System.out.println("set =" + set);
		//迭代器iterator 集合里面都提供了获得迭代器的方法
//		迭代方式1
		int count = 0;
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){//还有下一个元素
			Object next = iterator.next();//获得下一个元素 索引位置下移一个
			//next()最好在循环里每次循环只用一次
			System.out.println(next);
//			//java.util.NoSuchElementException↓
//			Object next2 = iterator.next();
//			System.out.println(next2);
			System.out.println("循环:" + count++);
		}
		set.remove("ab");//移除元素
		//iterator.hasNext()已经在上面迭代完返回false，所以iterator在下面不能再用
//		迭代方式2
		for (Iterator iterator2 = set.iterator(); iterator2.hasNext();) {
			Object next3 = (Object) iterator2.next();
			System.out.println(next3);
			if (next3.equals("ac")) {
				iterator2.remove();//建议使用这种方式移除
			}
//			if (next3.equals("ac")) {
//				set.remove(next3);//或这种也行
//			}
//			if ("ac".equals(next3)) {
//				iterator2.remove();//建议使用这种方式移除
//			}
		}
		System.out.println("set = " + set);
	}

}
