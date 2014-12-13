package pkgcollection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 * "sdfgzxcvasdfxcvdf"获取该字符串中的字幕出现的次数
 * 
 * 希望答应结果:a(1)c(2)....
 * 通过结果发现,每一个字幕都有对应的次数.
 * 说明字幕和次数之间都有映射关系.
 * 
 * 注意:当发现有映射关系时,可以选择map集合
 * 因为map集合中存放的就是映射关系
 * 
 * 什么时候使用map集合呢?
 * 当数据之间存在着映射关系时,就要先想到map集合
 * 
 * 思路:
 * 1,讲字符串转换成字符数组.因为要对每一个字幕进行操作.
 * 2,定义一个map集合.因为打印结果的字幕有顺序所以使用treemap集合.
 * 3,遍历字符数组
 * 讲每一个字幕作为键去查map集合
 * 如果返回null,讲该字幕和1存入到map集合中.
 * 如果返回不是null,说明改字幕在map集合中已经存在并有对应次数
 * 那么就获取该次数并进行自增,然后将该字幕和自增厚的次数存入到map中.
 * 4,将map集合中的数据变成指定的字符串形式返回.
 */

class MapTestTreeMapComparator<T> implements Comparator<T>{
	public int compare(T t1,T t2){
		int num = 10;
		if(t1 instanceof Integer && t2 instanceof Integer){
			num = new Integer((Integer)t1).compareTo(new Integer((Integer)t2));
		}
		return num;
	}
}
public class MapTest3 {
	public static void main(String[] args) {
//		Method();
		Method2();
	}

	private static void Method2() {
		String str = "sdfgzxcvasdfxcvdf";
		char[] chs = str.toCharArray(); 
		Map<Character,Integer> tm = new TreeMap<Character, Integer>();
		
		int count = 0;
		for(int x = 0; x < chs.length; x++){
			if(!(chs[x] >= 'a' && chs[x] <= 'z' || chs[x] >= 'A' && chs[x] <= 'Z')){
				continue;
			}
			Integer value = tm.get(chs[x]);
//			if(value == null){
//				tm.put(chs[x], 1);
//			}else{
//				value = value + 1;
//				tm.put(chs[x], value);
//			}
			
			if(value != null){
				count = value;
			}
			count ++;
			tm.put(chs[x], count);
			count = 0;
		}
		
		System.out.println(tm);
		StringBuilder sb = new StringBuilder();
		Set<Map.Entry<Character,Integer>> set = tm.entrySet();
		Iterator<Map.Entry<Character, Integer>> it = set.iterator();
		while(it.hasNext()){
			Map.Entry<Character, Integer> map = it.next();
			sb.append(map.getKey() + "(" + map.getValue() + ")");
		}
		System.out.println(sb);
	}

	private static void Method() {
		Map<String,Integer> map = new TreeMap<String, Integer>();
		String str = "sdfgzxcvasdfxcvdf";
		for(int i = 0; i < str.length(); i++){
			String s = str.charAt(i) + "";
			if(map.containsKey(s)){
				map.put(s, map.get(s) + 1);
			}else{
				map.put(s, 1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, Integer> map2 = it.next();
			String name = map2.getKey();
			int num = map2.getValue();
			String temp = name + "(" + num + ")";
			sb.append(temp);
		}
		
		System.out.println(sb);
	}
}
