package pkgthread;
class Bank{
	private int money;
//	Object obj = new Object();
	synchronized void add(int m){//同步函数把函数带上同步功能.代替同步快
//		synchronized (obj) {
			money = money + m;
			try {Thread.sleep(10);} catch (InterruptedException e) {e.printStackTrace();}
			System.out.println(money);
//		}
	}
}
class Cus implements Runnable{
	Bank b = new Bank();
	public void run() {
		for(int i = 0; i < 3; i++){
			b.add(100);
		}
	}
	
}
public class BankDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cus c = new Cus();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}

}
