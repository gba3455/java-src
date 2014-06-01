package pkgthread;

//饿汉式就一句话,不会出问题
/**
 * class Single{
	private static final Single s = new Single();
	private Single(){}
	public static Single getInstance(){
		return s;
	}
}
 */

/**
 * 懒汉式麻烦,但是面试容易考
 * 懒汉和饿汉式的区别?懒汉的特点在于实例的延迟加载.
 * 懒汉式延迟加载有没有问题?有,如果多线程访问时会出现安全问题.可以加同步来解决.
 * 用同步函数或者同步代码块都行.但是同步函数效率低.用双重判断的形式可以解决效率问题.
 * 加同步的时候使用的锁是哪一个?该类所属的字节码文件对象
 * 
 * 请写一个延迟加载的单例设计模式示例
 */
class Single{
	private static Single s = null;
	private Single(){
	}
//	public static synchronized Single getInstnace(){//每次都判断锁,效率低,所以要改静态块
//		if(s == null)
//			s = new Single();
//		return s;
//	}
	//改写后.减少判断锁的次数
	public static synchronized Single getInstnace(){//每次都判断锁,效率低,所以要改静态块
		if(s == null){			
			synchronized (Single.class) {
				if(s == null)
					//--->A;
					s = new Single();
			}
		}
		return s;
	}
}
public class SingleDesignModelThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
