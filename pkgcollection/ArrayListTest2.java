package pkgcollection;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 将自定义对象作为元素存到ArrayList集合中,并去除重复元素.
 * 比如:存人对象,同姓名同年龄,视为同一个人.为重复元素.
 * 
 * 思路:
 * 1:对人描述,将数据封装进人对象.
 * 2:定义容器,将人存入.
 * 3:取出.
 * 
 * List集合判断元素是否相同,依据的是元素的equals方法.
 */
class Person{
	private String name;
	private int age;
	public Person(String name, int age) {
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
	public boolean equals(Object obj){
		if(!(obj instanceof Person)){
			return false;
		}
		Person p = (Person)obj;
		
		System.out.println(this.name + "....." + p.name);
		return this.name.equals(p.getName()) && this.age == p.getAge();//这里的equals是字符串的方法.
	}
}
public class ArrayListTest2 {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(new Person("lisi01",30));
		al.add(new Person("lisi02",20));
//		al.add(new Person("lisi02",20));
		al.add(new Person("lisi03",10));
		al.add(new Person("lisi04",34));
//		al.add(new Person("lisi04",34));
		
		System.out.println("remove 03" + al.remove(new Person("lisi03",10)));//如果没重写equals,这里会删除失败.所以remove底层也调用equals方法.
		
		al = singleElement(al);
		Iterator it = al.iterator();
		while(it.hasNext()){
			Person p = (Person) it.next();
			System.out.println(p.getName() + "..." + p.getAge());
		}
	}
	public static ArrayList singleElement(ArrayList al){
		//定义一个临时容器.
		ArrayList newAl = new ArrayList();
		Iterator it = al.iterator();
		
		while(it.hasNext()){
			Object obj = it.next();
			
			if(!newAl.contains(obj)){//contains调用equals
				newAl.add(obj);
			}
		}
		return newAl;
	}
}
