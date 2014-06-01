package pkgthread;
/**
 * 开启多线程运行,运行代码通常事循环结构.
 * 只要控制住循环,就可以让run方法结束,也就是线程结束.
 * 特殊情况:
 * 当线程处于wait状态,就不会读取到标记,那么线程就不会结束. 
 * Interrupted方法将处于冻结状态的线程强制恢复到运行状态.清除线程的冻结状态.
 * @author SQZS
 * 当没有指定的方式让冻结的线程恢复到运行状态时,就需要对冻结进行清除.
 * 强制让线程恢复到运行状态中来.这样就可以操作标记让线程结束.
 * 
 * Thread类提供Interrupt方法.
 * 
 * 后台线程的特点是开启后和前台线程一样,当所有前台线程都结束后,后台线程会
 * 自动结束.别的和前台线程一样.
 */
class StopThread implements Runnable{
	private boolean flag = true;
	@Override
	public synchronized void run() {
		while(flag){
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("exception");
				flag = false;
			}
			System.out.println(Thread.currentThread().getName() + "-----run");
		}
	}
	public void changeFlag(){
		flag = false;
	}
}
public class StopThreadDemo {
	public static void main(String[] args) {
		StopThread st = new StopThread();
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		t1.setDaemon(true);
		t2.setDaemon(true);
		t1.start();
		t2.start();
		int num = 0;
		while(true){
			if(num++ == 60){
//				st.changeFlag();
//				t1.interrupt();
//				t2.interrupt();
				break;
			}
			System.out.println(Thread.currentThread().getName() + "........." + num);
		}
	}
}
