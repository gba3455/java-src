package pkgtime2;


public class FullTime {
	private MyTime time;
	private MyDate date;
	void setMyTime(MyTime mt){
		time = mt;
	}
	MyTime getMyTime(){
		return time;
	}
	void setMyDate(MyDate md){
		date = md;
	}
	MyDate getMyDate(){
		return date;
	}
	public String toString(){
		MyTime mt = new MyTime();
		MyDate md = new MyDate();
		FullTime ft = new FullTime();
		md.setYear(2007);
		md.setMonth(10);
		md.setDay(2);
		mt.setHour(14);
		mt.setMinute(17);
		mt.setSecond(35);
		ft.setMyTime(mt);
		ft.setMyDate(md);
		return "overrided class of fulltime's toString method \n"
				+ "the time is " 
						+ ft.getMyDate().getYear() + "年"
						+ ft.getMyDate().getMonth() + "月"
						+ ft.getMyDate().getDay() + "日"
						+ ft.getMyTime().getHour() + "时"
						+ ft.getMyTime().getMinute() + "分"
						+ ft.getMyTime().getSecond() +  "秒";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
