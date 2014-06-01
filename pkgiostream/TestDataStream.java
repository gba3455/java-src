package pkgiostream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataStream {
	private static void out(){
		DataOutputStream dataOutputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("./src/pkgiostream/copy/test.txt");
			dataOutputStream = new DataOutputStream(fileOutputStream);
			for (int i = 0; i < 1000; i++) {
				dataOutputStream.writeInt(i);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void input(){
		FileInputStream fileInputStream = null;
		DataInputStream dataInputStream = null;
//		try {
//			fileInputStream = new FileInputStream("./src/pkgiostream/copy/test.txt");
//			dataInputStream = new DataInputStream(fileInputStream);
//			int i = dataInputStream.readInt();
//			while(i != -1){
//				System.out.println(i);
//				i = dataInputStream.readInt();
//			}
//			//会抛EOFException异常 当输入过程中意外达到文件或流的末尾时,抛出此异常
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			fileInputStream = new FileInputStream("./src/pkgiostream/copy/test.txt");
			dataInputStream = new DataInputStream(fileInputStream);
			int i = dataInputStream.readInt();
			while(i != -1){
				System.out.println(i);
				try {
					//会抛EOFException异常 当输入过程中意外达到文件或流的末尾时,抛出此异常
					i = dataInputStream.readInt();
				} catch (EOFException e) {
					//捕获该异常 并终止循环
					e.printStackTrace();
					break;
				}
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fileInputStream.close();
				dataInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		out();
		input();
	}

}
