package pkgthread;
import java.lang.Thread;
/**
 * 死锁:同步中嵌套同步.
 */
class TestDeadLock implements Runnable {
	boolean flag;

	TestDeadLock(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		if (flag) {
			while(true){
				synchronized (MyLock.locka) {
					System.out.println("if locka");
					synchronized (MyLock.lockb) {
						System.out.println("if lockb");
					}
				}	
			}
			
		} else {
			while(true){
				synchronized (MyLock.lockb) {
					System.out.println("else lockb");
					synchronized (MyLock.locka) {
						System.out.println("else locka");
					}
				}
			}
		}
	}

}

class MyLock {
	static Object locka = new Object();
	static Object lockb = new Object();

}

public class DeadLockThread {

	public static void main(String[] args) {
		Thread t1 = new Thread(new TestDeadLock(true));
		Thread t2 = new Thread(new TestDeadLock(false));
		t1.start();
		t2.start();
	}
}
