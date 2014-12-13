package pkdefault;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexDemo {
	public static void Tel(){
		try{
			String str = "13800000000";
			Pattern pattern1 = Pattern.compile("[0-9]{11}");
			Matcher matcher1 = pattern1.matcher(str);
			if (matcher1.matches()) {
				System.out.println("电话号码" + str + "格式正确");
			}
			else{
				System.out.println("电话号码" + str + "格式有误");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void Ip(){
		String str = "127.0.0.1";
		Pattern pattern1 = Pattern.compile("[\\d]{1,3}"
				+ "\\."
				+ "[\\d]{1,3}"
				+ "\\."
				+ "[\\d]{1,3}"
				+ "\\."
				+ "[\\d]{1,3}");
		Matcher matcher1 = pattern1.matcher(str);
		if (matcher1.matches()) {
			System.out.println("IP地址" + str + "格式正确");
		}
		else{
			System.out.println("IP地址" + str + "格式错误");

		}
	}
	public static void Mail(){
		String str = "gba3455@me.com";
		//Pattern pattern1 = Pattern.compile("^(.+)@(.+)$");
		Pattern pattern1 = Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");

		Matcher matcher1 = pattern1.matcher(str);
		if (matcher1.matches()) {
			System.out.println("Email地址" + str + "格式正确");
		}
		else{
			System.out.println("Email地址" + str + "格式错误");
		}
	}
	public static void main(String[] args) {
		Tel();
		Ip();
		Mail();
	}
	//正则查找的功能
		public static void method_5(){
		    String str = "my home zai yuan fang ni mei qu guo";
			//找出3个字母的单词
			//预编译正则
			String reg = "\\b[a-zA-Z]{3}\\b";
			Pattern p = Pattern.compile(reg);
			//正则规则，匹配字符串
			Matcher m = p.matcher(str);

		//	System.out.println(m.find());
			while(m.find()){
				System.out.println(m.group());
			}
		}

		//验证电子邮件的格式
		public static void method_4(){
		  String email = "shisong@163.com";
		  boolean b = email.matches(
			  "[a-zA-Z_0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+");
		  System.out.println(b);
		}

		//叠词的还原
		public static void method_3(){
		  String str = "我.要要要.要要.学.学...学.编编...编..编....程.程程...程";
		  str = str.replaceAll("\\.+","");
		  System.out.println(str);
		  str = str.replaceAll("(.)\\1+","$1");
		  System.out.println(str);
		}
		//正则表达式的替换作用
		public static void method_2(){
		   String str = "helllowssorrrrrld";
		   String s = str.replaceAll("(.)\\1+","$1");
		   System.out.println(s);
		}

		//正则表达式的切割作用
		public static void method_1(){
			//String str = "192      168    3      123";

			String  str = "abqqqqqcdettfdhhgtnssth";
			//正则组，()专门处理叠词
			String[] arr = str.split("(.)\\1+");
			for(String s : arr){
			   System.out.println(s);
			}
		}

		//正则表达式的匹配作用
		public static void method(){
			String str = "f3f";
			//检查 中间的字符是不是元音字母
			boolean b = str.matches("f[\\d]f");
			System.out.println(b);

			String str1 = "tooooo";
			b = str1.matches("to{2,4}");
			System.out.println(b);

			String num = "12800138000";
			b = num.matches("1[3568][0-9]{9}");
			System.out.println(b);
		}
}
