package pkgthread;
/**
 * wait();notify();notifyAll()都使用在同步中,因为要对持有监视器(锁)的线程操作.
 * 所以要使用在同步中,因为只有同步才具有锁.
 * 为什么这些操作线程的方法要定义在Object中,因为这些方法在操作同步中线程时,都必须要标示
 * 他们所操作线程持有的锁,只有同一个锁上的被等待线程,可以被同一个锁上的notify唤醒.
 * 不可以对不同锁中的线程进行唤醒.
 * 
 * 也就是说,等待和唤醒必须是同一个锁.
 * 
 * 而锁可以是任意对象,所以可以被任意对象调用的方法定义在Object类中.
 * @author SQZS
 *
 */
//class Res1{
//	String name;
//	String sex;
//	boolean flag = false;
//}
//class Input1 implements Runnable{
//	private Res1 r;
//	Input1(Res1 r){
//		this.r = r;
//	}
//	public void run() {
//		int x = 0;
//			while(true){
//				synchronized (r) {
//
//					if(r.flag){
//						try {r.wait();} catch (InterruptedException e) {e.printStackTrace();}
//					}else{
//						if(x == 0){
//							r.name = "mike";
//							r.sex = "man";
//						}else{
//							r.name = "李丽丽";
//							r.sex = "女女女女";
//						}
//						x = (x + 1) % 2;
//						r.flag = true;
//						r.notify();
//						}
//					}
//						
//		}
//	}
//	
//}
//class Output1 implements Runnable{
//	private Res1 r;
//	Output1(Res1 r) {
//		this.r = r;
//	}
//	public void run() {
//		while(true){
//			synchronized (r) {
//				if(!r.flag){
//					try {r.wait();} catch (InterruptedException e) {e.printStackTrace();}
//				}
//				else{
//					System.out.println(r.name + "------" + r.sex);
//					r.flag = false;
//					r.notify();
//				}
//			}
//		}
//	}
//}
//public class WaitNotify {
//
//	public static void main(String[] args) {
//		Res1 res = new Res1();
//		Input1 in = new Input1(res);
//		Output1 out = new Output1(res);
//		Thread t1 = new Thread(in);
//		Thread t2 = new Thread(out);
//		
//		t1.start();
//		t2.start();
//	}
//
//}

/**
 * 代码优化 资源内容私有化
 * @author SQZS
 *
 */
class Res1{
	private String name;
	private String sex;
	private boolean flag = false;
//	public void set(String name,String sex) {//会出安全问题
//		this.name = name;
//		//------,赋值了姓名有可能停住,所以需要同步,函数里只有2句话,所以不用同步代码块
//		this.sex = sex;
//	}
//	public void out(){
//		System.out.println(name + "----" + sex);
//	}
	public synchronized void set(String name,String sex) {
		if(flag){
			try {this.wait();} catch (InterruptedException e) {e.printStackTrace();}
		}
			this.name = name;
			this.sex = sex;
			flag = true;
			this.notify();
	}
	public synchronized void out(){
		if(!flag){
			try {this.wait();} catch (InterruptedException e) {e.printStackTrace();}
		}else{
			System.out.println(name + "----" + sex);
			flag = false;
			this.notify();
		}
	}
}
class Input1 implements Runnable{
	private Res1 r;
	Input1(Res1 r){
		this.r = r;
	}
	public void run() {
	int x = 0;
		while(true){
			if(x == 0){
				r.set("mike","man");
			}else{
				r.set("李丽丽","女女女女");
			}
			x = (x + 1) % 2;
		}
	}
	
}
class Output1 implements Runnable{
	private Res1 r;
	Output1(Res1 r) {
		this.r = r;
	}
	public void run() {
		while(true){
			r.out();
		}
	}
}
public class WaitNotify {

	public static void main(String[] args) {
		Res1 res = new Res1();
//		Input1 in = new Input1(res);
//		Output1 out = new Output1(res);
//		Thread t1 = new Thread(in);
//		Thread t2 = new Thread(out);
//		
//		t1.start();
//		t2.start();
		
		new Thread(new Input1(res)).start();
		new Thread(new Output1(res)).start();
	}

}
