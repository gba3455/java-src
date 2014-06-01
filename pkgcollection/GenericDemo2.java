package pkgcollection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class GenericDemo2 {
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>(new LenComparator());
		
		ts.add("fdafds");
		ts.add("hahah");
		ts.add("abac");
		ts.add("wds");
		ts.add("ads");
		
		Iterator<String> it = ts.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
class LenComparator implements Comparator<String>{
	public int compare(String o1,String o2){
		int num = new Integer(o1.length()).compareTo(new Integer(o2.length()));
		if(num == 0){
			return o1.compareTo(o2);
		}
		return num;
	}
}
