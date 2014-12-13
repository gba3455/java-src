package pkgio;

import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

public class EncodeDemo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "联通";
		byte[] by = s.getBytes("gbk");
		for(byte b : by){
			System.out.println(Integer.toBinaryString(b & 255));//<<<<<
		}
	}
}
