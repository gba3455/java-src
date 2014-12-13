package pkgio;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * DataInputStream DataOutputStream
 * 可以用于操作基本数据类型的流对象 
 */
public class DataStreamDemo {
	public static void main(String[] args) throws IOException {
//		writeData();
//		readData();
//		writeUTF8();
//		readUTF8();
//		writeUTF8_2();
		readUTF8_2();
	}
	public static void readUTF8() throws IOException{
		DataInputStream dis = new DataInputStream(new FileInputStream("/users/sqzs/desktop/data.txt"));
		System.out.println(dis.readUTF());
	}
	public static void readUTF8_2() throws IOException{
		InputStreamReader isr = new InputStreamReader(new FileInputStream("/users/sqzs/desktop/data.txt"),"UTF-8");
		BufferedReader bufr = new BufferedReader(isr);
		System.out.println(bufr.readLine());
	}
	public static void writeUTF8() throws IOException{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("/users/sqzs/desktop/data.txt"));
		
		dos.writeUTF("你好");
		dos.close();
	}
	public static void writeUTF8_2() throws IOException{
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("/users/sqzs/desktop/data.txt"), "UTF-8");
		
		osw.write("你好");
		osw.close();
	}
	public static void readData() throws IOException{
		DataInputStream dis = new DataInputStream(new FileInputStream("/users/sqzs/desktop/data.txt"));
		System.out.println(dis.readInt() +""+ dis.readBoolean() +""+ dis.readDouble());
	}
	public static void writeData() throws IOException{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("/users/sqzs/desktop/data.txt"));
		
		dos.writeInt(2349);
		dos.writeBoolean(true);
		dos.writeDouble(432.34);
	}
}
