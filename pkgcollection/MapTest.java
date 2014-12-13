package pkgcollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/*
 * 每一个学生都有对应的归属地
 * 学生Student,地址String.
 * 学生属性:姓名,年龄.
 * 注意:姓名和年龄相同视为同一个学生.
 * 保证学生的唯一性.
 * 
 * 1.描述学生.
 * 2,定义map容器.讲学生作为键,地址作为值,存入.
 * 3,获取map集合中的元素
 */
import java.util.Set;

class Student_Map implements Comparable<Student_Map>{
	private String name;
	private int age;
	
	public Student_Map(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public int hashCode(){
		return name.hashCode() + age * 34;
	}
	
	public boolean equals(Object obj){
		if(!(obj instanceof Student_Map)){
			//如果不是学生,那就不和学生比较.所以返回假.但是返回假没什么意义.
//			return false;
			//所以改用异常.程序中如果认为某种情况不允许存在,就用异常,让程序结束.
			throw new ClassCastException("类型不匹配");
		}
		Student_Map s = (Student_Map)obj;
		return this.name.equals(s.name) && this.age == s.age;
	}
	
	public int compareTo(Student_Map s){
		 int num = new Integer(this.age).compareTo(new Integer(s.age));
		 if(num == 0){
			 return this.name.compareTo(s.name);
		 }
		 return num;
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
	
	public String toString(){
		return name + ":" + age;
	}
}
public class MapTest {
	public static void main(String[] args) {
		Map<Student_Map,String> map = new HashMap<Student_Map, String>();
		map.put(new Student_Map("lisi1",21), "beijing");
		map.put(new Student_Map("lisi1",21), "tianjing");//把上面的北京覆盖了
		map.put(new Student_Map("lisi2",22), "nanjing");
		map.put(new Student_Map("lisi3",23), "shanghai");
		map.put(new Student_Map("lisi4",24), "wuhan");
		
		//第一种取出方法 keySet
//		Set<Student_Map> keySet = map.keySet();
//		Iterator<Student_Map> it = keySet.iterator();
		Iterator<Student_Map> it = map.keySet().iterator();
		
		while(it.hasNext()){
			Student_Map stu = it.next();
			String addr = map.get(stu);
			System.out.println(stu + "..." + addr);
		}
		
		//第二种取出方法 entrySet
		Set<Map.Entry<Student_Map, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<Student_Map, String>> it2 = entrySet.iterator();
		while(it2.hasNext()){
			Map.Entry<Student_Map, String> mapEn = it2.next();
			Student_Map stu2 = mapEn.getKey();
			String addr = mapEn.getValue();
			System.out.println(stu2 + "..." + addr);
		}
	}
}
