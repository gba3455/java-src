package pkgiostream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestReader {
	private static void out() {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("./src/pkgiostream/reader/filereader.txt");
			//第二个参数true 表示是否追加
//			fileWriter = new FileWriter("./src/pkgiostream/reader/filereader.txt",true);
			fileWriter.write("可以输出中文");
			char[] chars = new char[]{'字','符','数','组'};
			fileWriter.write(chars);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static void read() {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("./src/pkgiostream/reader/filereader.txt");
			int read = fileReader.read();//字符的unicode值
			while(read != -1){
				System.out.println(read + "->" + (char)read);
				read = fileReader.read();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fileReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
//		out();
		read();
	}

}
