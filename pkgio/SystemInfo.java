package pkgio;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Properties;

public class SystemInfo {

	public static void main(String[] args) throws Exception {
		Properties prop = System.getProperties();
//		System.out.println(prop);
//		prop.list(System.out);
		prop.list(new PrintStream("SysInfo.txt"));
	}

}
