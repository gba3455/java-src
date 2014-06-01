package pkgio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.imageio.stream.FileImageInputStream;

/*
 * 读取键盘录入
 * 通过键盘录入数据,当录入一行数据后,就将该行数据打印.
 * 如果录入的数据是over,那么停止录入.
 * 
 * 这个代码其实就是读一行数据ReadLine方法的原理.
 * 
 * 直接使用readLine方法来完成键盘录入的一行数据的读取?
 * readLine方法是字符流BufferedReader类中的方法.
 * 而键盘录入的read方法是字节流InputStream的方法.
 * 所以不能拿字节流去用字符流的方法.
 * 
 * 那么能不能将字节流转成字符流,再使用字符流缓冲区的readLine方法?
 * 
 * 通过三个明确我来完成
1明确源和目的
	源:输入流.InputStream Reader
	目的:输出的流:我OutputStream Writer
2操作的数据是否是纯文本
	是:字符流
	否:字节流
3,当体系明确后,再明确要使用哪个具体的对象
	通过设备来进行区分:
	源设备:内存,硬盘,键盘
	目的设备:内存,硬盘,控制台

1,将一个文本文件中数据储存到另一个文件中.复制文件
	源:因为是源:所以你使用读取流.InputStream Reader
	是不是操作文本文件
	是!这时就可以选择Reader
	这样体系就明确了
	
	接下来你明确要使用该体系中的那个对象
	明确设备:硬盘上的文件
	Reader体系中可以操作文本的对象是FileReader

	是否需要提高效率:是!加入Reader体系中缓冲区

	目:OutputStream Writer
	是否是纯文本的.
	是!Writer
	设备:硬盘,一个文件
	Writer体系中可以操作文件的对象FileWriter

	是否需要提高效率:是!加入Reader体系中缓冲区
	
	
	需求:将键盘录入的数据保存到一个文件中
这个需求总有源和目的都存在
那么分别分析
源:InputStream Reader
是不是纯文本?是!Reader

设备:键盘.对应的对象是System.in我
不是选择我Reader吗?System.in对应的不是字节流吗?
为了操作键盘的文本数据方便转成字符流按照字符串操作是最方便的
所以既然明确了Reader,那么就将System.in转换成(system.in)

需要提高效率吗?需要!BufferedReader

 */
public class ReadIn {
	public static void main(String[] args) throws IOException {
		readIn_3();
		readIn_4();
	}
	private static void readIn_1() throws IOException{
		InputStream in = System.in;
		
//		System.out.println(in.read());// a  97
//		System.out.println(in.read());// \r 13
//		System.out.println(in.read());// \n 10
		
		StringBuilder sb = new StringBuilder();
		while(true){
			int ch = in.read();
			if(ch == '\r'){
				continue;
			}
			if(ch == '\n'){
				//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
				String str = sb.toString();
				//↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
				if(str.equals("over")){
					break;
				}
				System.out.println(sb);
				sb.delete(0, sb.length());
			}else{
				sb.append((char)ch);
			}
		}
	}
	private static void readIn_2() throws IOException{

		InputStream in = System.in;
		
		//将字节流对象转换成字符流对象,使用装换流,InputStreamReader
		
		InputStreamReader isr = new InputStreamReader(in);
		
		//为了提高效率,将字符串进行缓冲区技术高效操作.使用BufferedReader
//		BufferedReader bufr = new BufferedReader(isr);
		
		//键盘录入的最常见写法.
//		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("/users/sqzs/desktop/pkgio_ReadIn_java_out.txt")));
		
		OutputStream out = System.out;
		
		OutputStreamWriter osw = new OutputStreamWriter(out);//没有newLine函数.需要再增强一下
		
//		BufferedWriter bufw = new BufferedWriter(osw);
		
		//转换流最开始的目的就是可以设置编码表.GBK UTF-8
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out,"GBK"));
		//输出到文本
//		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/users/sqzs/desktop/pkgio_ReadIn_java_out.txt")));

		String line = null;
		while((line = bufr.readLine()) != null){
			if(line.equals("over")){
				break;
			}
//			System.out.println(line.toUpperCase());
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
		bufr.close();
	}
	
	private static void readIn_3(){
		try {
			InputStream is = new FileInputStream("/users/sqzs/desktop/1.jpg");
			BufferedInputStream bufis = new BufferedInputStream(is);
			
			OutputStream ostxt = new FileOutputStream("/users/sqzs/desktop/1jpg.txt");
			OutputStreamWriter osw = new OutputStreamWriter(ostxt);
			BufferedWriter bufw = new BufferedWriter(osw);
			int len = 0;
			while ((len = bufis.read()) != -1) {
				bufw.write(len);
				bufw.flush();
			}
			bufis.close();
			bufw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void readIn_4(){
		try {
			InputStream is = new FileInputStream("/users/sqzs/desktop/1jpg.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			OutputStream out = new FileOutputStream("/users/sqzs/desktop/out.jpg");
			BufferedOutputStream bufos = new BufferedOutputStream(out);
			int len = 0;
			while((len = br.read()) != -1){
				bufos.write(len);
				bufos.flush();
			}
			bufos.close();
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
