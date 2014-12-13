package pkgmytimeui;

import java.awt.Dimension;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.crypto.Data;

class TimeLabel {
	// JLabel labely1 = new JLabel("0");
	// JLabel labely2 = new JLabel("0");
	// JLabel labely3 = new JLabel("0");
	// JLabel labely4 = new JLabel("0");
	// JLabel labelM1 = new JLabel("0");
	// JLabel labelM2 = new JLabel("0");
	// JLabel labeld1 = new JLabel("0");
	// JLabel labeld2 = new JLabel("0");
	//
	// JLabel labelh1 = new JLabel("0");
	// JLabel labelh2 = new JLabel("0");
	// JLabel labelm1 = new JLabel("0");
	// JLabel labelm2 = new JLabel("0");
	// JLabel labels1 = new JLabel("0");
	// JLabel labels2 = new JLabel("0");
	static JLabel[] labels = new JLabel[14];

	public TimeLabel() {
		for (int i = 0; i < 14; i++) {
			labels[i] = new JLabel();
		}
	}

	static JLabel labelyear1 = new JLabel();
	static JLabel labelyear2 = new JLabel();
	static JLabel labeltime1 = new JLabel(":");
	static JLabel labeltime2 = new JLabel(":");
}

class TimeIcons {
	ImageIcon[] icons = new ImageIcon[10];

	TimeIcons() {
		for (int i = 0; i <= 9; i++) {
			icons[i] = new ImageIcon(MyTimeUI.class.getResource("image/d" + i + ".gif"));
		}
	}

	public ImageIcon getIcon(int i) {
		return icons[i];
	}
}

public class MyTimeUI extends JFrame {
	static TimeLabel label = new TimeLabel();
	static TimeIcons icons = new TimeIcons();

	static Lock lock = new ReentrantLock();
	static Condition con_Min = lock.newCondition();
	static Condition con_Hor = lock.newCondition();
	static Condition con_Day = lock.newCondition();
	static Condition con_Mon = lock.newCondition();
	static Condition con_Yer = lock.newCondition();

	static boolean flag = false;

	public MyTimeUI() {
		init();
		this.setTitle("俺の時間");
		this.setSize(new Dimension(300, 130));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}

	private void init() {
		JPanel panel = new JPanel();

		Box box = Box.createHorizontalBox();
		// box.add(timeLabel.labely1);
		// box.add(timeLabel.labely2);
		// box.add(timeLabel.labely3);
		// box.add(timeLabel.labely4);
		// box.add(timeLabel.labelyear1);
		// box.add(timeLabel.labelM1);
		// box.add(timeLabel.labelM2);
		// box.add(timeLabel.labelyear2);
		// box.add(timeLabel.labeld1);
		// box.add(timeLabel.labeld2);
		// box.add(Box.createHorizontalStrut(20));
		// box.add(timeLabel.labelh1);
		// box.add(timeLabel.labelh2);
		// box.add(timeLabel.labeltime1);
		// box.add(timeLabel.labelm1);
		// box.add(timeLabel.labelm2);
		// box.add(timeLabel.labeltime2);
		// box.add(timeLabel.labels1);
		// box.add(timeLabel.labels2);

		for (int i = 0; i < 14; i++) {
			box.add(TimeLabel.labels[i]);
			if (i == 3) {
				TimeLabel.labelyear1.setIcon(new ImageIcon(
						MyTimeUI.class.getResource("image/d10.gif")));
				box.add(TimeLabel.labelyear1);
			}
			if (i == 5) {
				TimeLabel.labelyear2.setIcon(new ImageIcon(
						MyTimeUI.class.getResource("image/d10.gif")));
				box.add(TimeLabel.labelyear2);
			}
			if (i == 7) {
				box.add(Box.createHorizontalStrut(20));
			}
			if (i == 9) {
				box.add(TimeLabel.labeltime1);
			}
			if (i == 11) {
				box.add(TimeLabel.labeltime2);
			}
		}
		panel.add(box);
		this.add(panel);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 14; i++) {
			TimeLabel.labels[i].setIcon(icons.getIcon(0));
		}
		new MyTimeUI();
		runTimeSecond second = new runTimeSecond();
		runTimeMinute minute = new runTimeMinute();
		runTimeHour hour = new runTimeHour();
		runTimeDay day = new runTimeDay();
		runTimeMonth month = new runTimeMonth();
		runTimeYear year = new runTimeYear();
		new Thread(second).start();
		new Thread(minute).start();
		new Thread(hour).start();
		new Thread(day).start();
		new Thread(month).start();
		new Thread(year).start();
		System.out.println(Thread.currentThread().getName());
//		new Thread(new runTime()).start();
	}

}
//class runTime implements Runnable{
//	@Override
//	public void run() {
//		System.out.println(Thread.currentThread().getName());
//		do {
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			Calendar c = Calendar.getInstance();
//			int second = c.get(Calendar.SECOND);
//			int shiWei = second / 10 % 10;
//			int geWei = second % 10;
//			MyTimeUI.label.labels[12].setIcon(MyTimeUI.icons.getIcon(shiWei));
//			MyTimeUI.label.labels[13].setIcon(MyTimeUI.icons.getIcon(geWei));
//			if(shiWei == 0 && geWei ==0){
//				setTime(c.get(Calendar.MINUTE), 10, 11);				
//				setTime(c.get(Calendar.HOUR_OF_DAY), 8, 9);			
//				setTime(c.get(Calendar.DAY_OF_MONTH), 6, 7);			
//				setTime(c.get(Calendar.MONTH), 4, 5);	
//			}
//		} 
//	}
//	private void setTime(int time,int p1,int p2){
//		int shiWei = time / 10 % 10;
//		int geWei = time % 10;
//		MyTimeUI.label.labels[p1].setIcon(MyTimeUI.icons.getIcon(shiWei));
//		MyTimeUI.label.labels[p2].setIcon(MyTimeUI.icons.getIcon(geWei));
//	}
//}

