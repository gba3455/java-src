package pkgregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 正则表达式:符合一定规则的表达式
 * 作用:用于专门操作字符串.
 * 特点:用鱼一些特点的符号来表示一些代码操作.这样就简化了书写.
 * 所以学习正则表达式,就是在学习一些特殊符号的使用.
 * 好处:可以简化对字符串的复杂操作.
 * 弊端:符号定义越多,正则越长,阅读性越差.
 * 具体操作功能:
 * 1:匹配:String matches方法.
 * 
 * 2:切割:String split()
 * 
 * 3:替换:String replaceAll()
 * 
 * 4:获取:将字符串中符合规则的子串取出.
 * 操作步骤:
 * 1:将正则表达式封装成对象.
 * 2:让正则对象和要操作的字符串相关联.
 * 3:关联后获取正则匹配引擎.
 * 4:通过引擎对符合规则的子串进行操作.比如取出.
 */
public class RegexDemo {
	public static void main(String[] args) {
//		splitDemo("zhangssan   lisi wangwu"," +");//按照多个空格来切割
//		splitDemo("zhangssan.lisi.wangwu","\\.");
//		splitDemo("c:\\abc\\a.txt","\\\\");
		//按照叠词切.kk ww zz.第一位可以是任意,所以用.来表示.第二位必须要是第一位的结果.所以吧第一位的.封装成一个组,封装后自动会有
		//一个组的编号,从1开始.所以第二位用\\1来表示使用第一组的结果.
//		splitDemo("fdskkfdakjwwfdskazzfef","(.)\\1");//为了可以让规则的结果被重用,可以将规则封装成一个组.用()完成.
//		splitDemo("fdskkfdakjwwfdskazzzzzzfef","(.)\\1+");
//		replaceDemo("fds1akfda13800010101fdkafjd4324832fdakfjdsak43243243fda","\\d{5,}","#");//将5个以上的数字换成#
//		replaceDemo("fdskkfdakjwwfdskazzzzzzfef","(.)\\1+","#");//将叠词换成#
//		replaceDemo("fdskkfdakjwwfdskazzzzzzfef","(.)\\1+","$1");//将叠词换成单个 $符号获取前面规则里的第一组
		//如果没有定义(.),那原字符串就是第0组,所以(.)是从第一组开始.
		regexDemo2();
	}
	static void regexDemo2(){
		String str = "ming tian jiu yao fang jia le ,da jia.";
		String reg = "\\b[a-z]{3}\\b";//\\b是单词边界
		//将规则封装成对象.
		Pattern p = Pattern.compile(reg);
		//让正则对象和要作用的字符串相关联.获取匹配器对象.
		Matcher m = p.matcher(str);
//		System.out.println(m.matches());//其实String类中的matches方法用的就是Pattern和Matcher对象来完成的.
		//只不过被String的方法封装后,用起来较为简单.但是功能却单一.
//		m.find();//将规则作用到字符串上,并进行符合规则的子串查找.
//		System.out.println(m.group());//用于获取匹配后的结果.
		while(m.find()){
			System.out.println(m.group());
		}
		
	}
	static void replaceDemo(String str,String regex,String newStr){
		System.out.println(str.replaceAll(regex, newStr));
	}
	public static void splitDemo(String str,String regex){
		String[] arr = str.split(regex);
		for(String s : arr){
			System.out.println(s);
		}
	}
	public static void checkTel(){
		String tel = "13800001111";
		String regex = "1[358]\\d{9}";
		System.out.println(tel.matches(regex));
	}
	public static void checkQQRegex(){
		String qq = "12345";
		String regex = "[1-9][0-9]{4,14}";
		boolean flag = qq.matches(regex);
		if(flag){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}
	/*
	 * 对QQ号码进行校验
	 * 要求:5~15位 0不能开头.只能是数字.
	 */
	public static void checkQQ(){
		String qq = "12a45";
		
		int len = qq.length();
		if(len >= 5 && len <= 15){
			if(!qq.startsWith("0")){
				//麻烦
//				char[] arr = qq.toCharArray();
//				boolean flag = true;
//				for(int x = 0; x < arr.length; x++){
//					if(!(arr[x] >= '0' && arr[x] <= '9')){
//						flag = false;
//						break;
//					}
//				}
//				if(flag){
//					System.out.println("qq:" + qq);
//				}else{
//					System.out.println("fei fa");
//				}
				//简单一些.让java判断.
			}else{
				System.out.println("start 0");
			}
		}else{
			System.out.println("len err");
		}
	}
}
