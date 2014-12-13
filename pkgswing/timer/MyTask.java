package pkgswing.timer;

import javax.management.timer.Timer;


public class MyTask extends java.util.TimerTask{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("--------------");
	}
	MyTask myTask = new MyTask();
	Timer timer = new Timer();
//	timer.schedule(myTask,1000,1000);
	
}
