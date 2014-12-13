package pkgio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//对象序列化 : 对象的持久化保存
public class ObjectStreamDemo {

	public static void main(String[] args) throws Exception {
//		writeObj();
		readObj();
	}

	public static void writeObj() throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/users/sqzs/desktop/objectOut.object"));
		
		oos.writeObject(new Person("lisi",30,"kr"));
		//如果要存多个对象,可以直接存进去.读取的时候readObject方法调用一次读一个,调第2次读第2个.
//		oos.writeObject(new Person("lisi",30,"kr"));
//		oos.writeObject(new Person("lisi",30,"kr"));
//		oos.writeObject(new Person("lisi",30,"kr"));
//		oos.writeObject(new Person("lisi",30,"kr"));
		
		
		oos.close();
	}
	
	public static void readObj() throws Exception{
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/users/sqzs/desktop/objectOut.object"));
		
		Person p = (Person)ois.readObject();
		
		System.out.println(p.toString());
//		System.out.println(((Person)ois.readObject()).toString());
//		System.out.println(((Person)ois.readObject()).toString());
	}
}
class Person implements Serializable{
	static final long serialVersionUID = 42L;//自定义对象的UID //否则一旦改变对象里的内容,java就会新生成一个UID
	String name;
	//如果非静态变量也不想被序列化,就加上transient修饰符
	transient int age;
	static String country = "cn";//静态不能被序列化,所以传值进来,内容也不会改变.
	public Person(String name,int age,String country) {
		this.name = name;
		this.age = age;
		this.country = country;
	}
	public String toString(){
		return name + "*" + age + "+" + country;
	}
}
