package pkgio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

//切割文件
public class SplitFiles {

	public static void main(String[] args) throws Exception {
//		splitFile();
		hebinFile();
	}
	public static void splitFile() throws Exception{
		FileInputStream fis = new FileInputStream("/users/sqzs/desktop/out.jpg");
		
		FileOutputStream fos = null;
		int count = 1;
		byte[] buf = new byte[1024 * 10];
		int len = 0;
		while((len = fis.read(buf)) != -1){
			fos = new FileOutputStream("/users/sqzs/desktop/a/" + (count ++) + ".jpg");
			fos.write(buf, 0, len);
			fos.close();
		}
		fis.close();
	}
	public static void hebinFile() throws Exception{
		File[] files = (new File("/users/sqzs/desktop/a")).listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				if(pathname.getName().endsWith(".jpg"))
				return true;
				return false;
			}
		});
		Vector<FileInputStream> v = new Vector<FileInputStream>();//效率低
		ArrayList<FileInputStream> list = new ArrayList<FileInputStream>();//效率高
		for (File file : files) {
			list.add(new FileInputStream(file));
		}
		final Iterator<FileInputStream> it = list.iterator();
		Enumeration<FileInputStream> e = new Enumeration<FileInputStream>() {

			@Override
			public boolean hasMoreElements() {
				// TODO Auto-generated method stub
				return it.hasNext();
			}

			@Override
			public FileInputStream nextElement() {
				// TODO Auto-generated method stub
				return it.next();
			}
		};
		SequenceInputStream sis = new SequenceInputStream(e);
		FileOutputStream fos = new FileOutputStream("/users/sqzs/desktop/newout.jpg");
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = sis.read(buf)) != -1){
			fos.write(buf, 0, len);
			
		}
		fos.close();
		sis.close();
	}
}
