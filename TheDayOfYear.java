
public class TheDayOfYear {
	public static void theDayOfYear(int year,int month,int day){
		int sum = 0;
		if(month > 0){
			sum += day;
		}
		if(month > 1){
			sum += 31;
		}
		if(month > 2){
			if(runNian(year)){
				sum += 29;
			}
			else{
				sum += 28;
			}
		}
		if(month > 3){
			sum += 31;
		}
		if(month > 4){
			sum += 30;
		}
		if(month > 5){
			sum += 31;
		}
		if(month > 6){
			sum += 30;
		}
		if(month > 7){
			sum += 31;
		}
		if(month > 8){
			sum += 31;
		}
		if(month > 9){
			sum += 30;
		}
		if(month > 10){
			sum += 31;
		}
		if(month > 11){
			sum += 30;
		}
		System.out.println(sum);
	}
	public static boolean runNian(int year){
		if(year % 100 == 0){
			if((year / 100) % 4 == 0){
				return true;
			}
		}else if(year % 4 == 0){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		theDayOfYear(2009,12,31);
	}

}
