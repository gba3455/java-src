package pkg23designmodel;
/**
 * 单例设计模式:解决一个类在内存中只存在一个对象
 * 
 * 想要保证对象唯一:
 * 1:为了避免其他程序过多简历该类对象,先禁止其他程序简历该类对象.
 * 2:为了让其他程序可以访问到该类对象,只好在本类中,自定义一个对象
 * 3:为了方便其他程序对自定义对象的访问,可以对外提供一些访问方式
 * 
 * 实现方法:
 * 1:将构造函数私有化
 * 2:在类中创建一个本类对象
 * 3:提供一个方法可以获取到该对象
 * @author SQZS
 *
 *对于事物该怎么描述,还怎么描述.
 *当需要讲该事物的对象保证在内存中唯一时,就讲以上的三步加上即可.
 *
class Student{
	private int age;
	private Student(){
		
	}
	private static Student s = new Student();
	public static Student getInstance(){
		return s;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
 */
//这个是先初始化对象:饿汉式,开发一般用这个,简单,安全.
class Single{
	private Single(){
	}
	private static final Single s = new Single();
	public static Single getInstance(){
		return s;
	}
}

//写法2 对象是方法被调用时,才初始化,也叫对象的延时加载.懒汉式
//Single2类进内存,对象还不存在,只有调用getInstance方法,才建立对象
//如果多人同时调用这个方法,有可能会出问题.多线程进if也会出问题
class Single2{
	private static Single2 s = null;
	public static Single2 getInstance(){
		if(s == null)
			s = new Single2();
		return s;
	}
}

public class SingleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Single s = Single.getInstance();
		Single s2 = Single.getInstance();
	}

}
