package pkgiostream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBufferedReader {
	private static String getDate(int type){
		SimpleDateFormat sdf;
		switch (type) {
		case 1:
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			break;

		default:
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			break;
		}
		return sdf.format(new Date());
	}
	private static void bufferedRead() {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader("./src/pkgiostream/reader/" + getDate(1) + ".log");
			bufferedReader = new BufferedReader(fileReader);
			String readLine = bufferedReader.readLine();//换行符结尾表示一行 null表示读到文件的尾部
			while(readLine != null){
				System.out.println(readLine);
				readLine = bufferedReader.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fileReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	private static void bufferedWrite() {
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter("./src/pkgiostream/reader/" + getDate(1) + ".log");
			bufferedWriter = new BufferedWriter(fileWriter);
			String time = "[" + getDate(2) + "]";
			String content1 = time + " " + "00001上线啦";
			String content2 = time + " " + "00001下线啦";
			String content3 = time + " " + "服务器启动成功";
			String content4 = time + " " + "服务器关闭";
			bufferedWriter.write(content1);
			bufferedWriter.newLine();
			bufferedWriter.write(content2);
			bufferedWriter.newLine();
			bufferedWriter.write(content3);
			bufferedWriter.newLine();
			bufferedWriter.write(content4);
			bufferedWriter.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bufferedWriter.flush();
				bufferedWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
//		bufferedWrite();
//		bufferedRead();
		System.out.println("end...");
	}
}
