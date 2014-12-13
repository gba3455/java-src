package pkgio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyMp3 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
//		copy_1();
		copy_2();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	//通过字节流缓冲区完成复制
	private static void copy_1(){
		BufferedInputStream bufis = null;
		BufferedOutputStream bufos = null;
		try {
			bufis = new BufferedInputStream(new FileInputStream("/users/sqzs/desktop/1.mid"));
			bufos = new BufferedOutputStream(new FileOutputStream("/users/sqzs/desktop/new.mid"));
			
			int by = 0;
			while((by = bufis.read()) != -1){
				bufos.write(by);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bufis != null){
				try {
					bufis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bufos != null){
				try {
					bufos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//通过自定义字节流缓冲区完成复制(MyBufferedInputStream)
	private static void copy_2(){
		try {
			MyBufferedInputStream mbufis = new MyBufferedInputStream(new FileInputStream("/users/sqzs/desktop/1.mid"));
			BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("/users/sqzs/desktop/newmp3.mid"));
			
			int by = 0;
			while((by = mbufis.MyRead()) != -1){
				/*
				 * MyRead方法吧一个字节提升成int4个字节,那容量应该也要变成4倍.
				 * 是因为write方法只写1个字节出去,所以它只把最后8位1写出去,前面的0都砍掉了.
				 */
				bufos.write(by);
			}
			mbufis.MyClose();
			bufos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
