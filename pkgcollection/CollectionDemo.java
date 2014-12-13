package pkgcollection;

import java.util.ArrayList;
import java.util.Iterator;
/*
 * 就吧取出方式定义在集合的内部,这样取出方式就可以直接访问集合颞部的元素.
 * 那么取出方式就被定义成了内部类.
 * 
 * 而每一个容器的数据结构不同,
 * 所以取出的动作细节也不一样,但是都有共性内容判断和取出,那么可以将这些共性取出.形成了接口.
 * 那么这些内部类都符合一个规则.改规则是Iterator.
 * 如何获取集合的取出对象:
 * 通过一个对外提供的方法,Iterator();
 */
public class CollectionDemo {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		
		al.add("java1");
		al.add("java2");
		al.add("java3");
		al.add("java4");
		System.out.println(al);
		al.remove("java2");
//		al.clear();
		System.out.println(al.size());
		System.out.println(al);
		
		System.out.println(al.contains("java1"));
		System.out.println(al.isEmpty());
		
		ArrayList al2 = new ArrayList();
		
//		al2.add("java1");//如果没有交集,那al里面就为空.
//		al2.add("java2");
		al2.add("java3");
		al2.add("java4");
		al2.add("java5");
		al2.add("java6");
		
//		al.retainAll(al2);//取交集,al中智慧保留和al2中相同的元素.
		al.removeAll(al2);//把al2里有的从al1里删除.
		System.out.println(al);
		System.out.println(al2);
		
//		Iterator it = al2.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		for(Iterator it = al2.iterator() ; it.hasNext() ; ){//把迭代器定义在for循环里面,做for循环的局部变量,for循环结束,这个迭代器就被清空
			System.out.println(it.next());
		}
	}
}
