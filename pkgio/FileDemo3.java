package pkgio;

import java.io.File;
/*列出指定目录下文件或者文件夹,包含子目录中的内容.
 * 递归要注意:
 * 1:限定条件
 * 2:要注意递归次数,避免内存溢出
 */
public class FileDemo3 {
	public static void main(String[] args) {
		File dir = new File("/Users/SQZS/desktop");
		showDir(dir,0);
//		toBin(6);
//		System.out.println(getSum(9924));
	}
	private static String getLevel(int level){
		StringBuilder sb = new StringBuilder();
		sb.append("|--");
		for(int x = 0; x < level; x++){
//			sb.append("|--");
			sb.insert(0,"   ");
		}
		return sb.toString();
	}
	private static void showDir(File dir,int level){
		System.out.println(getLevel(level) + dir.getName());
		level++;
		File[] files = dir.listFiles();
		for(int x = 0; x < files.length; x++){
			if(files[x].isDirectory()){
				showDir(files[x],level);
			}else{
			System.out.println(getLevel(level) + files[x]);
			}
		}
	}
	private static int getSum(int num){
		if(num == 1){
			return 1;
		}
		return num + getSum(num - 1);
	}
	private static void toBin(int num){
		if(num > 0){
			toBin(num / 2);
			System.out.println(num % 2);
		}
	}
	
}