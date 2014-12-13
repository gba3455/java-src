package pkgio;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FileDemo2 {
	public static void main(String[] args) {
		listRoots();
		listString();
		listFiles();
	}
	private static void listRoots(){
		File[] files = File.listRoots();
		for (File file : files) {
			System.out.println(file);
		}
	}
	private static void listString(){
		int count = 0;
		File d = new File("/Users/SQZS/Library/Containers/com.tencent.qq/Data/Library/Application Support/QQ/79694406/image");
		//调用list方法的file对象必须是封装了一个目录,该目录还必须存在,否则空指针错误.
		String[] lists = d.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith("jpg") | name.endsWith("gif");
			}
		});
		for (String string : lists) {
			count++;
		}
		System.out.println(count);
	}
	private static void listFiles(){
		File d = new File("/Users/SQZS/Library/Containers/com.tencent.qq/Data/Library/Application Support/QQ/79694406/image");
		File[] files = d.listFiles();
		for (File file : files) {
			System.out.println(file.getName());
//			file.deleteOnExit();
			System.out.println(file.getName() + file.length()/1000);
		}
	}
}
