package pkgcollection;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 集合转数组
 * Collection接口中的toArray方法
 */
public class CollectionToArray {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("abc");
		list.add("fda");
		list.add("fdaw");
		/*
		 * 1.指定类型的数组到底要定义多长呢.
		 * 当指定类型的数组长度小于集合的size,那么改方法内部会创建一个新的数组,长度为集合的size
		 * 当指定类型的数组长度大于集合的size,就不会新创建数组,而是使用传递进来的数组
		 * 所以创建一个刚刚好的数组最优
		 * 
		 * 2.为什么要将集合变数组?
		 * 为了限定对元素的操作.不需要进行增删了.
		 */
		
//		String[] sArr = list.toArray(new String[0]);
//		String[] sArr = list.toArray(new String[5]);
		String[] sArr = list.toArray(new String[list.size()]);
		System.out.println(Arrays.toString(sArr));
	}
}
