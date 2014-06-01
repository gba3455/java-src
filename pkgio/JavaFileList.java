package pkgio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

/*
 * 练习
 * 将一个指定目录下的java文件的絶對路径,存储到一个文本文件中.
 * 简历一个java文件列表
 * 
 * 思路:
 * 1:对指定的目录进行递归
 * 2:获取递归过程中所有的java文件的路径.
 * 3:讲这些路径存储到集合中.
 * 4:讲集合中的数据泄露到一个文件中
 */
public class JavaFileList {

	public static void main(String[] args) {
		File dir = new File("/users/sqzs/Documents/workspace");
		List<File> list = new ArrayList<File>();
		fileToList(dir, list);
		for (File file : list) {
			System.out.println(file.getName());
		}
		System.out.println(list.size());
		File f = new File("/users/sqzs/Documents/workspace/javaFiles.txt");
		try {
			listToFile(f, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void listToFile(File dir, List<File> list) throws Exception {
		BufferedWriter bufw = null;
		try {
			bufw = new BufferedWriter(new FileWriter(dir));
			for (File file : list) {
				bufw.write(file + "	-->最后修改时间:" + getDateStr(file.lastModified()));
				bufw.newLine();
				bufw.flush();
			}
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				bufw.write("总个数:" + list.size());
				if (bufw != null) {
					bufw.close();
				}
			} catch (Exception ex) {
				throw ex;
			}
		}

	}

	private static void fileToList(File dir, List<File> list) {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (!file.isHidden() && file.isDirectory()) {
				fileToList(file, list);
			} else {
				if (file.getName().endsWith(".java")) {
					list.add(file);
				}
			}
		}
	}

	private static String getDateStr(long millis) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(millis);
		Formatter ft = new Formatter(Locale.CHINA);
		return ft.format("%1$tY年%1$tm月%1$td日%1$tA，%1$tT %1$tp", cal).toString();
	}
}
