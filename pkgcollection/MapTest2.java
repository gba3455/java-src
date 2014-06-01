package pkgcollection;

import java.util.TreeMap;
import java.util.*;

/*
 * 对学生对象的年龄精细升序排序
 * 
 * 因为数据是以键值对形式存在的.
 * 所以要使用可以排序的Map集合.TreeMap
 */

class StuNameComparator implements Comparator<Student_Map>{
	public int compare(Student_Map s1,Student_Map s2){
		int num = s1.getName().compareTo(s2.getName());
		if(num == 0){
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
		}
		return num;
	}
}
public class MapTest2 {
	public static void main(String[] args) {
		
		StuNameComparator snc = new StuNameComparator();
		
		Map<Student_Map, String> map = new TreeMap<Student_Map, String>(snc);
		map.put(new Student_Map("blisi3", 23), "shanghai");
		map.put(new Student_Map("lisi1", 21), "tianjing");// 把上面的北京覆盖了
		map.put(new Student_Map("alisi1", 21), "beijing");
		map.put(new Student_Map("lisi4", 24), "wuhan");
		map.put(new Student_Map("lisi2", 22), "nanjing");
		
		Set<Map.Entry<Student_Map, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<Student_Map, String>> it = entrySet.iterator();
		while(it.hasNext()){
			Map.Entry<Student_Map, String> mapIt = it.next();
			Student_Map stu = mapIt.getKey();
			String addr = mapIt.getValue();
			System.out.println(stu + "..." + addr);
		}
	}
}
