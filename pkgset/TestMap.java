package pkgset;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 将键映射至值的对象
		// 每个键最多都只能映射至一个值
		//非线程安全（不同步) ,效率高
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "value");
		map.put("1", "value1");
		map.put("put1", "valuePut");
		map.put("put1", "重复");//覆盖之前的键值对
		System.out.println("size" + map.size());
		System.out.println(map);//{1=value1, put1=重复, key=value}
		
		String get = map.get("put1");
		System.out.println(get);
		
		boolean containKey = map.containsKey(new String("put1"));
		boolean containValue = map.containsValue(new String("重复"));
		boolean isEmpty = map.isEmpty();
		map.remove(new String("1"));
		System.out.println(containKey + "" + containValue + "" + isEmpty + "" + map);
//		map.clear();//清空
//		System.out.println(map);
		
		//线程安全(同步) 效率会比HashMap低
		Map<String, String> map3 = new Hashtable<String, String>();
		map3.put("table1", "value");
		map3.put("table2", "value2");
		map.putAll(map3);
		
		System.out.println("map all = " + map);
		//练习
				// 1..100 x key
				// y = x*x; value
				// 添加到map中
		Map<Integer,Integer> mapInt = new HashMap<Integer, Integer>();
		for (int i = 0; i < 100; i++) {
			mapInt.put(i, i * i);
		};
		System.out.println(mapInt);
		Integer getInt = mapInt.get(50);
		System.out.println(getInt);
	}

}
