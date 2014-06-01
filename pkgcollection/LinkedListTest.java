package pkgcollection;
/*
 * 使用LinkedList模拟一个堆栈或者队列数据结构.
 * 
 * 堆栈:先进后出.如同一个杯子.
 * 队列:先进先出.First in First out FIFO如同一个水管.
 * 
 */
import java.util.*;
class Queue{
	private LinkedList link;
	Queue(){
		link = new LinkedList();
	}
	public void myAdd(Object obj){
		link.addFirst(obj);
	}
	public Object myGet(){
		return link.removeLast();//队列
//		return link.removeFirst();//堆栈
	}
	public boolean isNull(){
		return link.isEmpty();
	}
}
public class LinkedListTest {
	public static void main(String[] args) {
		Queue q = new Queue();
		q.myAdd("java01");
		q.myAdd("java02");
		q.myAdd("java03");
		q.myAdd("java04");
		while(!q.isNull()){
			System.out.println(q.myGet());
		}
	}
}
