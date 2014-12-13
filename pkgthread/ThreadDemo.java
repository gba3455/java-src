package pkgthread;
/**
 * 定义类继承Thread
 * 重写Thread类中的run方法 目的:将自定义代码存储在run方法里让线程运行
 * 调用线程的start方法.该方法2个作用:启动线程,调用润方法
 * 
 * 为什么要覆盖run方法:
 * Thread类用于描述线程
 * 该类就定义了一个功能,用于储存线程要运行的代码,该粗存功能就是run方法
 * 也就是说run方法是用于存储线程要运行的代码
 * 主线程的方法放在main里
 * 
 * 线程都有自己的默认名称 Thread-0
 * @author SQZS
 *
 */
public class ThreadDemo extends Thread{
	public ThreadDemo(String name) {
		super(name);//设置名字
	}
	@Override
	public void run() {
		for (int i = 0; i < 60; i++) {
			System.out.println(this.getName() + i);
			//Thread.currentThread() 等于 this 用this不一定通用.Thread.currentThread()是标准通用方式
			System.out.println(Thread.currentThread().getName() + i);
		}
		super.run();
	}
	public static void main(String[] args) {
		ThreadDemo thread = new ThreadDemo("fda");//创建一个线程
		thread.start();//开启线程并执行该线程的run方法.
		ThreadDemo thread2 = new ThreadDemo("abc");
		thread2.start();
//		thread.run();//仅仅是对象调用方法.而线程创建了,并没有运行.相当于还是主线程来运行run.所以是run函数运行完以后,继续往下走
		for (int i = 0; i < 60; i++) {
			System.out.println("main");
		}
//		Thread t = new Thread();
//		t.start();
	}
}
