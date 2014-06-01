package pkgset;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class TestListIteratorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		for (int i = 1; i < 10; i++) {
			list.add(Integer.valueOf(i));
		}
		//iterator
		for(Iterator iterator = list.iterator(); iterator.hasNext();){
			Object o = iterator.next();
			System.out.println(o);
		}
		//迭代2 索引下标
		for (int i = 0; i < list.size(); i++) {
			Object o = list.get(i);
			System.out.println(o);
		}
		//迭代3 ListIterator双向迭代器
		ListIterator listIterator = list.listIterator(5);//注意索引越界
		System.out.println("顺向迭代");
		while(listIterator.hasNext()){
			System.out.println(listIterator.next());
		}
		System.out.println("逆向迭代");
		while(listIterator.hasPrevious()){
			System.out.println(listIterator.previous());//是否有上一个元素
		}
	}

}
