package pkgset;

import java.util.Enumeration;
import java.util.Hashtable;

public class TestHashTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put("tt1", "value1");
		hashtable.put("tt2", "value2");
		hashtable.put("tt3", "value3");
		
		//Enumeration 向量枚举类 是老的迭代器 比Iterator 少了remove移除元素的方法
		//使用比较少
		Enumeration<String> enumeration = hashtable.elements();
		while(enumeration.hasMoreElements()){
			System.out.println(enumeration.nextElement());
		}
	}

}
