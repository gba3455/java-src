package pkgset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyComparator implements Comparator<Student>{
	// 提供一种比较规则的比较器 相当于第三方 (裁判)

	@Override
	// 比较用来排序的两个参数。
	// 随第一个参数小于、等于或大于第二个参数而分别返回负整数、零或正整数。
	public int compare(Student s1, Student s2) {
		// TODO Auto-generated method stub
		System.out.println("compare():s1=" + s1 + "--s2=" + s2);
		return -s1.compareTo(s2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("c");
		list.add("a");
		list.add("b");
		list.add("d");
		
		System.out.println(list);
		// 指定规则进行排序 字符串的逆序排列
//		Collections.sort(list, new MyComparator());
		System.out.println("逆序排列:" + list);
		
		// Collections是集合Collection的帮助类 提供了一系列的静态方法处理集合
		String max = Collections.max(list);// 获得集合中的最大值
		System.out.println(max);
		
		// 把集合转换成数组
		String[] arr = new String[list.size()];
		arr = list.toArray(arr);
		
		//// 数组的帮助类Arrays
		System.out.println(Arrays.toString(arr));
		
		// 把数组转换成集合
		List<String> aList = Arrays.asList(arr);
		System.out.println(aList);
		
		// 针对数组进行排列
		int[] arrInt = new int[]{1,3,44,5,3};
		Arrays.sort(arrInt);
		System.out.println(Arrays.toString(arrInt));
	}

}
