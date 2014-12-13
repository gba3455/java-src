package pkgio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyText {

	public static void main(String[] args) {
		copy2();
	}
	//读一个就写一个
	public static void copy1(){
		FileWriter fw = null;
		FileReader fr = null;
		try {
			fw = new FileWriter("/Users/SQZS/Desktop/copy.txt"); 
			fr = new FileReader("./src/Test.java");
			
			int ch = 0;
			while((ch = fr.read()) != -1){
				System.out.println((char)ch);
				fw.write(ch);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("读写失败");
		}finally{
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void copy2(){
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter("/Users/SQZS/Desktop/copy.txt");
			fr = new FileReader("./src/Test.java");
			
			char[] buf = new char[1024];
			int len = 0;
			while((len = fr.read(buf)) != -1){
				fw.write(buf,0,len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("读写失败");
		}finally{
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
