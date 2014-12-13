package pkgio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
/*
 * 带行号的装饰类.又增强了一点.
 */
public class LineNumberReaderDemo {
	public static void main(String[] args) {
		FileReader fr = null;
		LineNumberReader lnr = null;
		try {
			fr = new FileReader("./src/Test.java");
			lnr = new LineNumberReader(fr);
			
			String line = null;
			lnr.setLineNumber(100);
			while((line = lnr.readLine()) != null){
				System.out.println(lnr.getLineNumber() + ":" + line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(lnr != null){
				try {
					lnr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
