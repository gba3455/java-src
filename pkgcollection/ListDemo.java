package pkgcollection;
/*
 * Collection
 * 		|--List:元素是有序的.元素可以重复.因为该集合体系有索引.
 * 			|--ArrayList:底层的数据结构使用的是数组结构.特点:查询修改速度很快.但是增删稍慢.元素越多越明显.1.2版本出现集合框架.线程不同步的.初始容量10.超过后增加50%. 
 * 			|--LinkedList:底层使用的是链表数据结构.特点:链表连起来的,查询时要一个个查过去,查询速度非常慢.增删速度很快.
 * 			|--Vector:底层是数组数据结构.功能和ArrayList一模一样.1.0版本出现.线程是同步的.无论增删还是查询都慢,所以被ArrayList替代了.线程可以加锁.超过后增加100%.浪费空间.
 * 			|--
 * 		|--Set:元素是无序的.元素不可以重复.
 * 
 * List:
 * 	特有方法.凡是可以操作角标的方法都是该体系特有的方法.
 * 增
 * 		add(index,element);
 * 		addAll(index,Collection);
 * 删
 * 		remove(index);
 * 改
 *		set(index,element); 
 * 查
 * 		get(index);
 * 		subList(from,to);
 * 		listIterator();
 * 
 * List集合特有的迭代器ListIterator是Iterator的子接口.
 * 在迭代时,不可以通过集合对象的方法操作集合中的元素.因为会发生并发修改异常.
 * 所以在迭代时,只能用迭代器的方法操作元素,可是Iterator的方法是有限的,只能对元素进行判断,取出,删除的操作.
 * 如果想要其他的操作,如添加,修改等,就需要使用其子接口ListIterator.
 * 该接口只能通过List集合的ListIterator方法获取.
 * 
 * 只有List具备这种迭代器功能,因为List集合中的元素都有角标.
 */

import java.util.*;
public class ListDemo {
	public static void main(String[] args) {
//		Method();
		Method2();
	}

	private static void Method2() {
		//演示列表迭代器
		ArrayList al = new ArrayList();
		//添加
		al.add("java01");
		al.add("java02");
		al.add("java03");
		//在迭代过程中,准备添加或者删除元素.
//		Iterator it = al.iterator();
//		while(it.hasNext()){
//			Object obj = it.next();
//			
//			if(obj.equals("java02")){
////				al.add("java008");//java.util.ConcurrentModificationException异常.
//				//因为现在元素的引用存放在集合中.通过集合的方法可以对元素进行操作.当使用迭代器的时候,就吧集合中的元素的引用取到了迭代器里面.这时,
//				//能操作元素的方式就有2种.集合的方法和迭代器的方法.可是这2种方式操作的是同一种元素.所以迭代器正在取出的操作过程中,有用到了集合的add
//				//功能在操作元素的话,就有可能产生安全隐患.这叫并发访问.
//				it.remove();//将java02的引用从集合中删除.这里虽然移除了,但是移除的是集合al里面的,现在的obj里面还有该元素,所以可以打印出来.
//				//迭代器有局限性,没有添加方法.所以多个接口ListIterator,可以增删改查
//			}
//			System.out.println("obj" + obj);
//		}
//		System.out.println(al);//这里打印出来就没有被删元素了.
		
		ListIterator li = al.listIterator();
		System.out.println("hasPrevious():" + li.hasPrevious());
		System.out.println("hasNext():" + li.hasNext());
		while(li.hasNext()){
			Object obj = li.next();
			if(obj.equals("java02")){
//				li.add("java009");
				li.set("java006");
			}
		}
		System.out.println(al);
		System.out.println("hasPrevious():" + li.hasPrevious());
		while(li.hasPrevious()){
			Object obj = li.previous();
			System.out.println(obj);
		}
	}

	private static void Method() {
		ArrayList al = new ArrayList();
		//添加
		al.add("java01");
		al.add("java02");
		al.add("java03");
		System.out.println("原" + al);
		//指定位置添加
		al.add(1,"java09");
		System.out.println(al);
		//删除指定
//		al.remove(2);
		System.out.println(al);
		//修改
		al.set(2, "java007");
		System.out.println(al);
		//通过角标获取元素
		System.out.println("get = " + al.get(1));
		//获取所有元素
		for(int x = 0; x < al.size(); x++){
			System.out.println("al(" + x + ") = " + al.get(x));
		}
		
		Iterator it = al.iterator();
		while(it.hasNext()){
			System.out.println("next : " + it.next());
		}
		
		//通过indexOf获取对象的位置.
		System.out.println("index = " + al.indexOf("java007"));
		
		List sub = al.subList(1, 3);
		System.out.println("sub = " + sub);
	}
}
