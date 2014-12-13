package pkdefault;
/**
 * 
 * 写文件简单操作
 * 
 * 
 */
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileWriter filePoint = new FileWriter(
				"/Users/SQZS/Desktop/newFileFromJavaProgram.txt");
		String s = "HElloWorld";
		filePoint.write(s, 0, s.length());
		filePoint.flush();
		filePoint.close();
	}

}
