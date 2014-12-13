package pkgshoppingcar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
	public static String getDate(int type){
		SimpleDateFormat dateFormat;
		switch (type) {
		case 1:
			dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			break;

		default:
			dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			break;
		}
		return dateFormat.format(new Date());
	}
}
