package pkgregex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSkypeTime {

	public static void main(String[] args) throws IOException {
		int count = 0;
		int sum = 0;
		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				new FileInputStream("/users/sqzs/desktop/newtel.txt")));
		ArrayList<String> list = new ArrayList<String>();
		String str = null;
		while ((str = bufr.readLine()) != null) {
			list.add(regexCut(str, ";\\d{2}:\\d{2}:\\d{2};"));
		}
		for (String string : list) {
			count++;
			String[] strArr = splitTime(string);
			System.out.println(strArr[0] + ":" + strArr[1] + ":" + strArr[2]);
			sum += getSum(strArr);
		}
		System.out.println(sum);
		Min2Format(sum);
		bufr.close();
	}
	
	private static void Min2Format(int min){
		SimpleDateFormat sif = new SimpleDateFormat("HH:mm:ss");
		System.out.println(sif.format(min * 1000));
	}

	private static int getSum(String[] Arr) {
		return Integer.parseInt(Arr[0]) * 60 + Integer.parseInt(Arr[1]) * 60
				+ Integer.parseInt(Arr[2]);
	}

	private static String[] splitTime(String str) {
		str = str.substring(1, str.length() - 1);
		String[] temp = str.split(":");
		return temp;
	}

	private static String regexCut(String str, String regex) {
		// 用正则
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		String temp = null;
		while (m.find()) {
			temp = m.group();
		}
		return temp;
	}

}
