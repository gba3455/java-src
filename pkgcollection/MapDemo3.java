package pkgcollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * map扩展知识
 * 
 * map集合被使用是因为具备映射关系.
 * 
 * 预热班 01号 张三
 * 预热班 02号 李四
 * 
 * 就业办 01号 王五
 * 就业办 02号 赵六
 * 
 * 一个学校有多个教室,每个教室都有名字.
 */

class Student_MapDemo3 implements Comparable{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student_MapDemo3(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public String toString(){
		return id + "..." + name;
	}
}
public class MapDemo3 {
	public static void main(String[] args) {
//		method();
		method2();
	}
	private static void method2(){
		Map<String,List> school = new HashMap<String, List>();
		List<Student_MapDemo3> yure = new ArrayList<Student_MapDemo3>();
		List<Student_MapDemo3> jiuye = new ArrayList<Student_MapDemo3>();
		
		yure.add(new Student_MapDemo3(1,"zhangsan"));
		yure.add(new Student_MapDemo3(2,"lisi"));
		
		jiuye.add(new Student_MapDemo3(1,"wangwu"));
		jiuye.add(new Student_MapDemo3(2,"zhaoliu"));
		
		school.put("yure", yure);
		school.put("jiuye", jiuye);
		
		Iterator<Map.Entry<String, List>> it = school.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, List> tempMap = it.next();
			List<Student_MapDemo3> list = tempMap.getValue();
			System.out.println(tempMap.getKey());
			getStuInfo(list);
		}
	}
	private static void getStuInfo(List<Student_MapDemo3> list) {
		Iterator<Student_MapDemo3> it = list.iterator();
		while(it.hasNext()){
			Student_MapDemo3 stu = it.next();
			System.out.println(stu);
		}
	}
	private static void method() {
		Map<String,Map> school = new HashMap<String, Map>();
		
		Map<String,String> yure = new HashMap<String, String>();
		
		Map<String,String> jiuye = new HashMap<String, String>();
		
		school.put("yure", yure);
		school.put("jiuye", jiuye);
		
		yure.put("01", "zhangsan");
		yure.put("02", "lisi");
		
		jiuye.put("01", "wangwu");
		jiuye.put("02", "zhangliu");
		
		Iterator<String> it = school.keySet().iterator();
		while(it.hasNext()){
			String className = it.next();
			System.out.println(className);
			getStudentsInfo(school.get(className));
		}
	}
	
	private static void getStudentsInfo(Map<String,String> className){
		Iterator<String> it = className.keySet().iterator();
		while(it.hasNext()){
			String id = it.next();
			String name = className.get(id);
			System.out.println(id + ":" + name);
		}
	}
}

