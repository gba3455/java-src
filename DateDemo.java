import java.text.SimpleDateFormat;
import java.util.Date;


public class DateDemo {

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);//打印的时间看不懂,希望有些格式.
		//将模式封装到Simpledateformart对象中.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-E a:HH:mm:ss");
		//调用format方法让模式格式化指定Date对象
		String str = sdf.format(d);
		System.out.println(str);
	}

}
