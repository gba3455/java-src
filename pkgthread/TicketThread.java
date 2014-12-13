package pkgthread;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 创建线程方法2:实现Runnable接口
 * 
 * 1定义类实现Runnable接口 2覆盖run方法 将线程要运行的代码存放在该run方法中 3通过Thread类简历线程对象
 * 4将Runnable接口的子类对象作为实际参数传递给Thread类的够着函数 为什么要将Runnabel接口的子类对象传递给Thread的构造函数
 * 因为,自定义的run方法所属的对象是Runnabel接口的子类对象. 所以要让线程去执行指定对象的run方法,就必须明确该run方法所属的对象
 * 5调用Thread类的start方法开启线程并调用Runnabel接口子类的run方法
 * 
 * 
 * 实现方式和继承方式的区别: java只支持单继承.如果用继承方法,就不能继承别的父类了 避免单继承的局限性 资源可以被独立共享 存放位置不一样:
 * 继承Thread:线程代码存放在Thread子类run方法中: 实现Runnable:线程代码存放在接口的子类的run方法中
 * 
 * 同步的前提:
 * 1必须要有2个或2个以上的线程.
 * 2必须是多个线程使用同一个锁
 * 
 * 必须保证同步中只能有一个线程在运行.
 * @author SQZS
 * 
 */
// class sale extends Thread{
class sale implements Runnable {
	private int tick = 100;// 如果不用static就会重复卖票.
	Object obj = new Object();

//	public synchronized void run() {//如果用synchronized,线程进来后别的线程进不来,所有票都被第一个线程卖掉.解决:把要同步的内容封装到新的同步函数里
	public void run() {
		while (true) {
			// 线程休眠后,会卖错票.重复买票.线程安全问题
			// 当多条语句在操作同一个线程共享数据时,一个线程对多条语句只执行了一部分,还没有执行完,
			// 另外一个线程参与进来执行,导致共享数据的错误.
			// 解决办法:
			// 对多条操作共享数据的语句,只能让一个线程都执行完,再执行过程中,其他线程不能参与执行.

			/**
			 * java对于多线程的安全问题,提供了专业的解决方式.就是同步代码块.
			 * Synchronized(任意对象){//任意对象,为了免去新建一个无用的类创建对象,不如直接用Obejct类 需要被同步的代码
			 * 弊端:虽然解决了多线程的安全问题,但是外面的线程每次都会判断锁的状态,浪费计算机资源
			 */
			// synchronized (new Object()) {
			//效率低 运行时间1123毫秒
			synchronized (obj) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (tick > 0) {
					System.out.println(Thread.currentThread().getName()
							+ " ---- " + tick);
					tick--;
				}else{
					break;
				}
			}
			//效率高.运行时间284毫秒
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			if (tick > 0) {
//				synchronized (obj) {
//				System.out.println(Thread.currentThread().getName()
//						+ " ---- " + tick);
//				}
//				tick--;
//			}else{
//				break;
//			}
		}
	}
}
public class TicketThread {

	public static void main(String[] args) {
		// sale s = new sale();
		// sale s1 = new sale();
		// sale s2 = new sale();
		// sale s3 = new sale();
		//
		//
		// //异常,已经start一次,进入运行状态,再start已经没有意义.所以线程状态异常
		// // s.start();
		// // s.start();
		// // s.start();
		// // s.start();
		//
		//
		// s.start();
		// s1.start();
		// s2.start();
		// s3.start();
		// //如果不用static就会重复卖票.java里要尽量少用static,所以为了不用static
		sale s = new sale();// 这里只建乐一个sale对象,所以内存里只有一个tick变量.所以可以不用static
		Thread t = new Thread(s);
		Thread t1 = new Thread(s);
		Thread t2 = new Thread(s);
		Thread t3 = new Thread(s);
//		long start = System.currentTimeMillis();
		t.start();
		t1.start();
		t2.start();
		t3.start();
		
//		try {
//			t.join();
//			t2.join();
//			t3.join();
//			t1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 Thread[] tArr = new Thread[4];
//		 for (Thread thread : tArr) {
//		 thread = new Thread(s);
//		 thread.start();
//		 try {
//			thread.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 }
		 
//		 long end = System.currentTimeMillis();
//		 System.out.println(end - start);
	}

}
