package pkgtime2;


public class MyDate {
	private int year;
	private int month;
	private int day;
	int getYear() {
		return year;
	}
	void setYear(int y) {
		year = y;
	}
	int getMonth() {
		return month;
	}
	void setMonth(int m) {
		month = m;
	}
	int getDay() {
		return day;
	}
	void setDay(int d) {
		day = d;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "日"; 
	}
	public static void main(String[] args) {
	}
}
