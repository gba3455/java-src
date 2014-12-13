package pkdefault;
import java.util.Properties;


public class SystemClassDemo {

	public static void main(String[] args) {
		/**
		 * 因为properties是HashTable的子类.也就是map集合的一个子类对象.
		 * 那么可以通过map的方法取出该集合中的元素
		 * 改集合中存储的都是字符串.没有泛型定义
		 */
		Properties prop = System.getProperties();
		System.out.println(prop.get("file.encoding"));
//		for (Object obj : prop.keySet()) {
//			String str = (String) prop.get(obj);
//			System.out.println(obj + "------------------->" + str);
//		}
		for(String str : prop.stringPropertyNames()){
			System.out.println(str + "------------------->" + prop.getProperty(str));
		}
		
	}

}
