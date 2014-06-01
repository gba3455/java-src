package pkgiostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {
	String filePath = "./src/pkgiostream/config/config.ini";
//	配置文件 键值对保存
//	配置管理 保存端口号
	Properties properties = new Properties();//持久层对象
	public TestConfig() {
		// TODO Auto-generated constructor stub
		load();
	}
	private void load() {
		// TODO Auto-generated method stub
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(filePath);
			properties.load(fileInputStream);//把文件里面的数据加载到内存
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fileInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void setProperties(String key,String value){
		properties.setProperty(key, value);
	}
	private String getProperties(String key,String defaultValue){//如果没有对应的key,返回defaultValue
		return properties.getProperty(key, defaultValue);
	}
	private void save(){
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(filePath);
			properties.store(fileOutputStream, "comments这是备注");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				fileOutputStream.flush();
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		TestConfig config = new TestConfig();
//		config.setProperties("port", "8099");
//		config.setProperties("username", "admin");
//		config.setProperties("pa55w0rd", "123456");
//		config.save();
		String port = config.getProperties("port", "9999");
		System.out.println("port" + port);
		System.out.println("end......");
	}
}

