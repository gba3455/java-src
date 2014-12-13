package pkgcollection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Persons2{
	private String name;
	public Persons2(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public String toString(){
		return "Person:" + name;
	}
}
class Stu2 extends Persons2{
	public Stu2(String name){
		super(name);
	}
}
class Worker2 extends Persons2{
	public Worker2(String name){
		super(name);
	}
}
//class StuCompare implements Comparator<Stu2>{
//	public int compare(Stu2 o1,Stu2 o2){
//		return o1.getName().compareTo(o2.getName());
//	}
//}
//class WkCompare implements Comparator<Worker2>{
//	public int compare(Worker2 o1,Worker2 o2){
//		return o1.getName().compareTo(o2.getName());
//	}
//}
class PerCompare implements Comparator<Persons2>{
	public int compare(Persons2 p1,Persons2 p2){
		return p1.getName().compareTo(p2.getName());
	}
}
public class GenericDemo8 {
	public static void main(String[] args) {
//		TreeSet<Stu2> stuTS = new TreeSet<Stu2>(new StuCompare());
//		stuTS.add(new Stu2("abc2"));
//		stuTS.add(new Stu2("abc3"));
//		stuTS.add(new Stu2("abc1"));
//		
//		Iterator<Stu2> it = stuTS.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next().toString());
//		}
//		
//		TreeSet<Worker2> wkTS = new TreeSet<Worker2>(new WkCompare());
//		wkTS.add(new Worker2("wk4"));
//		wkTS.add(new Worker2("wk3"));
//		wkTS.add(new Worker2("wk7"));
//		
//		Iterator<Worker2> it2 = wkTS.iterator();
//		while(it2.hasNext()){
//			System.out.println(it2.next());
//			
//		}
		TreeSet<Stu2> stuTS = new TreeSet<Stu2>(new PerCompare());
		stuTS.add(new Stu2("abc2"));
		stuTS.add(new Stu2("abc3"));
		stuTS.add(new Stu2("abc1"));
		
		Iterator<Stu2> it = stuTS.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		
		TreeSet<Worker2> wkTS = new TreeSet<Worker2>(new PerCompare());
		wkTS.add(new Worker2("wk4"));
		wkTS.add(new Worker2("wk3"));
		wkTS.add(new Worker2("wk7"));
		
		Iterator<Worker2> it2 = wkTS.iterator();
		while(it2.hasNext()){
			System.out.println(it2.next());
			
		}
	}
}
