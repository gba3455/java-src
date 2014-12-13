package pkgio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/*
 * Properties是hashtable的子类
 * 也就是说它具备map集合的特点.而且他里面存得键值对都是字符串.
 * 
 * 是集合中和IO技术相结合的集合容器.
 * 
 * 该对象的特点:可以用于键值对形式的配置文件.
 * 
 * 那么在加载数据时,需要数据有固定格式:键=值
 */
public class PropertiesDemo {
	public static void main(String[] args) {
//		setAndGet();
//		method_1();
		method_2();
	}
	private static void method_2(){
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("/users/sqzs/desktop/1jpg.txt"));
//			System.out.println(prop);
			
			prop.setProperty("张三", "45");//改变的是内存中的内容
			prop.list(System.out);
			
			prop.store(new FileWriter("/users/sqzs/desktop/1jpg.txt"), null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//将流中的数据存储在集合中.
	//想要将info.txt中键值对数据存到集合中进行操作.
	/*
	 * 1:用一个流和info.txt文件关联.
	 * 2:读取一行数据,讲该行数据用=进行切割
	 * 3:等号左边作为键,右边作为值.存入到Properties集合中即可.
	 */
	private static void method_1(){
		BufferedReader bufr = null;
		try {
			bufr = new BufferedReader(new FileReader("/users/sqzs/desktop/1jpg.txt"));
			String str = null;
			Properties prop = new Properties();
			while((str = bufr.readLine()) != null){
//				int pos = str.indexOf("=");
//				String key = str.substring(0, pos);
//				String value = str.substring(pos + 1);
				String[] arr = str.split("=");
				prop.setProperty(arr[0], arr[1]);
			}
			System.out.println(prop);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bufr != null){
				try {
					bufr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
//	设置和获取元素
	private static void setAndGet(){
		Properties prop = new Properties();
		prop.setProperty("张三", "30");
		prop.setProperty("李四", "20");
		
		System.out.println(prop);
		System.out.println(prop.getProperty("张三"));
		
		prop.setProperty("李四", "39");
		
		Set<String> names = prop.stringPropertyNames();
		for (String s : names) {
			System.out.println(s + ":" + prop.getProperty(s));
		}
	}
	
}
