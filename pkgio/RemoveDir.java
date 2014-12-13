package pkgio;

import java.io.File;

/*
 * 删除一个带内容的目录
 * 删除原理:
 * 在window中,删除目录从里面往外删除.
 * 既然是从里往外删除,就需要用到递归.
 */
public class RemoveDir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("/users/sqzs/desktop/a");
		removeDir(f);
	}
	
	private static void removeDir(File dir){
		File[] files = dir.listFiles();
		for (File file : files) {
			if(!file.isHidden() && file.isDirectory()){
				file.deleteOnExit();
				removeDir(file);
			}
			else{
//				System.out.println(file.getName());
				System.out.println(file.delete());
			}
		}
		dir.delete();
	}
}
