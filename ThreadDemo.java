import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo {

	/**
	 * Semaphore 就是大学操作系统里面讲的信号量， 其方法acquire和release分别对应PV操作 
	 * AtomicInteger是原子变量，对它的操作会转化为底层的原语（不可分割的操作），这样多线程并发对其操作就不会有问题， 如果是普通的int就还要加锁才能保证没问题
	 */
	public static void main(String[] args) throws InterruptedException {
		// 用于启动另一个线程
		Semaphore startThread = new Semaphore(1);
		// 用于控制终止程序
		AtomicInteger threadCount = new AtomicInteger(0);

		for (int i = 1; i <= 10; i++) {
			CountThread t = new CountThread("Thread" + i, startThread,
					threadCount);
			t.start();
		}
	}
}

class CountThread extends Thread {
	// 线程标识
	private String label;
	// 用于启动另一个线程
	private Semaphore startThread;
	// 用于控制终止程序
	private AtomicInteger threadCount;

	public CountThread(String label, Semaphore startThread,
			AtomicInteger threadCount) {
		this.label = label;
		this.startThread = startThread;
		this.threadCount = threadCount;
	}

	public void run() {
		try {
			// 等待线程被唤醒
			startThread.acquire();

			System.out.println("------线程:" + label + " 开始工作------");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int num = 0;
		while (true) {
			System.out.println("线程:" + label + "计数:" + num);
			// 计数到5
			if (num++ == 5) {
				// 唤醒另一个计数线程
				startThread.release();
				// 10的时候程序终止, incrementAndGet是递增(也就是++操作), 再取值
				if (threadCount.incrementAndGet() == 10) {
					System.exit(1);
				}
			}
		}
	}
}