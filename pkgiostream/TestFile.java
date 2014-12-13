package pkgiostream;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.filechooser.FileFilter;

public class TestFile {
	private static void file(){
		File file = new File("");
		System.out.println("file===" + file);
		//获得工程的絶對路径
		String absolutePath = file.getAbsolutePath();
		System.out.println("absolutePath===" + absolutePath);
		File fileAbsolute = new File("/Users/SQZS/Desktop");
		System.out.println("fileAbsolute===" + fileAbsolute);
		boolean isDirectory = fileAbsolute.isDirectory();//判断是否是路径
		boolean isFile = fileAbsolute.isFile();//判断是否是文件
		boolean isAbosolute = fileAbsolute.isAbsolute();//判断是否是絶對路径
		boolean isHidden = fileAbsolute.isHidden();//判断是否隐藏
		String name = fileAbsolute.getName();//获得文件名
		long size = fileAbsolute.length();//获得文件大小 字节
		boolean exsits = fileAbsolute.exists();//是否存在
		
		//创建文件
//		File file2 = new File("/Users/SQZS/Desktop/new.txt");
//		//当文件的父目录不存在的时候,创建就会报异常
////		File file2 = new File("/Users/SQZS/Desktop/fdafdsaf/new.txt");
//		if(file2.exists() == false){
//			try {
//				boolean createFile = file2.createNewFile();
//				System.out.println("createFile === " + createFile);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		//创建文件夹
		File fileDir = new File("/Users/SQZS/Desktop/new");
		boolean mkdir = fileDir.mkdir();
		System.out.println("mkdir ===" + mkdir);
		boolean mkdirs = fileDir.mkdirs();
		System.out.println("mkdirs ===" + mkdirs);
		
		File fileDir2 = new File("/Users/SQZS/Desktop/new/new2");
		boolean mkdir2 = fileDir2.mkdir();
		System.out.println("mkdir ===" + mkdir);
		boolean mkdirs2 = fileDir2.mkdirs();
		System.out.println("mkdirs ===" + mkdirs);
		
		File fileDir3 = new File("/Users/SQZS/Desktop/new/abc");
		boolean mkdir3 = fileDir3.mkdir();
		System.out.println("mkdir ===" + mkdir);
		boolean mkdirs3 = fileDir3.mkdirs();
		System.out.println("mkdirs ===" + mkdirs);
		//删除文件夹
		File fileDel = new File("/Users/SQZS/Desktop/new.txt");
		boolean del = fileDel.delete();
		System.out.println("del ===" + del);
		//获得父目录下所有子目录或者文件列表
		File fileDesktop = new File("/Users/SQZS/Desktop/new");
		File[] fileList = fileDesktop.listFiles();
		for (File file3 : fileList) {
			System.out.println(file3);
		}
		//删除文件及目录 自己写的方法
//		String path = "/Users/SQZS/Desktop/new";
//		while(true){
//			File fileDesktop = new File(path);
//			File[] fileList = fileDesktop.listFiles();
//			ArrayList<String> fileArr = new ArrayList<String>();
//			for (File file2 : fileList) {
//				if(file2.isDirectory()){
//					path = file2.getPath();
//					fileArr.add(path);
//				}else{
//					file2.delete();
//				}
//			}
//			for (int i = 0; i < fileArr.size(); i++) {
//				File temp = new File(fileArr.get(i));
//				temp.delete();
//			}
//			fileDesktop.delete();
//			break;
//		}
	}
	//删除文件及目录 递归法
	static void diGuiDelDir(File file){
		File[] files = file.listFiles();
		if(files != null){//非空说明有子目录
			for (File file2 : files) {
				if(file2.isDirectory()){//是目录
					diGuiDelDir(file2);
				}
				else{//不是目录
					file2.delete();
				}
			}
		}
		//删除自己
		file.delete();
	}
	//FileFilter 过滤文件夹
	static void fileFilter(File file) {
		File[] files = file.listFiles(new java.io.FileFilter() {
			//子路径 过滤文件夹
			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory();
			}
		});
		for (File file2 : files) {
			System.out.println(file2);
		}
	}
	//
	static void fileNameFilter(File file) {
		String[] fileNames = file.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				String temp = dir + "/" + name;
				if(name.endsWith(".png")){
					return true;
				}
				return false;
			}
		});
		System.out.println("过滤.png------------");
		for (String string : fileNames) {
			System.out.println(string);
		}
	}
	
	/**下面是GUI界面用到的方法
	 */
	static ArrayList<String> getDirGui(String path){
		File file = new File(path);
		File[] fileList = file.listFiles();
		ArrayList<String> fileArrList = new ArrayList<String>();
		for (File file3 : fileList) {
			fileArrList.add(file3.toString());
		}
		return fileArrList;
	}
	
	static ArrayList<String> fileNameFilterGui(File file,final String extendName) {
		ArrayList<String>fileArrList = new ArrayList<String>();
		String[] fileNames = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(extendName)){
					return true;
				}
				return false;
			}
		});
		System.out.println("过滤.png------------");
		for (String string : fileNames) {
			System.out.println(string);
			fileArrList.add(string);
		}
		return fileArrList;
	}
	
	public static void main(String[] args) {
//		file();
		File file = new File("/Users/SQZS/Desktop/new");
//		diGuiDelDir(file);
//		fileFilter(file);
		fileNameFilter(file);
	}

}
