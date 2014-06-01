package pkgcollection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
 * Map集合.该集合存储键值对.一对一对往里存,而且要保证键的唯一性.
 * 1:添加
 * 		put(K key,V value);
 * 		putAll(Map<? extends K,? extends V>m);
 * 2:删除
 * 		clear();
 * 		remove(Object key);
 * 3:判断
 * 		boolean containsKey(Object Key);
 * 		boolean containsValue(Object Value);
 * 		isEmpty();
 * 4:获取
 * 		get(Object key);
 * 		size();
 * 		values();
 * 		entrySet();
 * 		KeySet();
 * 
 * Map
 * 	|--Hashtable:底层是哈希表数据结构.不可以存入null键null值.是线程同步的.JDK1.0,效率低.
 * 	|--HashMap:底层是哈希表数据结构.可以存入null键null值,是线程不同步的.JDK1.2.效率高.
 * 	|--TreeMap:底层是二叉树数据结构.线程不同步.可以用于给Map集合中的键进行排序.
 * 
 * 和Set很像.
 * 其实Set底层就是使用了Map集合.
 */
public class MapDemo {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String, String>();
		
		//添加元素
		map.put("01", "lisi01");
		map.put("02", "lisi02");
		map.put("03", "lisi03");
		
		System.out.println("containsKey:" + map.containsKey("022"));
//		System.out.println("remove:" + map.remove("02"));//remove以后,会把对应的值返回
		
		System.out.println("get:" + map.get("023"));
		
		map.put(null, "aha");//键可以存null
		System.out.println("get:" + map.get(null));
		//可以通过get方法的返回值来判断一个键是否存在.
		map.put("04", null);//如果是hashtable就不能存.不支持空键值
		System.out.println("get:" + map.get("04"));
		
		//获取map集合中所有的值.
		Collection<String> coll = map.values();
		
		System.out.println(coll);

		System.out.println("put:" + map.put("09", "wangwu"));//put方法返回键对应原来的值.第一次返回空.
		System.out.println("put:" + map.put("09","xiaoming"));
		//添加元素,当2个键相同时,新的值会替换旧的值,并把旧的值返回回来.
		
		System.out.println(map);
	}
}
