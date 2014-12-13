package pkgiostream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字节流和字符流的转换
 * @author SQZS
 *
 */
public class TestInputStreamReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStreamReader inputStreamReader = null;
		inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = null;
		bufferedReader = new BufferedReader(inputStreamReader);
		try {
			System.out.println(bufferedReader.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				inputStreamReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
