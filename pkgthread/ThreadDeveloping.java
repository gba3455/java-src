package pkgthread;
/**
 * 当某些代码需要同时被执行时就用单独的线程进行封装.可以封装3个类出来.
 * 建立Thread类的子类对象
 * @author SQZS
 *
 */
public class ThreadDeveloping {
//	13484000
	static long time = 0;
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(){
			public void run() {
				long start = System.nanoTime();
				for(int i = 0; i < 100; i++){
					System.out.println(Thread.currentThread().getName() + "--------" + i);
				}
				long end = System.nanoTime();
				time += (end - start);
			};
		};
		Thread t2 = new Thread(){
			@Override
			public void run() {
				long start = System.nanoTime();
				for(int i = 0; i < 100; i++){
					System.out.println(Thread.currentThread().getName() + "--------" + i);
				}
				long end = System.nanoTime();
				time += (end - start);				
			}
		};
		new Thread(){
			@Override
			public void run() {
				long start = System.nanoTime();
				for(int i = 0; i < 100; i++){
					System.out.println(Thread.currentThread().getName() + "--------" + i);
				}
				long end = System.nanoTime();
				time += (end - start);
			}
		}.start();
		Thread.sleep(1000);
		System.out.println(time);
	}

}
