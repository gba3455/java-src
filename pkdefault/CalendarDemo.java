package pkdefault;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class CalendarDemo {

	private static void Demo1(Calendar c){
		Date d = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		
		System.out.println(sdf.format(d));
		String[] mons = {"一月","二月","三月","四月"
				,"五月","六月","七月","八日"
				,"九月","十月","十一月","十二月"};
		String[] weeks = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		Calendar c1 = Calendar.getInstance();
		int month = c.get(Calendar.MONTH);
		int week = c.get(Calendar.DAY_OF_WEEK);
		int year = c.get(Calendar.YEAR);
		System.out.println(year);
		
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(mons[month]);
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		System.out.println(weeks[week]);
	}
	private static void Demo2(){
		Calendar c = Calendar.getInstance();
//		c.set(2014,2,19);
		c.add(Calendar.MONTH, -4);
		Demo1(c);
	}
	public static void main(String[] args) {
		Demo2();
	}

}
