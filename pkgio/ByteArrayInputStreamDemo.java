package pkgio;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

/*
 * 用于操作字节数组的流对象
 * ByteArrayINputstream在购置的时候需要接受数据源,而且数据源是一个字节数组.
 * ByteArrayOutputStream在购置的时候不用定义数据目的,因为该对象中已经内部封装了可变长度的字节数据
 * 这就是数据目的地
 * 
 * 因为这2个流对象都操作的数组,并没有使用系统资源.
 * 所以不用进行close关闭.
 * 
 * 在流操作规律讲解时:
 * 
 * 源设备:
 * 	键盘System.in,硬盘FileStream,内存ArrayStream.
 * 目的设备:
 * 	控制台System.out,硬盘FileStream,内存ArrayStream.
 * 
 * 用流的读写思想来操作数组.
 */
public class ByteArrayInputStreamDemo {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//数据源
		ByteArrayInputStream bis = new ByteArrayInputStream("ABCDEFG".getBytes());
		
		//数据目的
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		int by = 0;
		
		while((by = bis.read()) != -1){
			bos.write(by);
		}
		
		System.out.println(bos.size());
		System.out.println(bos.toString());
		
		bos.writeTo(new FileOutputStream("/users/sqzs/desktop/array.txt"));
	}
}
