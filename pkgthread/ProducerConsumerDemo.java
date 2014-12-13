package pkgthread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 对于多个生产者和消费者，
 * 为什么要定义while判断标记，
 * 
 * 原因，让被唤醒的线程再一次判断标记，
 * 
 * 为什么定义notifyAll
 * 
 * 因为需要唤醒对方线程，因为只用notify，容易出现只换醒本方线程的情况，导致程序中的所有线程都等待。
 * @author SQZS
 *
 */
//class Resource{
//	private String name;
//	private int count = 1;
//	private boolean flag = false;
//	public synchronized void set(String name){
////		if(flag){
//		while(flag){
//			try {
//				wait();//t1 放弃资格 t2获取资格
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		this.name = name + ":" + count++;
//		System.out.println(Thread.currentThread().getName() + "!!!!!!生产者!!!!!!" + this.name);
//		flag = true;
//		notifyAll();
//	}
//	public synchronized void out(){
////		if(!flag){
//		while(!flag){
//			try {
//				wait();//t3 放弃资格 t4放弃资格
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		System.out.println(Thread.currentThread().getName() + "消费者" + name);
//		flag = false;
//		notifyAll();
//	}
//}
//class Producer implements Runnable{
//	Resource res;
//	public Producer(Resource res) {
//		this.res = res;
//	}
//	@Override
//	public void run() {
//		while(true){
//				res.set("商品");
//		}
//	}
//}
//class Consumer implements Runnable{
//	private Resource res;
//	public Consumer(Resource res) {
//		this.res = res;
//	}
//	@Override
//	public void run() {
//		while(true){
//			res.out();
//		}
//	}
//}
//public class ProducerConsumerDemo {
//	public static void main(String[] args) {
//		Resource res = new Resource();
//		
//		Producer pro = new Producer(res);
//		Consumer con = new Consumer(res);
//		
//		Thread t1 = new Thread(pro);
//		Thread t2 = new Thread(pro);
//		Thread t3 = new Thread(con);
//		Thread t4 = new Thread(con);
//		
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
//		
//		//多个生产者和消费者时,出问题.t1唤醒时有可能把本方的消费者t2唤醒.
//		//t2唤醒后没判断flag标记,又继续生产商品,而把原本的商品覆盖.
//		//所以吧if该为while循环,就可以每次都判断标记
//		//再吧notify改为notifyAll,把全部线程都唤醒.
//		//if notify只适合一个生产者一个消费者的情况.
//	}
//}

/**
 * JDK1.5中提供了多线程升级解决方案
 * 提供了显示的锁机制,以及显示的锁对象上的等待唤醒操作机制
 * 一个锁可以对应多个Condition,以前一个锁只能对应一个对象
 * 以前想再有一组wait notify,需要再建一个锁.
 * 再建锁就要再建一个同步,2个锁形成嵌套就容易死锁.
 * 将同步synchronized替换成现实Lock操作
 * 将Object中的wait,notify,notifyAll
 * 替换了Condition对象,该对象可以Lock锁进行获取
 * 该示例中,实现了本方只唤醒对方的操作
 * @author SQZS
 *
 */
class Resource{
	private String name;
	private int count = 1;
	private boolean flag = false;
	private Lock lock = new ReentrantLock();
	private Condition condition_pro = lock.newCondition();
	private Condition condition_con = lock.newCondition();
	public void set(String name) throws InterruptedException{
//		if(flag){
		lock.lock();
			try {
				while(flag){
					condition_pro.await();

				}
				this.name = name + ":" + count++;
				System.out.println(Thread.currentThread().getName() + "!!!!!!生产者!!!!!!" + this.name);
				flag = true;
				condition_con.signal();
			} finally{
				lock.unlock();//释放锁的动作一定要执行
			}
	}
	public void out() throws InterruptedException{
		lock.lock();
//		if(!flag){
		try{
			while(!flag){
				condition_con.await();
			}
			System.out.println(Thread.currentThread().getName() + "消费者" + name);
			flag = false;
			condition_pro.signal();
		}finally{
			lock.unlock();
		}
	}
}
class Producer implements Runnable{
	Resource res;
	public Producer(Resource res) {
		this.res = res;
	}
	@Override
	public void run() {
		while(true){
				try {
					res.set("商品");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
class Consumer implements Runnable{
	private Resource res;
	public Consumer(Resource res) {
		this.res = res;
	}
	@Override
	public void run() {
		while(true){
			try {
				res.out();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class ProducerConsumerDemo {
	public static void main(String[] args) {
		Resource res = new Resource();
		
		Producer pro = new Producer(res);
		Consumer con = new Consumer(res);
		
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(pro);
		Thread t3 = new Thread(con);
		Thread t4 = new Thread(con);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		//多个生产者和消费者时,出问题.t1唤醒时有可能把本方的消费者t2唤醒.
		//t2唤醒后没判断flag标记,又继续生产商品,而把原本的商品覆盖.
		//所以吧if该为while循环,就可以每次都判断标记
		//再吧notify改为notifyAll,把全部线程都唤醒.
		//if notify只适合一个生产者一个消费者的情况.
	}
}