class runTimeSecond implements Runnable {
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Calendar c = Calendar.getInstance();
			int second = c.get(Calendar.SECOND);
			int shiWei = second / 10 % 10;
			int geWei = second % 10;
			MyTimeUI.label.labels[12].setIcon(MyTimeUI.icons.getIcon(shiWei));
			MyTimeUI.label.labels[13].setIcon(MyTimeUI.icons.getIcon(geWei));
		}
	}
}

class runTimeMinute implements Runnable {
	@Override
	public void run() {
		while (true) {
			Calendar c = Calendar.getInstance();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int minute = c.get(Calendar.MINUTE);
			int shiWei = minute / 10 % 10;
			int geWei = minute % 10;
			MyTimeUI.label.labels[10].setIcon(MyTimeUI.icons.getIcon(shiWei));
			MyTimeUI.label.labels[11].setIcon(MyTimeUI.icons.getIcon(geWei));
		}
	}
}

class runTimeHour implements Runnable {
	@Override
	public void run() {
		while (true) {
			Calendar c = Calendar.getInstance();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int shiWei = hour / 10 % 10;
			int geWei = hour % 10;
			MyTimeUI.label.labels[8].setIcon(MyTimeUI.icons.getIcon(shiWei));
			MyTimeUI.label.labels[9].setIcon(MyTimeUI.icons.getIcon(geWei));
		}
	}
}

class runTimeDay implements Runnable {
	@Override
	public void run() {
		while (true) {
			Calendar c = Calendar.getInstance();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int day = c.get(Calendar.DAY_OF_MONTH);
			int shiWei = day / 10 % 10;
			int geWei = day % 10;
			MyTimeUI.label.labels[6].setIcon(MyTimeUI.icons.getIcon(shiWei));
			MyTimeUI.label.labels[7].setIcon(MyTimeUI.icons.getIcon(geWei));
		}
	}
}

class runTimeMonth implements Runnable {
	@Override
	public void run() {
		while (true) {
			Calendar c = Calendar.getInstance();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int month = c.get(Calendar.MONTH) + 1;
			int shiWei = month / 10 % 10;
			int geWei = month % 10;
			MyTimeUI.label.labels[4].setIcon(MyTimeUI.icons.getIcon(shiWei));
			MyTimeUI.label.labels[5].setIcon(MyTimeUI.icons.getIcon(geWei));
		}
	}
}

class runTimeYear implements Runnable {
	@Override
	public void run() {
		while (true) {
			Calendar c = Calendar.getInstance();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int year = c.get(Calendar.YEAR);
			int baiWei = year / 1000 % 10;
			int qianWei = year / 100 % 10;
			int shiWei = year / 10 % 10;
			int geWei = year % 10;
			MyTimeUI.label.labels[0].setIcon(MyTimeUI.icons.getIcon(baiWei));
			MyTimeUI.label.labels[1].setIcon(MyTimeUI.icons.getIcon(qianWei));
			MyTimeUI.label.labels[2].setIcon(MyTimeUI.icons.getIcon(shiWei));
			MyTimeUI.label.labels[3].setIcon(MyTimeUI.icons.getIcon(geWei));
		}
	}
}
