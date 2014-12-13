
package pkgio;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/*
 * 列出指定目录下文件或者文件夹,包含子目录中的内容.
 */
public class FileDemo4 {
	static int count = 1;
	public static void main(String[] args) {
		getDir("/Users/SQZS/desktop/つうやくしてくれ");
		System.out.println(count);
	}
	private static void getDir(String dir){
		File d = new File(dir);
		File[] files = d.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				if(pathname.isHidden())
				return false;
				if(pathname.getName().endsWith(".DS_Store") 
						|| pathname.getName().equals("$RECYCLE.BIN") 
						|| pathname.getName().equals("Thumbs.db") 
						|| pathname.getName().equals("desktop.ini"))
				return false;
				return true;
			}
		});
		for (File file : files) {
			if(file.isDirectory()){
				if(file.getName().endsWith(".app")){
					count++;
				}else{
					count++;
					getDir(file.getAbsolutePath());
				}
			}else{
				System.out.println(file.getName());
				count++;
			}
		}
	}
}
