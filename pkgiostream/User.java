package pkgiostream;

public class User implements java.io.Serializable{
//	int nid = 99;
	Integer nid = 99;
	String name = "测试";
	//Object o = new Object();//依然会抛出没有序列化异常
	
	//该类本身要实现序列化 该类里面所有属性也必须实现序列化
	//String本身有序列化了 int没有
}
