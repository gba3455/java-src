package pkgcollection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class DianQi{
	private String name;
	private int year;
	public DianQi(String name,int year){
		this.name = name;
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String toString(){
		return "DianQi:" + name + "year :" + year;
	}
}
class TV extends DianQi{
	public TV(String name,int year){
		super(name,year);
	}
}
class DVD extends DianQi{
	public DVD(String name,int year){
		super(name,year);
	}
}
class DianQiComp implements Comparator<DianQi>{//<? super E>上限 父类
	public int compare(DianQi d1,DianQi d2){
		int num = new Integer(d1.getYear()).compareTo(new Integer(d2.getYear()));
		if(num == 0){
			return d1.getName().compareTo(d2.getName());
		}
		return num;
	}
}
public class GenericUse {
	public static void main(String[] args) {
		TreeSet<TV> TVTS = new TreeSet<TV>(new DianQiComp());
		TVTS.add(new TV("sony",2009));
		TVTS.add(new TV("TCL",2008));
		TVTS.add(new TV("SUMSING",2014));
		
//		Iterator<TV> it = TVTS.iterator();
//		while(it.hasNext()){
//			TV tv = it.next();
//			System.out.println("电视" + tv.getName() + "年份" + tv.getYear());
//		}
		
		TreeSet<DVD> DVDTS = new TreeSet<DVD>(new DianQiComp());
		DVDTS.add(new DVD("Sony",2003));
		DVDTS.add(new DVD("AVOI",2008));
		DVDTS.add(new DVD("BLUERAY",2013));
		
//		Iterator<DVD> it2 = DVDTS.iterator();
//		while(it2.hasNext()){
//			DVD dvd = it2.next();
//			System.out.println("影碟机" + dvd.getName() + "年份" + dvd.getYear());
//		}
		
		myIteratorMethod(TVTS);
		myIteratorMethod(DVDTS);
	}
	
	public static void myIteratorMethod(TreeSet<? extends DianQi> t){//<? extends E>下限 子类
		Iterator<? extends DianQi> it = t.iterator();
		while(it.hasNext()){
			DianQi d = it.next();
			if(d instanceof TV){
				System.out.println("电视" + d.getName() + "年份" + d.getYear());
			}else if(d instanceof DVD){
				System.out.println("影碟机" + d.getName() + "年份" + d.getYear());
			}
		}
	}
}
