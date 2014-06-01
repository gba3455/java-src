package pkgcollection;

import java.util.Collections;
import java.util.TreeSet;
import java.util.Comparator;
class strComparator implements Comparator<String>{
	public int compare(String s1,String s2){
//		return s1.compareTo(s2);
//		return s2.compareTo(s1);
		int num = s1.compareTo(s2);
		if(num > 0){
			return 1;
		}
		else if(num < 0){
			return -1;
		}
		return num;
	}
}
class strLenComparator implements Comparator<String>{
	public int compare(String s1,String s2){
		if(s1.length() > s2.length()){
			return 1;
		}else if(s1.length() < s2.length()){
			return -1;
		}else{
			return s1.compareTo(s2);
		}
	}
}
public class ReverseOrderDemo {
	public static void main(String[] args) {
//		TreeSet<String> set = new TreeSet<String>(new strComparator());
//		TreeSet<String> set = new TreeSet<String>(Collections.reverseOrder());
//		TreeSet<String> set = new TreeSet<String>(new strLenComparator());
		TreeSet<String> set = new TreeSet<String>(Collections.reverseOrder(new strLenComparator()));
		
		set.add("abcde");
		set.add("aaa");
		set.add("cccc");
		set.add("fewq");
		set.add("b");
		
		sop(set);
	}
	private static void sop(Object obj){
		System.out.println(obj);
	}
}
