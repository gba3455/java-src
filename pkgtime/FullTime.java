package pkgtime;
public class FullTime {
	private MyTime myTime = null;
	private MyDate myDate = null;
	public MyTime getMyTime() {
		return myTime;
	}
	public void setMyTime(MyTime myTime) {
		this.myTime = myTime;
	}
	public MyDate getMyDate() {
		return myDate;
	}
	public void setMyDate(MyDate myDate) {
		this.myDate = myDate;
	}
	public FullTime(MyTime myTime, MyDate myDate) {
		super();
		this.myTime = myTime;
		this.myDate = myDate;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return myDate + "" + myTime;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTime myTime = new MyTime(14,17,35);
		MyDate myDate = new MyDate(2007,10,2);
		FullTime fullTime = new FullTime(myTime,myDate);
		System.out.println(fullTime);
	}

}
