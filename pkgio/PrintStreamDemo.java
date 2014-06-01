package pkgio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * 打印流:
 * 该流提供了打印方法,可以将各种数据类型的数据都原样打印出去,javaEE里输出到浏览器就要用数据原样输出
 * 
 * 字节打印流:
 * PrintStream
 * 构造函数可以接受的参数类型:
 * 1:file对象 File
 * 2:字符串路径 String
 * 3:字节输出流 OutputStream
 * 
 * 字符打印流
 * PrintWriter
 * 1:file对象 File
 * 2:字符串路径 String
 * 3:字节输出流 OutputStream
 * 4:字符输出流 Writer
 */
public class PrintStreamDemo {
	public static void main(String[] args) throws IOException {
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter pw = new PrintWriter(System.out);
		PrintWriter pw = new PrintWriter(System.out,true);
//		PrintWriter out = new PrintWriter("PrintWriter.txt");
//		PrintWriter out = new PrintWriter(new FileWriter("PrintWriter.txt"),true);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("PrintWriter.txt")),true);
		String str = null;
		while((str = bufr.readLine()) != null){
//			pw.write(str.toUpperCase());
			pw.println(str.toUpperCase());
//			pw.flush();
		}
		pw.close();
		try {
			bufr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
