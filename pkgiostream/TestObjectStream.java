package pkgiostream;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestObjectStream{

	public static void main(String[] args) {
		// 对象要在流里面传输 必须要实现序列化的接口
		// 否则会抛出 NotSerialzableException 异常
		
		/**
		 * public interface Serializable
		 * 类通过实现java.io.Serializable接口
		 * 以启用其序列化功能.未实现此接口的类将无法使其任何状态序列化或反序列化
		 * 可序列化类的所有子类本身都是可以序列化的.序列化接口没有方法或字段,仅用于标示可序列化的语义
		 */
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(System.out);
//			objectOutputStream.writeObject("hhhhhh");//输出�� t hhhhhh,输出的是对象,而不是字符串
//			objectOutputStream.writeObject(new Object());//未序列化异常
			//String类
			String temp = "dfa";
			/**
			 * public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence
					String类里面实现了该接口
			 */
			objectOutputStream.writeObject(new User());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				objectOutputStream.flush();
				objectOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
