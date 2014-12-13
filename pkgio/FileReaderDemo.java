package pkgio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) {
		//创建一个文件读取流对象,和指定名称的文件相关联.
		//要保证该文件是已经存在的,如果不存在,会发生异常.FileNotFoundException
		FileReader fr = null;
		try {
			fr = new FileReader("pkgiodemo.txt");
			//调用读取流的read方法
			//read():一次读一个字符.而且会自动往下读.
			try {
				//第一种
//				int ch = fr.read();
//				System.out.println((char)ch);
//				int ch = 0;
//				while((ch = fr.read()) != -1){
//					System.out.print((char)ch);
//				}
				
				//第二种:通过字符数组进行读取
				//定义一个字符串,用于存储读到的字符.
				//该read(char[])返回的是读到字符个数.
				char[] buf = new char[1024];
				int len = 0;
				while((len = fr.read(buf)) != -1){
					System.out.println(new String(buf,0,len));
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
