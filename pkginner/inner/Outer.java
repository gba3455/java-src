package pkginner.inner;


public class Outer {
	private int out_var = 10;
	public static String static_out_var = "static";
	private void out_Fun() {
		// TODO Auto-generated method stub
		System.out.println("外部类里的方法");
	}
	//类体里面的内部类都可以在外部使用 只要有权限
	//属于类的
	public static class StaticInner{
		//static修饰的只能访问外部类的static成员
		public StaticInner() {
			// TODO Auto-generated constructor stub
//			System.out.println("外部类的实例成员：" + out_var);//报错，不能访问外部类的非静态成员
			System.out.println("外部类的实例成员：" + static_out_var);
		}
		public void fun_static(){
			System.out.println("static内部类"+static_out_var);
		}
	}
	
	public void fun_class(){//方法里的内部类
		//方法体里面的内部类 不能用访问权限修饰 不能在方法外部使用
//		public class Fun_With_public{
//			 
//		}
		class Fun_class{//仅限在方法内使用
			int i = 9;
		}
		Fun_class fun_class = new Fun_class();
		System.out.println(fun_class.i);
	}
	
	//实例内部类 属于对象
	//一个类可以去访问另外一个类内的私有成员,那就吧这类设计为他的内部类
	//设计思想就是可以直接访问外部类的私有成员	内部类打破了封装 可以直接操作私有成员
	public class Inner{
		//可以访问外部类的私有成员
		public Inner() {
			// TODO Auto-generated constructor stub
			System.out.println("外部类的实例成员：" + out_var);
			System.out.println("外部类的实例成员：" + static_out_var);
			}
		public void inner_Fun() {
			// TODO Auto-generated method stub
			out_Fun();
		}
	}
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.StaticInner staticInner = new Outer.StaticInner();
		Outer.Inner inner = outer.new Inner();//通过对象加点来调用 创建对象 外部类对象.new 内部类名字
		staticInner.fun_static();
		inner.inner_Fun();
	}
}