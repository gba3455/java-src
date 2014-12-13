package pkgcollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Teacher {

}

class strLenCompare implements Comparator<String> {
	public int compare(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return 1;
		}
		if (s1.length() < s2.length()) {
			return -1;
		}
		return s1.compareTo(s2);
	}
}

public class CollectionsDemo {
	public static void main(String[] args) {
		// sort();
		// max();

		List<String> strList = new ArrayList<String>();

		strList.add("bbbb");
		strList.add("ba");
		strList.add("qerbb");
		strList.add("rerb");
		strList.add("b");
		strList.add("zz");

		sop(strList);
		// int index = Collections.binarySearch(strList, "c");
		int index = halfSearch(strList, "c");
		sop(index);
	}

	// private static int halfSearch(List<String> list,String key){
	private static <T> int halfSearch(List<T> list, String key) {
		int max, mid, min;
		max = list.size();
		min = 0;
		while (min < max) {
			mid = (max + min) >> 1;// max >> 1等于max / 2;
			String str = (String) list.get(mid);
			int num = str.compareTo(key);
			if (num > 0) {
				max = mid - 1;
			} else if (num < 0) {
				min = mid + 1;
			} else {
				return mid;
			}
		}
		return -min - 1;// min的位数等于key插入list后顺序可以保持不乱得下标数字
	}

	private static int halfSearch(List<String> list, String key, Comparator cmp) {//用比较器
		int max, mid, min;
		max = list.size();
		min = 0;
		while (min < max) {
			mid = (max + min) >> 1;// max >> 1等于max / 2;
			String str = (String) list.get(mid);
			int num = cmp.compare(str, key);
			if (num > 0) {
				max = mid - 1;
			} else if (num < 0) {
				min = mid + 1;
			} else {
				return mid;
			}
		}
		return -min - 1;// min的位数等于key插入list后顺序可以保持不乱得下标数字
	}

	private static void max() {
		List<String> strList = new ArrayList<String>();

		strList.add("bbbb");
		strList.add("ba");
		strList.add("qerbb");
		strList.add("rerb");
		strList.add("b");
		strList.add("zz");

		// sop(strList);
		// Collections.sort(strList);
		sop(strList);
		String max = Collections.max(strList, new strLenCompare());
		sop(max);
	}

	private static void sort() {
		List<String> strList = new ArrayList<String>();

		strList.add("bbbb");
		strList.add("ba");
		strList.add("qerbb");
		strList.add("rerb");
		strList.add("b");
		strList.add("zz");

		sop(strList);

		Collections.sort(strList);

		sop(strList);

		Collections.sort(strList, new strLenCompare());
		sop(strList);
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

	// public static <T extends Comparable<? super T>> void sort(List<T> list){
	//
	// }
}