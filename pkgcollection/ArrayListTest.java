package pkgcollection;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 去除ArrayList集合中的重复元素.
 */
public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add("java01");
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java01");
		al.add("java03");
		al.add("java02");
		
		Iterator it = al.iterator();
		while(it.hasNext()){
			System.out.println(it.next() + "...." + it.next());//如果元素数量是奇数就错.
			//所以在循环中next救写一次.
		}
		
//		System.out.println(al);
//		
//		System.out.println(singleElement(al));
	}

	public static ArrayList singleElement(ArrayList al){
		//定义一个临时容器.
		ArrayList newAl = new ArrayList();
		Iterator it = al.iterator();
		
		while(it.hasNext()){
			Object obj = it.next();
			
			if(!newAl.contains(obj)){
				newAl.add(obj);
			}
		}
		return newAl;
	}
}
