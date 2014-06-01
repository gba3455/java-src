package pkgset;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Student implements Comparable<Student>{
	int id;
	String name;
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "学生:" + id + ":" + name;
	}
// 要直接添加到可排序的集合中需要实现该方法
// 比较此对象与指定对象的顺序。
// 如果该对象小于、等于或大于指定对象，则分别返回负整数、零或正整数。
// 负数 当前对象比参数更小
// 0 相等
// 正数 当期对象大于参数
@Override
public int compareTo(Student o) {
	// TODO Auto-generated method stub
	System.out.println("this=" + this + ":" + "o=" + o);
	return -(this.id - o.id);
}
	public static void main(String[] args) {
		//当指定了比较器之后 集合中元素可以不实现Comparable接口
		// TODO Auto-generated method stub
		SortedSet<Student> sortedSet = new TreeSet<Student>();
		Student student1 = new Student(1,"小强");
		Student student2 = new Student(2,"旺财");
		Student student3 = new Student(3,"小明");
		sortedSet.add(student1);
		//添加第二个元素开始会默认调用compareTo进行比较
		sortedSet.add(student2);
		sortedSet.add(student3);
//		sortedSet.add(null);//空指针异常
		System.out.println(sortedSet);
		//针对键进行排序
		Map<Student, String> treeMap = new TreeMap<Student, String>();
		treeMap.put(student1, "value");
		treeMap.put(student2, "value");
		treeMap.put(student3, "value");
		System.out.println(treeMap);
	}
}
