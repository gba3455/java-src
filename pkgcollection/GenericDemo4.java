package pkgcollection;
/*
 * 泛型用在方法上
 */
class GenericClass<T>{
	public void show(T t){
		System.out.println(t);
	}
	public void pirnt(T t){
		System.out.println(t);
	}
}

//泛型类定义的泛型,在整个类中有效.如果被方法使用.
//那么泛型类的对象明确要操作的具体类型后,所有要操作的类型就已经确定了.
//为了让不同方法可以操作不同类型,而且类型还不确定.
//那么可以将泛型定义在方法上 

/*
 * 特殊之处:
 * 静态方法不可以访问类上定义的泛型.
 * 如果静态方法操作的引用数据类型不确定,可以将泛型定义在方法上.
 */
//class GenericMethod{
//	public <T> void show(T t){
//		System.out.println(t);
//	}
//	public <T> void print(T t){
//		System.out.println(t);
//	}
//}
class GenericMethod<T>{
	public void show(T t){
		System.out.println(t);
	}
	public <T> void print(T t){
		System.out.println(t);
	}
	//静态泛型
	public static <W> void method(W w){//泛型放在返回值的前面,修饰符的后面
		System.out.println("method:" + w);
	}
}
public class GenericDemo4 {
	public static void main(String[] args) {
//		GenericClass<String> gm = new GenericClass<String>();
//		gm.show("fdafd");
//		gm.pirnt("hehe");
//		GenericClass<Integer> gm = new GenericClass<Integer>();
//		gm.show(new Integer(32));
//		gm.pirnt(43);
//		GenericClass<Integer> gm = new GenericClass<Integer>();
//		gm.show(new Integer(32));
//		gm.pirnt("fda");//泛型定义为Integer这里传String就会报错.
		//为了可以传任意类型,可以吧泛型定义在方法上.
//		GenericMethod g = new GenericMethod();
//		g.show("ffda");
//		g.show(2432);
//		g.print("fda");
//		g.print(434);
		GenericMethod<String> g = new GenericMethod<String>();
		g.show("fda");
//		g.show(3);错
		g.print("fda");
		g.print(4);
		GenericMethod.method("fdas");
	}
}
