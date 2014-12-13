package pkgcollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * fill方法可以将list集合中所有元素替换成指定元素
 * 将list集合中部分元素替换成指定元素.
 */
public class CollectionsDemo2 {
	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();

		strList.add("bbbb");
		strList.add("ba");
		strList.add("qerbb");
		strList.add("rerb");
		strList.add("b");
		strList.add("zz");
		fillDemo(strList,2,4);
		sop(strList);
		
		Collections.shuffle(strList);
		sop(strList);
		
		Collections.replaceAll(strList, "bbbb", "xxx");
		sop(strList);
		
		Collections.reverse(strList);
		
		sop(strList);
	}
	private static void fillDemo(List list,int start,int end) {
		List<String> list2 = new ArrayList<String>();
		
		for(int i = start; i <= end ; i++){
			list2.add((String)list.get(i));
		}
		
		Collections.fill(list2, "pp");
//		sop(list2);
		
		for(int i = start,j = 0; i <= end && j <= list2.size(); i++,j++){
			list.set(i, list2.get(j));
		}
		
		sop(list);
	}
	public static void sop(Object obj) {
		System.out.println(obj);
	}
}
