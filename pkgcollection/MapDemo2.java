package pkgcollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * map集合的2种取出方式:
 * 1:Set<K> keySet:将map中所有的键存入到Set集合.因为set具备迭代器.所以可以迭代方式取出所有的键,再根据get方法.获取每一个键对应的值.
 * 
 * 	Map集合的取出原理:将map集合转成set集合.再通过迭代器取出.
 * 2:Set<Map.Entry<K,V>> entrySet:将Map集合中的映射关系存到Set集合中.而这个关系的数据类型就是Map.Entry
 * 
 * 
 */
public class MapDemo2 {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("01", "lisi01");
		map.put("02", "lisi02");
		map.put("03", "lisi03");
		
		//先获取map集合中的所有键的Set集合.
		Set<String> keySet = map.keySet();
		//有了Set集合就可以获取其迭代器.
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()){
			String key = it.next();
			//有了键就可以通过map集合的get方法获取其对应的值.
			String value = map.get(key);
			System.out.println("key:" + key + "value" + value);
		}
		
		//将Map集合中的映射关系取出.存入到Set集合中.
		Set<Map.Entry<String, String>> entrySet = map.entrySet();//泛型嵌套形式
		Iterator<Map.Entry<String, String>> it2 = entrySet.iterator();
		while(it2.hasNext()){
			Map.Entry<String, String> me = it2.next();
		}
	}
}

/*
 * Map.Entry 其实Entry也是一个接口.他是Map接口中的一个内部接口.
 * 
 * interface Map{
 * 		public static interface Entry{
 * 			public abstract Object getKey();
 * 			public abstract Object getValue();
 * 		}
 * }
 * 
 * class HashMap implements Map{
 * 		class Haha implements Map.Entry{
 * 			public abstract Object getKey(){}
 * 			public abstract Object getValue(){}
 * 		}
 * }
 * 
 * 为什么要吧Entry定义成Map的子接口,不定义到外部.
 * Entry代表映射关系,要先有Map集合,才会有映射关系.所以这个关系是Map集合内部的一个事物.
 * 所以只有有了Map集合,才能有关系.而且这个关系在直接访问Map集合中的元素.所以定义成内部规则.
 * 
 * 能加Static的接口都是内部接口.因为只有接口在成员位置上,才能加静态修饰符.
 */
