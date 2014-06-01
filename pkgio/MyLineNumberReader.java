package pkgio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MyLineNumberReader extends MyBufferedReader{
	private int lineNumber = 0;
	public MyLineNumberReader(Reader r) { 
		super(r);
		
	}
	public int myGetLineNumber(){
		return lineNumber;
	}
	public void mySetLineNumber(int lineNumber){
		this.lineNumber = lineNumber;
	}
//	public String myReadLine() throws IOException{
//		StringBuilder sb = new StringBuilder();
//		int ch = 0;
//		while((ch = r.read()) != -1){
//			if(ch == '\r'){
//				continue;
//			}
//			if(ch == '\n'){
//				lineNumber++;
//				return sb.toString();
//			}else{
//				sb.append((char)ch);
//			}
//		}
//		if(sb.length() != 0){
//			return sb.toString();
//		}
//		return null;
//	}
	public String myReadLine() throws IOException{
		lineNumber++;
		return super.MyReadLine();
	}

	public static void main(String[] args) {
		FileReader fr = null;
		MyLineNumberReader mlnr = null;
		try {
			fr = new FileReader("./src/Test.java");
			mlnr = new MyLineNumberReader(fr);
			String line = null;
			mlnr.mySetLineNumber(100);
			while((line = mlnr.myReadLine()) != null){
				System.out.println(mlnr.myGetLineNumber() + ":" + line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (mlnr != null) {
					mlnr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
