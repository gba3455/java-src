package pkgtime;
public class MyTime {
	private int hour,minute,second;
//	右键Source-》Generate Constructor using Field自动创建带参数的构造方法
	public MyTime(int hour, int minute, int second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public void setHour(int hour){
		this.hour = hour;
	}
	public int getHour(){
		return hour;
	}
	public void setMinute(int minute){
		this.minute = minute; 
	}
	public int getMinute(){
		return minute;
	}
	public void setSecond(int second){
		this.second = second;
	}
	public int getSecond(){
		return second;
	}
	public String toString(){
		// TODO Auto-generated method stub
		//默认会被打印函数调用
//		System.out.println("fda");
//		return super.toString();
		return this.hour + "时"
			+ this.minute+ "分"
			+ this.second+ "秒";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTime myTime = new MyTime(19,0,0);
//		当我们输出一个对象的时候，默认会调用toString方法
		System.out.println(myTime);//等同
		System.out.println(myTime.toString());

	}

}
