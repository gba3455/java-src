package pkgexception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;


public class TestException {
	static void testNumberFormat() throws ParseException{
		String source = "abc";
		NumberFormat format = NumberFormat.getInstance();
		Number number = format.parse(source);
		System.out.println("method exit...");
	}
	static void tryCatch(){
		File file = new File("/Users/SQZS/Desktop/newFileFromJavaProgram.txt");
		//出了运行时的异常之外，其他的异常必须要处理
		//处理异常：捕获异常 try catch finally
		//声明异常：放在方法的后面 说明这个方法可能会出现异常
		//终止异常产生后面的语句
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static double divide(int a,int b){
		//ArithmeticException
		if (b == 0) {
			//人为抛出异常对象
			throw new ArithmeticException("被除数为0");
		}
		double result = 0;
		result = a/b;
		return result;
	}
	public static void main(String[] args) throws FileNotFoundException {
//		String s = null;
//		//运行时异常编译阶段不需要处理
//		System.out.println(s.length());
		double d = 1;
		try {
			d = divide(1, 0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("异常信息" + e.getMessage());
		}
		System.out.println(d);
		try {
			testNumberFormat();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("exit...");
//		FileInputStream fileInputStream = new FileInputStream(file);
	}
}
