package pkgset;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapIterator {

	static void keySet(Map<String, String> map){
		//键的Set集合
		Set<String> keySet = map.keySet();
		for(String key : keySet){
			System.out.println(key + "-" + map.get(key));
		}
		//System.out.println(keySet);
	}
	static void values(Map<String, String> map){
		//值的集合 Collection
		Collection<String> values = map.values();
		for (String iterable_element : values) {
			System.out.println(iterable_element);
		}
	}
	static void entrySet(Map<String, String> map){
		//Set集合 Entry实体对象 java.util.Map.Entry;
		Set<Entry<String,String>> entrySet = map.entrySet();
		for (Entry<String, String> entry : entrySet) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "-" + value);
			if(value.equals("value3")){
				//修改键值对的值 如果去掉条件可以进行批量的修改
				entry.setValue("newValue");
			}
		}
		System.out.println(map);//map本身的数据也修改了
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new Hashtable<String, String>();
		map.put("table", "value1");
		map.put("table2", "value2");
		map.put("table3", "value3");
		System.out.println(map);
		
		//三种迭代方式
		keySet(map);
		values(map);
		entrySet(map);
	}

}
