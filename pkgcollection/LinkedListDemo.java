package pkgcollection;
import java.util.*;
/*
 * LinkedList:特有方法:
 * addFirst();
 * addLast();
 * 
 * getFirst();
 * getLast();
 * 获取元素,但不删除元素.
 * 
 * removeFirst();
 * removeLast();
 * 获取元素,但是元素被删除.如果集合中没有元素,会出现NoSuchElementException
 * 
 * 1.6版本以后.出现了替代方法.
 * offerFirst();
 * offerLast();
 * 
 * peekFirst();
 * peekLast();
 * 
 * pollFirst();
 * pollLast();
 * 获取元素,但是元素被删除.如果集合中没有元素,会返回null.
 */
public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList link = new LinkedList();
		
		link.addFirst("java01");
		link.addFirst("java02");
		link.addFirst("java03");
		link.addFirst("java04");
		
		System.out.println(link);
		
		link.addLast("java01");
		link.addLast("java02");
		link.addLast("java03");
		link.addLast("java04");
		System.out.println(link);
		
//		System.out.println(link.getFirst());
//		System.out.println(link.getFirst());
//		System.out.println(link.getLast());
//		
//		System.out.println(link.removeFirst());
//		System.out.println(link.removeFirst());
//		
//		System.out.println("size = " + link.size());
		
		//不用迭代器全取
		while(!link.isEmpty()){
//			System.out.println(link.removeFirst());
			System.out.println(link.removeLast());
		}
	}
}
