package pkgcollection;

import java.util.ArrayList;
import java.util.Iterator;
/*
 * ?通配符.也可以理解为占位符.
 * 泛型的限定:
 * ? exntends E:可以接受E类型或者E的子类型.上限.
 * ? super E:可以接受E类型或者E的父类.下限.
 */
class Persons{
	String name;
	Persons(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}
class Stu extends Persons{
	Stu(String name){
		super(name);//
	}
	public String getName(){
		return name;
	}
}
public class GenericDemo7 {
	public static void main(String[] args) {
		ArrayList<Persons> al = new ArrayList<Persons>();
		al.add(new Persons("abc1"));
		al.add(new Persons("abc2"));
		al.add(new Persons("abc3"));
		
		ArrayList<Stu> al1 = new ArrayList<Stu>();
		al1.add(new Stu("st1"));
		al1.add(new Stu("st2"));
		al1.add(new Stu("st3"));
		
		printColl(al1);//ArrayList<Persons> al = new ArrayList<Stu>();//error
	}
//	public static void printColl(ArrayList<?> al){
//		Iterator<?> it = al.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next().getName());//这里getName出错.无法调用getName方法.所以要用泛型限定符
//		}
//	}
	//泛型限定符	
	public static void printColl(ArrayList<? extends Persons> al){
		Iterator<? extends Persons> it = al.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getName());//这样就可以调用getName方法
		}
	}
}
