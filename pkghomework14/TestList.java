package pkghomework14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student p1 = new Student("1","xiaoming","nan");
		Student p2 = new Student("2","xiaohong","nv");
		Student p3 = new Student("3","xiaobai","nan");
		Student p4 = new Student("4","xiaohei","nan");
		Student p5 = new Student("5","xiaofang","nv");
		Student p6 = new Student("6","xiaolong","nan");
		Student p7 = new Student("jn010101","xiaolong","nan");
		List list = new ArrayList();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		list.add(p7);
		ListIterator iterator = list.listIterator(7);
		while(iterator.hasPrevious()){
			Object o = iterator.previous();
			System.out.println(o);
		}
		for(int i = list.size() - 1 ; i >= 0 ; i--){
			Object o = list.get(i);
			System.out.println(o);
		}
//		Student p8 = new Student("jn010101","xiaolong","nan");
//		list.remove(p8);
//		System.out.println(list);
		
//		Iterator iterator2 = list.iterator();
//		while(iterator2.hasNext()){
//			if(((Student)iterator2.next()).sid == "jn010101"){
//				iterator2.remove();
//			}
//		}
//		System.out.println(list);
		
//		for(int i = list.size() - 1 ; i >= 0 ; i--){
//			if(((Student)list.get(i)).sid == "jn010101"){
//				list.remove(i);
//			}
//		}
				
		List list2 = new ArrayList();
		list2 = list.subList(0, 3);
		System.out.println(list2);
		list.removeAll(list2);
		System.out.println(list);

//		subList在使用迭代器的时候线程是锁死的，不可以修改元素。
//		List list2 = new ArrayList(list.subList(0, 3));重新保存迭代后的结果
//		System.out.println(list2);
//		list.removeAll(list2);
//		System.out.println(list);
	}
}
