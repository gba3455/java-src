package pkgutil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * @作者 Goofy
 * @邮件 252878950@qq.com
 * @日期 2014-1-25
 * @描述 文件操作工具类    拷贝|删除|写入|读取
 */
public class FileUtil {
	
	
	/**
	 * 拷贝文件
	 * @param src 源文件
	 * @param dest 目标文件
	 * @param bufferSize 每次读取的字节数
	 * @throws IOException
	 */
	public static void copy(String src,String dest,int bufferSize) throws IOException{
		
		FileInputStream fis=new FileInputStream(src);
		FileOutputStream fos=new FileOutputStream(dest);
		byte[] buffer=new byte[bufferSize];
		int length;
		
		while((length=fis.read(buffer))!=-1){
			fos.write(buffer, 0, length);
		}
		fis.close();
		fos.close();
	}
	
	/**
	 * 删除文件
	 * @param src 源文件
	 */
	public static void deleteFile(String src){
		new File(src).delete();
	}
	
	/**
	 * 删除多个文件
	 * @param src 源文件数组
	 */
	public static void deleteFiles(String... src){
		for(String s:src){
			FileUtil.deleteFile(s);
		}
	}
	
	/**
	 * 根据路径删除文件
	 * @param dir 目录
	 * @throws Exception
	 */
	public static void deleteByDir(String dir) throws Exception{
		File d=new File(dir);
		if(!d.isDirectory())throw new Exception("\""+dir+"\""+"不是一个目录");
		String []fileNameArray=d.list();
		FileUtil.deleteFiles(fileNameArray);
	}
	
	/**
	 * 将内容写入文件
	 * @param content 写入的内容
	 * @param dest 写入的文件
	 * @param append 是否追加
	 * @param newLine 是否换行
	 * @throws IOException
	 */
	public static void writeToFile(String content,String dest,boolean append,boolean newLine) throws IOException{
		FileWriter writer=new FileWriter(dest, append);
		for(int i=0;i<100;i++){
			writer.write(content+(newLine==true?System.getProperty("line.separator"):""));
		}
		writer.close();
	}
	
	/**
	 * 获取文件内容
	 * @param src 源文件
	 * @return String[] 文件内容数组，每行占一个数组空间
	 * @throws IOException
	 */
	public static String[] readContent(String src) throws IOException{
		FileReader reader=new FileReader(src);
		BufferedReader br=new BufferedReader(reader);
		String []array=new String[FileUtil.readLineNumber(src)];
		String line;
		int lineNumber=0;
		while((line=br.readLine())!=null){
			array[lineNumber]=line;
			lineNumber++;
		}
		return array;
	}
	
	/**
	 * 获取文件行数
	 * @param src 源文件
	 * @return int 内容行数
	 * @throws IOException
	 */
	public static int readLineNumber(String src) throws IOException{
		FileReader reader=new FileReader(src);
		BufferedReader br=new BufferedReader(reader);
		int lineNumber=0;
		while(br.readLine()!=null){
			lineNumber++;
		}
		return lineNumber;
	}
	
	/**
	 * 获取目录下的文件和文件夹列表
	 * @param dir 源目录
	 * @return LinkedHashMap<String,Boolean> true表示目录
	 * @throws Exception
	 */
	public static LinkedHashMap<String,Boolean> readDir(String dir) throws Exception{
		File d=new File(dir);
		
		if(!d.isDirectory())throw new Exception("\""+dir+"\""+"不是一个目录");
		
		String[] array=d.list();
		if(array==null)return null;
		
		LinkedHashMap<String, Boolean> map=new LinkedHashMap<String, Boolean>();
		for (int i = 0; i < array.length; i++) {
			map.put(array[i], new File(dir+File.separatorChar+array[i]).isDirectory()==true?true:false);
		}
		return map;
	}
}
