package pkgsystemclass;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CurrentTimeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		//程序段
		//日期转化为指定字符串
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(date);
		System.out.println(str);
		//指定字符串转化为日期
		String str2 = "2009-10-24 08:50:50";
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date2 = sdf2.parse(str2,new ParsePosition(0));
		long end = System.currentTimeMillis();
		long diff = end - start;//程序段执行所用时间
		System.out.println(diff);
	}

}
