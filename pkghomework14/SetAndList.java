package pkghomework14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetAndList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set set = new HashSet();
		List list = new ArrayList();
		set.add("abc");
		set.add("abc");
		list.add("abc");
		list.add("abc");
		Iterator iterator = set.iterator();
		while(iterator.hasNext()){
			Object o = iterator.next();
			System.out.println(o);
		}
		System.out.println("------------------");
		for(Iterator iterator2 = list.iterator(); iterator2.hasNext();){
			Object o = iterator2.next();
			System.out.println(o);
		}
		
	}

}
