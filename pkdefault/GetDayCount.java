package pkdefault;
import java.util.Calendar;

public class GetDayCount {
	public GetDayCount() {
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar1.set(2014, 3, 21);
		calendar2.set(2014, 06, 24);
		long milliseconds1 = calendar1.getTimeInMillis();
		long milliseconds2 = calendar2.getTimeInMillis();
		long diff = milliseconds2 - milliseconds1;
		long diffSeconds = diff / 1000;
		long diffMinutes = diff / (60 * 1000);
		long diffHours = diff / (60 * 60 * 1000);
		long diffDays = diff / (24 * 60 * 60 * 1000);
		System.out.println("\nThe Date Different Example");
		System.out.println("Time in milliseconds: " + diff + " milliseconds.");
		System.out.println("Time in seconds: " + diffSeconds + " seconds.");
		System.out.println("Time in minutes: " + diffMinutes + " minutes.");
		System.out.println("Time in hours: " + diffHours + " hours.");
		System.out.println("Time in days: " + diffDays + " days.");
	}
}
