package pkgcollection;
//泛型定义在接口上
interface Inter<T>{
	void show(T t);
}
//class InterImpl implements Inter<String>{
//	public void show(String s){
//		System.out.println(s);
//	}
//}

class InterImpl2<T> implements Inter<T>{
	public void show(T t){
		System.out.println(t);
	}
}
public class GenericDemo5 {
	public static void main(String[] args) {
//		InterImpl ii = new InterImpl();
//		ii.show("fda");
		InterImpl2<Integer> ii2 = new InterImpl2<Integer>();
		ii2.show(32);
	}
}
