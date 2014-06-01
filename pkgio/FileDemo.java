package pkgio;
import java.io.*;
/*
 * File类:
 * 1:创建
 * 	boolean createNewFile();在指定位置创建文件,如果该文件
 * 已经存在,则不创建,返回false.和输出流不一样,输出流对象一创建,
 * 就会创建文件,再次创建就会覆盖文件.
 * 	boolean mkdir(); mkdirs();
 * 2:删除
 * 	boolean delete();删除失败返回false
 * 	void deleteOnExit();程序退出时删除指定文件.
 * 3:判断
 *  boolean canExecute();//可执行
 *  canRead() canWrite() CompareTo
 *  exists();//存在?
 *  isFile();
 *  isDirectory();
 *  isHidden();
 *  isAbsolute();
 * 4:获取信息
 * 	getName();
 * 	getPath();getParent();getAbsolutePath();
 *  long lastModified();
 *  length();
 */
public class FileDemo{
	public static void main(String[] args) throws IOException{
//		method4();
//		(new File("/users/sqzs/desktop/bc")).delete();
	}

	private static void method() throws IOException{
		//创建File对象
		//可将已有的和不存在的文件或文件夹封装成对象.
		File f1 = new File("a.txt");
		String s = File.separator;//跨平台分隔符
		sop(s);
		File f2 = new File(s + "users" + s + "sqzs" + s + "desktop" + s + "b.txt");
//		f2.deleteOnExit();//临时文件等.如果上面有代码运行到一半异常,下面的delete方法执行不到,这个文件就变成垃圾文件.所以要用这个方法在程序退出时删除垃圾
		File d = new File(s + "users" + s + "sqzs" + s + "desktop");
		File f3 = new File(d,"c.txt");
		sop(f1);
		sop(f2);
		sop(f3);
		sop("create:" + f2.createNewFile());
		sop("create:" + f2.createNewFile());
//		Sop("delete:" + f2.delete());
		sop("execute:" + f2.canExecute());
		sop("exists:" + f2.exists());
		
		//创建文件夹
		File dir = new File("/users/sqzs/desktop/abc");
		dir.mkdir();
		dir.delete();
		
	}
	private static void method2() throws IOException{
		File f = new File("file.txt");
//		f.deleteOnExit();
//		f.createNewFile();
		f.mkdir();//创建的文件夹名字是file.txt
		sop(f.isAbsolute());
		//在判断文件对象是否是文件或者目录的时候,必须要先判断文件对象封装的内容是否存在.
		//通过exists判断.
		sop("dir:" + f.isDirectory());
		sop("file:" + f.isFile());
	}
	private static void method3(){
		File f = new File("file.txt");
		sop("path:" + f.getPath());
		sop("abspath: " + f.getAbsolutePath());
		sop("parent:" + f.getParent());//null 返回的是绝对路径中的父目录
		//如果获取的是相对路径,返回null
		//如果相对路径中有上一层目录,那么改目录就是返回结果.
		
	}
	private static void method4(){
		File f1 = new File("/users/sqzs/desktop/bc/pkgio_ReadIn_java_out.txt");
		File f2 = new File("/users/sqzs/desktop/pkgio_ReadIn_java_out.txt");
		//renameTo不单单可以改名,还可以类似剪切并重命名的功能.
		sop("rename:" + f1.renameTo(f2));
	}
	private static void sop(Object obj){
		System.out.println(obj);
	}
}
