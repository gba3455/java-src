/**
 * 
 * 读取文件简单操作
 * 
 * 
 */
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileRead {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileReader filePoint = new FileReader(
				"/Users/SQZS/Desktop/Entitlements.txt");
		int index = 0;
		// filePoint会一个字符一个字符往下读 如果读到尾后 那么index = -1 就退出循环
		while ((index = filePoint.read()) != -1) {
			// 转换数字为Char字符型
			System.out.print((char) index);
		}
		filePoint.close();
	}

}