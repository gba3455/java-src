package pkgio;

import java.text.*;
import java.util.*;
import java.io.*;

//import org.apache.log4j.Appender;
//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.Layout;
//import org.apache.log4j.Logger;
//import org.apache.log4j.spi.ErrorHandler;
//import org.apache.log4j.spi.Filter;
//import org.apache.log4j.spi.LoggingEvent;
public class ExceptionInfo{
	public static void main(String[] args){
//		OutExInfo();
		Log4J_1();
	}
	private static void OutExInfo(){
		try{
			int[] arr = new int[2];
			System.out.println(arr[3]);
		}catch(Exception e){
			PrintStream ps = null;
			try{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date d = new Date();
				String s = sdf.format(d);
			ps = new PrintStream("/users/sqzs/desktop/ExInfo.txt");
			ps.println(s);
			}catch(Exception ex){
				throw new RuntimeException("FileNotFoundException");
			}
			System.setOut(ps);
			e.printStackTrace(System.out);
		}
	}
	private static void Log4J_1(){
//		Logger logger = Logger.getLogger(ExceptionInfo.class);
//		logger
//		BasicConfigurator.configure();
//		try{
//			int[] arr = new int[2];
//			System.out.println(arr[3]);
//		}catch(Exception e){
//			logger.error(e);
//			try{
//			PrintStream ps = new PrintStream("/users/sqzs/desktop/ExInfo.txt");
//			}catch(Exception ex){
//				logger.error(ex);
//			}
//			logger.error(e);
//		}
	}
}
//log4j日志包.
