package pkgthread;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 函数需要被对象调用.那么函数都有一个所属对象引用.就是this 所以同步函数使用的锁是this
 * 
 * 使用2个线程来卖票 一个线程在同步代码快中 一个线程在同步函数中 都在执行卖票动作
 * 
 * @author SQZS
 * 
 */
// class sale extends Thread{
class sale1 implements Runnable {
	private int tick = 100;// 如果不用static就会重复卖票.
	Object obj = new Object();
	boolean flag = true;

	// public synchronized void run()
	// {//如果用synchronized,线程进来后别的线程进不来,所有票都被第一个线程卖掉.解决:把要同步的内容封装到新的同步函数里
	public void run() {
		if (flag) {
			while (true) {
//				synchronized (obj) {//用的是obj锁,卖票有可能出错,卖出0票.所以要用和show一样的锁.
				synchronized (this) {//用的是obj锁,卖票有可能出错,卖出0票.所以要用和show一样的锁.
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

	public synchronized void show() {// 用的是this锁

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

public class TicketThread2 {

	public static void main(String[] args) {
		sale1 s = new sale1();// 这里只建乐一个sale对象,所以内存里只有一个tick变量.所以可以不用static
		Thread t = new Thread(s);
		Thread t1 = new Thread(s);
		// Thread t2 = new Thread(s);
		// Thread t3 = new Thread(s);
		t.start();
		// 一开始有主线程和2个线程,一开始主线程有执行权,一瞬间吧3句话都执行了,所以flag被改成false,所以只会运行show函数
		// 所以让主线程睡觉一下,这时只有t有执行权.
		try {
			Thread.sleep(10);
		} catch (Exception e) {
		}
		s.flag = false;
		t1.start();
		// t2.start();
		// t3.start();
	}

}
