package pkgthread;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *如果同步函数被静态修饰后,使用的锁是Class对象
 *不再是this了,因为静态方法中不可以定义this 
 *静态进内存时,内存中没有本类对象,但是一定有该类对应的字节码文件对象
 *类名.class 该对象的类型是Class
 *
 *静态的同步方法,使用的锁是该方法所在类的字节码文件对象.类名.class
 * @author SQZS
 * 
 */
// class sale extends Thread{
class sale2 implements Runnable {
	private static int tick = 100;// 如果不用static就会重复卖票.
	Object obj = new Object();
	boolean flag = true;
	public void run() {
		if (flag) {
			while (true) {
//				synchronized (this) {//用的是obj锁,卖票有可能出错,卖出0票.所以要用和show一样的锁.
				synchronized (sale2.class) {//用的是obj锁,卖票有可能出错,卖出0票.所以要用和show一样的锁.
					if (tick > 0) {
						try {Thread.sleep(10);} catch (InterruptedException e) {}
						System.out.println(Thread.currentThread().getName()
								+ " ---- " + tick);
						tick--;
					}else{
						break;
					}
				}
			}
		} else {
		}
		while (true) {
			show();
		}

	}

	public static synchronized void show() {// 用的是this锁

		if (tick > 0) {
			try {Thread.sleep(10);} catch (InterruptedException e) {}
			System.out.println(Thread.currentThread().getName() + " --show-- "
					+ tick);
			tick--;
		}else{
			System.exit(0);
		}
	}
}

public class StaticTicketThread2 {

	public static void main(String[] args) {
		sale2 s = new sale2();// 这里只建乐一个sale对象,所以内存里只有一个tick变量.所以可以不用static
		Thread t = new Thread(s);
		Thread t1 = new Thread(s);
		t.start();
		// 一开始有主线程和2个线程,一开始主线程有执行权,一瞬间吧3句话都执行了,所以flag被改成false,所以只会运行show函数
		// 所以让主线程睡觉一下,这时只有t有执行权.
		try {
			Thread.sleep(10);
		} catch (Exception e) {
		}
		s.flag = false;
		t1.start();
	}

}
