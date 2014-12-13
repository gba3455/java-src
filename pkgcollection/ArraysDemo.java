package pkgcollection;

import java.util.Arrays;
import java.util.List;
/*
 * Arrays:用于操作数组的静态工具类
 * 里面都是静态方法
 * 
 * asList:将数组变成list集合
 */
public class ArraysDemo {
	public static void main(String[] args) {
		String[] arr = {"aa","fda","few"};
		
		List<String> list = Arrays.asList(arr);
		
		sop(list);
		
		//把数组变成list集合有什么好处?可以使用集合的思想和方法来操作数组中的元素
		//注意:将数组变成集合,不可以使用集合的增删方法.因为数组的长度是固定的.
		//contains get indexOf subList都可以用.就是不能增删
		//如果增删,那么会发生UnsupportedOperationException
		
		sop(list.contains("aa"));
		
//		list.add("fda");//UnsupportedOperationException
		
		//如果数组中的元素都是对象,那么变成集合时,数组中的元素就直接转成集合中的元素.
		//如果数组中的元素都是基本数据类型,那么会将该数组作为集合中的元素存在.
		
		int[] nums = {2,3,4};
//		List li = Arrays.asList(nums);
		List<int[]> li = Arrays.asList(nums);
		sop(li);
		
		Integer[] IntNum = {4,5,7};
		List<Integer> l = Arrays.asList(IntNum);
		sop(l);
		
	}
	private static boolean myContains(String[] arr,String str){
		for(int x = 0 ; x < arr.length ; x++){
			if(arr[x].equals(str)){
				return true;
			}
		}
		return false;
	}
	private static void sop(Object obj){
		System.out.println(obj);
	}
}
