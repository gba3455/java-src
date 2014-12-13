package pkgio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {

	public static void main(String[] args) {
		//创建一个读取流对象和文件相关联
		FileReader fr = null;
		//为了提高效率,加入缓冲技术,将字符读取流对象作为参数传递给缓存对象的构造函数.
		BufferedReader bufr = null;
		try {
			fr = new FileReader("./src/Test.java");
			bufr = new BufferedReader(fr);
			String line = null;
			while((line = bufr.readLine()) != null){
				System.out.println(line);
			}
//			char[] buf = new char[1024];
//			int len = 0;
//			while((len = fr.read(buf)) != -1){
//				System.out.println(new String(buf,0,len));
//			}
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
		}
	}

}
