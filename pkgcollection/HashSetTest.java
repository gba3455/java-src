package pkgcollection;

import java.util.HashSet;
import java.util.Iterator;

/*
 * 往hashSet集合中存入自定义对象
 * 姓名和年龄相同为同一个人,重复元素.
 * 
 *  HashSet是如何保证元素的唯一性的呢?
 *  是通过元素的两个方法,hashCode和equals来完成.
 * 	如果元素的HashCode值相同,才会判断equals是否为ture
 * 	如果元素的HashCode值不同,不会调用equals.
 * 	所以我们在定义一个对象的时候,通常要复写Hashcode和equals.因为有可能对象要存放到hashset集合中.
 * 			
 * 	注意,对于判断元素是否存在,以及删除等操作.依赖的方法是元素的hashcode和equals方法.
 * 
 * ArrayList判断是否有不同只依赖equals方法.HashSet判断是否有不同先依赖Hashcode方法,再依赖equals方法.
 */
public class HashSetTest {
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		hs.add(new Person2("a1",11));
		hs.add(new Person2("a2",12));
		hs.add(new Person2("a3",13));
//		hs.add(new Person2("a2",12));
		//hs.add(new Person("a4",14));
		
//		System.out.println(hs.contains(new Person2("a2",12)));
		hs.remove(new Person2("a3",13));
		hs.remove(new Person2("a4",14));
		
		Iterator it = hs.iterator();
		
		while(it.hasNext()){
			Person2 p = (Person2)it.next();
			System.out.println(p.getName() + "...." + p.getAge());
		}
	}
}
class Person2{
	private String name;
	private int age;
	public Person2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int hashCode(){
		System.out.println(this.name + ".....hashCode");
//		return 60;
//		return name.hashCode() + age;
		return name.hashCode() + age * 39;//*上一个数是为了保证hash值的唯一性.
	}
	public boolean equals(Object obj){//这里注意不能写成Person,编译能通过,但是没复写.
		if(!(obj instanceof Person2)){
			return false;
		}
		Person2 p = (Person2)obj;
		
		System.out.println(this.name + "...equals.." + p.name);
		return this.name.equals(p.getName()) && this.age == p.getAge();//这里的equals是字符串的方法.
	}
}
