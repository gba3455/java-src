import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ShuZi2DaXieShuZi {

public static void main(String[] args) {
		
//		new Test();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = bufferedReader.readLine();
			getNum(str);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void getNum(String str){
		String[] temp = new String[]{"零","壹","贰","叁","肆","伍","陆","柒","捌","玖","十"};
		for (int i = 0; i < str.length(); i++) {
			int j = Integer.parseInt(str.substring(i, i + 1));
			printOut(temp[j]);
		}
	}
	private static void printOut(Object obj){
		System.out.print(obj);
	}
}