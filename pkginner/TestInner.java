package pkginner;

import pkginner.inner.Outer;

public class TestInner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer outer = new Outer();
		Outer.StaticInner staticInner = new Outer.StaticInner();
		Outer.Inner inner = outer.new Inner();//通过对象加点来调用 创建对象 外部类对象.new 内部类名字
		staticInner.fun_static();
		inner.inner_Fun();
	}

}
