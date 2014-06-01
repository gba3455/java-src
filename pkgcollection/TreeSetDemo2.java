package pkgcollection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
 * 当元素自身不具备比较性,或者具备的比较性不是所需要的,这时需要让容器自身
 * 具备比较性.
 * 定义一个比较器,将比较器对象作为参数传递给TreeSet集合的构造函数.
 * 
 * 当2种排序都存在时,以比较器为主.
 * 
 * 定义一个类,实现Comparator接口.覆盖compare方法.
 * 
 * 比较器比较常用.
 */
public class TreeSetDemo2 {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet(new MyCompare());
		ts.add(new Student2("lisi02", 22));
		ts.add(new Student2("lisi007", 20));
		ts.add(new Student2("lisi007", 29));
		// ts.add(new Student("lisi007",20));//视为重复元素,进不去
		ts.add(new Student2("lisi09", 19));
		ts.add(new Student2("lisi08", 19));
		ts.add(new Student2("lisi01", 40));

		Iterator it = ts.iterator();
		while (it.hasNext()) {
			Student2 s = (Student2) it.next();
			System.out.println(s.getName() + "..." + s.getAge());
		}
	}
}
class My{
	
}
class MyCompare implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
			Student2 s1 = (Student2)o1;
			Student2 s2 = (Student2)o2;
			int res = s1.getName().compareTo(s2.getName());
			if(res == 0){
//				if(s1.getAge() > s2.getAge()){
//					return 1;
//				}
//				if(s1.getAge() == s2.getAge()){
//					return 0;
//				}
//				return -1;
				return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));//Integer类也实现了Comparable接口
			}
			return res;
	}
	
}
class Student2 implements Comparable {
	private String name;
	private int age;

	Student2(String name, int age) {
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

	@Override
	public int compareTo(Object o) {
		if (!(o instanceof Student2)) {
			throw new RuntimeException("不是学生对象");
		}
		return 1;// 怎么进就怎么取
		// return -1;//正进倒取
		// return 0;//只存一个.
		// Student s = (Student)o;
		// System.out.println(this.name + "compareto.." + s.name);
		// if(this.age > s.age){
		// return 1;
		// }
		// if(this.age == s.age){
		// return this.name.compareTo(s.name);
		// }
		// return -1;
		// return this.age - s.age;
	}
}