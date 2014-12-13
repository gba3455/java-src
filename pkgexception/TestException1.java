package pkgexception;


/**
 * 1) 定义名为: TestException1.java的类
2) 写一个把字符串转成整型的方法，出错时返回默认值
public static int stringToInt(String str, int defaultValue){ //… };
 * @author SQZS
 *
 */
public class TestException1 {
//	public static int stringToInt(String str,int defaultValue)throws NumberFormatException{
//			int temp = Integer.parseInt(str);
//			return defaultValue;
//	}

//	public static void main(String[] args) {
//		try{
//			stringToInt("two", 1);
//		}
//		catch(NumberFormatException cce){
//			System.out.println("Exception");
//		}
//	}
	static int stringToInt(String str,int defaultValue){
		try{
			return Integer.parseInt(str);
		}catch(Exception e){
			System.out.println("字符串转换失败");
		}
		return defaultValue;
	}
	public static void main(String[] args) {
		System.out.println(stringToInt("123uu", 9));
	}
}
