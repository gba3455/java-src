package pkgio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.SequenceInputStream;
import java.util.Vector;
import java.util.Enumeration;
//多个流合并成一个流
public class SequenceInputStreamDemo {
	public static void main(String[] args) {
		Vector<FileInputStream> vec = new Vector<FileInputStream>();
		try {
			vec.add(new FileInputStream("/users/sqzs/desktop/1.txt"));
			vec.add(new FileInputStream("/users/sqzs/desktop/2.txt"));
			vec.add(new FileInputStream("/users/sqzs/desktop/3.txt"));
			Enumeration<FileInputStream> e = vec.elements();
			SequenceInputStream sis = new SequenceInputStream(e);
			
			FileOutputStream fos = new FileOutputStream("/users/sqzs/desktop/4.txt");
			BufferedReader bufr = new BufferedReader(new InputStreamReader(sis));
			BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(fos));
			PrintWriter pw = new PrintWriter(fos,true);
			String str = null;
			while((str = bufr.readLine()) != null){
				pw.println(str);
			}
//			while((str = bufr.readLine()) != null){
//				bufw.write(str);
//				bufw.flush();
//				bufw.newLine();
//			}
//			byte[] buf = new byte[1024];
//			int len = 0;
//			while((len = sis.read(buf)) != -1){
//				fos.write(buf, 0, len);
//			}
			
			sis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
