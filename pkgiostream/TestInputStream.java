package pkgiostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class TestInputStream {
	private static void read(){
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("./src/pkgiostream/files/read.txt");
			//实际读入的字节 值
			int read = fileInputStream.read();
			while(read != -1){//read = -1表示读到文件尾部
				System.out.println(read + ":" + (char)read);
				//一直读到文件尾部
				read = fileInputStream.read();
			//read.txt中有汉字时读取到后面出乱码
//			byte[] bytes = new byte[6];
//			//实际读入的字节个数 放入数组中
//			int read = fileInputStream.read(bytes);
//			while(read != -1){
//				System.out.println(read + ":" + Arrays.toString(bytes));
////				//一直读到文件尾部
//				read = fileInputStream.read(bytes);
			}
		} catch (FileNotFoundException e) {//文件未找到异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {//读取异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				fileInputStream.close();//最后关闭流
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	private static void copy(){
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileInputStream = new FileInputStream("./src/pkgiostream/files/read.txt");
			fileOutputStream = new FileOutputStream("./src/pkgiostream/copy/copy.txt");
			byte[] bytes = new byte[6];
			//para1 读取的字节保存入bytes数组 para2 起始位置 para3 读取的长度(小于等于数组长度)
			int read = fileInputStream.read(bytes, 0, bytes.length);
			while(read != -1){
				System.out.println(read + ":" + Arrays.toString(bytes));
				//数组里的字节 起始位置 一次输出的个数(要用实际读入的个数read,而不能用数组长度)
//				fileOutputStream.write(bytes, 0, bytes.length);
				fileOutputStream.write(bytes, 0, read);
				read = fileInputStream.read(bytes, 0, bytes.length);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fileOutputStream.flush();
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		read();
		copy();
	}

}
