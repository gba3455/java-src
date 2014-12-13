package pkgcollection;
/*
 * 高级For循环
 * 
 * 格式:
 * for(数据类型 变量名 : 被遍历的集合(Collection)或者数组){
 * }
 * 
 * 对集合进行遍历.
 * 只能获取元素,但是不能对集合进行操作.
 * 
 * 迭代器出了遍历,还可以进行remove集合中元素的动作.
 * 如果使用ListIterator还可以在遍历过程中进行增删改查的动作.
 * 
 * 传统for和高级for的区别:
 * 高级for有一个局限性,必须有被遍历的目标.
 * 
 * 建议在遍历数组的时候,还是希望使用传统for.
 * 因为传统for可以定义脚标.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ForEachDemo {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();

		list.add("abc");
		list.add("fda");
		list.add("fdaw");
		
		for(String s : list){
			s = "kk";//这个无效.只能对集合取出,无法修改
			System.out.println(s);
		}
		//迭代器虽然也无法修改,但是至少有个remove方法,可以删除.
		//如果用列表迭代器就可以增删改查
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		
		hm.put(1, "aaa");
		hm.put(2, "bbb");
		hm.put(3, "ccc");
		hm.put(4, "ddd");
		
		for(Integer i : hm.keySet()){
			System.out.println(hm.get(i));
		}
		
		Set<Map.Entry<Integer, String>> set = hm.entrySet();
		for(Map.Entry<Integer, String> m : set){
			System.out.println(m.getKey() + ">>>" + m.getValue());
		}
		
		for(Map.Entry<Integer, String> me : hm.entrySet()){
			System.out.println(me.getKey() + ">>>" + me.getValue());
		}
	}
}
