package pkgio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTextByBuf {

	public static void main(String[] args) {
		BufferedReader bufr = null;
		BufferedWriter bufw = null;
		try {
			bufr = new BufferedReader(new FileReader("./src/Test.java"));
			bufw = new BufferedWriter(new FileWriter("/users/sqzs/desktop/test.txt"));
			String line = null;
			while((line = bufr.readLine()) != null){//返回一行内容,只返回回车符之前的数据内容.不包含终止符
				bufw.write(line);
				bufw.newLine();//不包含终止符,所以要换行.
				bufw.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bufr != null){
				try {
					bufr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bufw != null){
				try {
					bufw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
