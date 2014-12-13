package pkgiostream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestBufferedStream {
	static void bufferedCopy(){
		FileInputStream fileInputStream = null;
		BufferedInputStream bufferedInputStream = null;
		FileOutputStream fileOutputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		String filePath = "./image/image.jpg";
		String fileName = "new" + filePath.substring(filePath.lastIndexOf("/") + 1);
		try {
			fileInputStream = new FileInputStream(filePath);
			bufferedInputStream = new BufferedInputStream(fileInputStream);
			
			fileOutputStream = new FileOutputStream("./src/pkgiostream/copy/" + fileName);
			bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			//用数组
			byte[] bytes = new byte[24];
			
			int read = 0;
			while((read = bufferedInputStream.read(bytes, 0, bytes.length)) != -1){
				bufferedOutputStream.write(bytes, 0, read);
			}
			
			//不用数组也可以
//			int read = 0;
//			while((read = bufferedInputStream.read()) != -1){
//				bufferedOutputStream.write(read);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				bufferedOutputStream.flush();
				bufferedOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bufferedInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bufferedCopy();
	}

}
