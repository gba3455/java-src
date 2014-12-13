package pkgthread;
/**
 * join:
 * 当A线程执行到了B线程的join方法时,A线程就会等待.等B线程都
 * 执行完,A才会执行.
 * 
 * join可以用来临时加入线程执行
 * @author SQZS
 *
 */
class Join implements Runnable {
	@Override
	public void run() {
		for(int x = 0; x < 70; x++){
			System.out.println(Thread.currentThread().toString() + "....." + x);
			Thread.yield();
		}
	}
}

public class JoinDemo {
	public static void main(String[] args) throws InterruptedException {
		Join j = new Join();
		Thread t1 = new Thread(j);
		Thread t2 = new Thread(j);
		
//		t1.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		
		//t1.join();//t1要加入到运行中,要cpu执行权.join抢夺cpu执行权.主线程看到join就吧执行权放出来.这个时候主线程处于冻结状态,不会跟t1抢执行权.t1拿到执行权后
		//吧t1运行完,主线程才活过来.
		t2.start();
		
		for(int x = 0; x < 80; x++){
//			System.out.println("main" + x);
		}
		System.out.println("over");
	}
}
