package pkgset;

import java.util.SortedSet;
import java.util.TreeSet;


public class TestSortedSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedSet<String> sortedSet = new TreeSet<String>();
		sortedSet.add("ac");
		sortedSet.add("aa");
		sortedSet.add("ab");
		System.out.println(sortedSet);
	}

}
