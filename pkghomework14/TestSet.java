package pkghomework14;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
/**
 * 1.	创建一个Person的类，类中包含id, name, sex等其它的一些属性。并重写Person类equals()和hashCode()两个方法，要求通过id来判断对象是否相等。
2.	编写用户程序TestSet使用Set接口来保存Person对象,并将Set中的对象使用迭代器迭代出来。并利用下列方法从集合中删除编号为5的Person对象：
a)	利用集合的remove(o)：此方法要求用传入要删除的对象，只要利用相等的概念，新创建一个Person对象，并把编号设置为5，然后作为remove方法的参数即可。
b)	利用迭代器的remove()：在迭代的过程中，判断迭代器当前的对象的编号是否为5，是就调用迭代器的remove()方法删除，然后跳出迭代器的循环。

 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p1 = new Person(1,"xiaoming","nan");
		Person p2 = new Person(2,"xiaohong","nv");
		Person p3 = new Person(3,"xiaobai","nan");
		Person p4 = new Person(4,"xiaohei","nan");
		Person p5 = new Person(5,"xiaofang","nv");
		Person p6 = new Person(6,"xiaolong","nan");
		Set set = new HashSet();
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		set.add(p5);
		set.add(p6);
		for(Iterator iterator = set.iterator(); iterator.hasNext();){
			Object o = iterator.next();
			System.out.println(o);
		}
		Person p7 = new Person(5,"hehe","zhongxin");
		set.remove(p7);
		System.out.println(set);
		Iterator iterator2 = set.iterator();
		while(iterator2.hasNext()){
			if(((Person)iterator2.next()).id == 5){
				iterator2.remove();
				break;
			}
		}
		System.out.println(set);
	}

}
