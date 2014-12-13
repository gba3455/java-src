package pkdefault;

public class Test_String {
	static void String_equals(){
		// TODO Auto-generated method stub
		//String str1 = "";//对象已经创建 内容是空字符串 占内存
		String str2 = null;//对象没有创建 不占内存 没有内存地址
		String str1 = "abc";
		String str3 = new String("abc");
		System.out.println("str1 = " + str1.toString());
		System.out.println("str3 = " + str3);
		System.out.println(str1 == str3);
		
		String str4 = "ab" + "c";
		System.out.println("str4 == str1" + (str4 == str1));
		System.out.println("str4 equals str3" + str4.equals(str3));
		System.out.println("str4 equals str1" + str4.equals(str1));
		//equals比较的是字面值是否相同
		System.out.println("str4 == str3" + (str4 == str3));
	}
	static void fun_String(){
		String s = "abcdefgAAA";//0 ~ s.length-1
		char c = s.charAt(2);//'c'
		int length = s.length();//对应数组里面属性length
		int indexOf = s.indexOf("cde");//有重载
		int lastIndexOf = s.lastIndexOf("ef");
		int compareTo = s.compareTo("d");//按照字典顺序比较大小
		String concat = s.concat("lkk");
		String toLower = s.toLowerCase();
		String toUpper = s.toUpperCase();
		System.out.println(s);//s本身没变化
	}
	static void fun_String2(){
		String s = "abcdefgefhehs";
		s.replace('e', '*');//替换
		System.out.println(s.replace('e', '*'));
		String subString1 = s.substring(0);
		String subString2 = s.substring(0,2);
		String s2 = "77.88.99.88";
		String[] split = s2.split("\\.");//参数regex，正则表达式。点在正则表达式里是匹配所有的字符的意思
		//所以如果是点的话，它就不进行截取。所以要通过转义
		System.out.println("截取的长度为=" + split.length);
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
		}
		String s3 = "77,88,99,88";
		System.out.println(s3.split(",").length);
	}
	static void fun_String3(){
		StringBuffer str = new StringBuffer("a");
		StringBuffer str2 = new StringBuffer("abcdefgh");
		StringBuffer str3 = new StringBuffer(8);
		System.out.println(str.append(str2));//用途是当需要大量的字符串拼接时使用  优点效率比+=要高很多
		System.out.println(str);//+=内存中是相当于创建副本重新赋值，StringBuffer是指针的引用）
		System.out.println(str2.reverse());//倒序
		System.out.println(str2.insert(3, '*'));
		System.out.println(str.delete(1, 5));
		System.out.println(str3.length());
		String str4 = str2.toString();
		System.out.println(str4);
	}
	static void fun_String4(){
		//该类被设计用作 StringBuffer 的一个简易替换，建议优先采用该类，因为在大多数实现中，它比 StringBuffer 要快;
		StringBuilder str = new StringBuilder();
		StringBuilder str2 = new StringBuilder("abcdefgh");
		StringBuilder str3 = new StringBuilder(8);
		System.out.println(str.append(str2));
		System.out.println(str);
		System.out.println(str2.reverse());//倒序
		System.out.println(str2.insert(3, '*'));
		System.out.println(str.delete(1, 5));
		System.out.println(str3.length());
		String str4 = str2.toString();
		System.out.println(str4);
	}
	static void testConstructor(){
		String str = new String();
		byte [] bytes = new byte[]{97,98,99};
		String strarr = new String(bytes);
		String strarr2 = new String(bytes,0,3);
		System.out.println("strarr2 = " + strarr2);
		char[] arrchar = new char[]{'a','b','c'};
		String strChar1 = new String(arrchar);
		String strChar2 = new String(arrchar,0,3);
		System.out.println("strChar1 = "+ strChar1);
	}
	public static void main(String[] args) {
//		fun_String4();
		String str = new String("     abcde    ");
		boolean tof =  str.contains("abc");
		/**
		 * indexOf(str)可以索引"abc"第一次出现的位置,如果返回-1表示str不存在.
		 * if(str.indexOf("abc) != -1)
		 */
		//3 + ""; == String.valueOf(3);
		System.out.println(str);
		System.out.println(str.trim());//去除2端空格.用在用户名密码
		
		System.out.println(myReverseString(str));
		String s1 = "fdaklfjdhttpsfdakfjd";
		String s2 = "httpsssdfd";
		System.out.println(getMaxSubString(s1, s2));
	}
	public static String myReverseString(String str){
		
		char[] chs = str.toCharArray();
		
		reverse(chs);
		
		return new String(chs);
	}
	private static void reverse(char[] chs){
		for(int start = 0,end = chs.length -1 ; start < end ; start ++ , end--){
			swap(chs,start,end);
		}
	}
	private static void swap(char[] chs,int start,int end){
		char temp = chs[start];
		chs[start] = chs[end];
		chs[end] = temp;
	}
	public static String getMaxSubString(String s1,String s2){
		String max = "";
		String min = "";
		
		max = (s1.length() > s2.length()) ? s1 : s2;
		min = (max == s1) ? s2 : s1;
		
		for(int x = 0 ; x < min.length(); x++){
			for(int y = 0 , z = min.length() - x ; z != min.length() + 1; y++ , z++){
				String temp = min.substring(y, z);
				
				if(max.contains(temp)){
					return temp;
				}
			}
		}
		return "";
	}
}
