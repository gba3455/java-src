package pkgsystemclass;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
public class TestReadProperties {

	static void getProperties() throws Exception{
		try {
			InputStream in = new BufferedInputStream(new FileInputStream("/Users/SQZS/Documents/workspace/Test/src/pkgsystemclass/a.properties"));
			Properties p = new Properties();
			p.load(in);
			System.out.println("1===" + p.getProperty("1"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void getSystemProperties(){
		Properties p = System.getProperties();
		Enumeration e = p.propertyNames();
		while(e.hasMoreElements()){
			System.out.print(e.nextElement() + "	");
		//System.out.println(p.getProperty((String)e.nextElement()));
		System.out.printf("%s\n",p.getProperty((String)e.nextElement()));//java 5.0开始支持C格式的输出
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		getSystemProperties();
	}

}
