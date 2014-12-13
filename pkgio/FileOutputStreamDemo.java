package pkgio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 字符流:使用字符数组char[]
 * FileReader
 * FileWriter
 * 
 * BufferedReader
 * BufferedWriter
 * 
 * 字节流:使用字节数组byte[]
 * InputStream 
 * OutputStream
 * 
 * BufferedInputStream
 * BufferedOutputStream
 * 
 * 名字有Stream的都是字节流
 * 
 * 字符流其实一样走的字节,但是需要吧字节临时存起来.
 * 一个中文有2个字节,我读一个字节后不能立刻操作.因为只有半个中文.
 * 所以读完字节临时存起来以后,读表.查表找一个字符.
 * 字符流底层用的也是字节流的缓冲区,字符缓冲区里有个数组,临时存储数据的.
 * 所以字符流需要刷新动作.
 * 而如果直接使用字节流操作,没有使用具体指定的缓冲区的话,它不需要缓冲.
 * 我不管你是什么类型的数据,我都以字节来操作,我碰到一个字节就操作一次.
 * 所以可以直接吧字节都写到目的里去.所以不需要刷新.
 * 
 * 需求,想要操作图片数据,要用到字节流.
 */
public class FileOutputStreamDemo {
	public static void writeFile(){
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("/users/sqzs/desktop/fos.txt");
			fos.write("abcde\r\nced".getBytes());
//			fos.flush();//不需要刷新
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void readFile_1(){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("/users/sqzs/desktop/fos.txt");
			int ch = 0;
			while((ch = fis.read()) != -1){
				System.out.println((char)ch);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void readFile_2(){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("/users/sqzs/desktop/fos.txt");
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = fis.read(buf)) != -1){
				System.out.println(new String(buf,0,len));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void readFile_3(){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("/users/sqzs/desktop/fos.txt");
			int num = fis.available();//取得数据量大小.包括\r\n
			byte[] buf = new byte[fis.available()];//定义一个刚刚好的缓冲区,不用再循环了.
			//这个方法只能对于小文件,如果读取个几G的视频文件,一下创建几G大小的byte数组,内存受不了,会内存溢出.所以以1024为主.
			fis.read(buf);
			System.out.println(new String(buf));
			System.out.println(num);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		writeFile();
		readFile_1();
		readFile_2();
		readFile_3();
	}
}
