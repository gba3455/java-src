package pkgutil;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @作者 Goofy
 * @邮件 252878950@qq.com
 * @日期 2014-1-25
 * @描述 文件压缩
 */
public class FileZip {
	
	
	/**
	 * 压缩目录，注意，中文乱码，目录中不能有嵌套的目录,将不会被压缩到压缩文件中
	 * @param dir 目录
	 * @param dest 目标压缩文件.zip
	 * @throws Exception
	 */
	public static void zip(String dir,String dest) throws Exception{
		
		File directory=new File(dir);
		if(!directory.isDirectory())throw new Exception("\""+dir+"\"不是一个目录");
		
		File destination=new File(dest);
		OutputStream os=new FileOutputStream(destination);
		BufferedOutputStream bos=new BufferedOutputStream(os);
		ZipOutputStream zos=new ZipOutputStream(bos);
		
		File[] files=directory.listFiles(); 
		
		InputStream is=null;
		byte[] buffer=new byte[1024];
		int length=0;
		
		for(File file:files){
			if(file.isDirectory())continue;
			is=new FileInputStream(file);
			zos.putNextEntry(new ZipEntry(file.getName()));
			while ((length=is.read(buffer))!=-1) {
				zos.write(buffer, 0, length);
			}
		}
		zos.closeEntry();
		zos.close();
	}
	
	/**
	 * 压缩一个或者多个文件
	 * @param dest 目标压缩文件.zip
	 * @param src 单个文件路径字符串或者文件路径字符串数组
	 * @throws Exception
	 */
	public static void zip(String dest,String... src) throws Exception{
		
		File destination=new File(dest);
		OutputStream os=new FileOutputStream(destination);
		BufferedOutputStream bos=new BufferedOutputStream(os);
		ZipOutputStream zos=new ZipOutputStream(bos);
		
		InputStream is=null;
		byte[] buffer=new byte[1024];
		int length=0;
		File file=null;
		
		for(String s:src){
			file=new File(s);
			is=new FileInputStream(file);
			zos.putNextEntry(new ZipEntry(file.getName()));
			while ((length=is.read(buffer))!=-1) {
				zos.write(buffer, 0, length);
			}
		}
		zos.closeEntry();
		zos.close();
	}

}
