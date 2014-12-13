package pkgio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * 该类不算是IO体系中的子类.
 * 而是直接继承自Object
 * 但是他是IO包中成员.因为他具备读和写功能
 * 内部封装了一个数组,而且通过指针对数组中的元素进行操作.
 * 可以通过getFilePointer获取指针位置,
 * 同时可以通过seek改变指针位置.
 * 
 * 其实完成读写的原理就是内部封装了字节输入流和输出流.
 * 通过构造函数可以看出,该类只能操作文件.
 * 而且操作文件还有模式. r rw
 * 如果模式为只读 r,不会创建文件.会去读取一个已存在的文件.如果改文件不存在,则会报异常.
 * 如果模式为rw,操作的文件不存在,会自动创建,如果存在会覆盖.
 */
public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		writeFile();
		readFile();
		System.out.println(Integer.toBinaryString(258));
	}
	public static void readFile() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("/users/sqzs/desktop/random.txt", "r");
		//调整对象中指针
		raf.seek(8 * 1);
		//跳过指定字节数//不能往回跳
//		raf.skipBytes(8);
		byte[] buf = new byte[4];
		raf.read(buf);
		String name = new String(buf);
		int age = raf.readInt();
		System.out.println(name + age);
		raf.close();
	}
	public static void writeFile_2() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("/users/sqzs/desktop/random.txt", "rw");
		raf.seek(8 * 0);
		raf.write("小名".getBytes());
		raf.writeInt(103);
	}
	public static void writeFile() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("/users/sqzs/desktop/random.txt", "rw");
		
		raf.write("李四".getBytes());
//		raf.write(97);
		raf.writeInt(97);
		raf.write("王五".getBytes());
//		raf.write(99);
		raf.writeInt(99);
	}
}
