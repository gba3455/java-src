package pkgcollection;

import java.util.Iterator;
import java.util.TreeSet;

/*
 * Set:无序,不可重复元素.
 * 		|--HashSet:数据结构是哈希表.线程是非同步的.
 * 					保证元素唯一性的原理:判断元素的HashCode值是否相同.
 *					如果相同,还会继续判断元素的equals方法,是否为true 
 * 		|--TreeSet:可以对Set集合中的元素进行排序.自然顺序.Asc码表.
 * 					底层数据结构是二叉树.
 * 					保证元素唯一性的而依据:compareTo方法return 0;和hash值没关系.
 * 					TreeSet排序的第一种方式:让元素自身具备比较性.元素需要实现Comparable接口.覆盖CompareTo方法.
 * 					这种方式也称为元素的自然顺序,或者叫做元素的默认顺序.
 * 	
 * 					TreeSet集合的第二种排序方式:
 * 					当元素自身不具备比较性时,或者具备的比较性不是所需要的.
 *  				这时需要让集合自身具备比较性.
 *    				在集合初始化时就有了比较方式.
 *      			
 * 需求:
 * 往TreeSet集合中存储自定义对象学生.
 * 想按照学生的年龄进行排序.
 * 
 * 记住!排序时,当主要条件相同时,一定要判断一下次要条件.
 */
public class TreeSetDemo {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		ts.add(new Student("lisi02",22));
		ts.add(new Student("lisi007",20));
//		ts.add(new Student("lisi007",20));//视为重复元素,进不去
		ts.add(new Student("lisi09",19));
		ts.add(new Student("lisi08",19));
		ts.add(new Student("lisi01",40));
		
		Iterator it = ts.iterator();
		while(it.hasNext()){
			Student s = (Student)it.next();
			System.out.println(s.getName() + "..." + s.getAge());
		}
	}
}
class Student implements Comparable//该接口强制让该类具备比较性.
{
	private String name;
	private int age;
	Student(String name,int age){
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
		if(!(o instanceof Student)){
			throw new RuntimeException("不是学生对象");
		}
		return 1;//怎么进就怎么取
//		return -1;//正进倒取
//		return 0;//只存一个.
//		Student s = (Student)o;
//		System.out.println(this.name + "compareto.." + s.name);
//		if(this.age > s.age){
//			return 1;
//		}
//		if(this.age == s.age){
//			return this.name.compareTo(s.name);
//		}
//		return -1;
//		return this.age - s.age;
	}
}
