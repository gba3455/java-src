package pkgregex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/*
 * 思路:
 * 1:如果只想知道该字符是对是错,使用匹配.
 * 2:想要将已有的字符串变成另外一个字符串,用替换.
 * 3:想要按照指定的方式讲字符串变成多个字符串,可以用切割.获取规则以外的子串.
 * 4:想要拿到符合需求的字符串子串,用获取.获取符合规则的子串.
 */
public class RegexTest {
	public static void main(String[] args) {
//		test_1();
//		ipSort();
		checkMail();
	}


	private static void test_1() {
		String str = "我我...我我...我要...要...要要...要要...学学学....学学...编编编....程";
		/*
		 * 1:可以先将.去掉.
		 * 2:在将多个重复的内容变成单个内容.
		 */
		str = str.replaceAll("\\.+", "");
		System.out.println(str);
		
		str = str.replaceAll("(.)\\1+", "$1");
		System.out.println(str);
	}
	/*
	 * 192.68.1.254 102.49.23.013 10.10.10.10 2.2.2.2 8.109.90.30
	 * 将ip地址进行地址段顺序的排序
	 * 
	 * 还按照字符串自然顺序,只要让他们每一段都是3位即可.
	 * 1:按照每一段需要的最多的0进行补齐.那么每一段就会至少保证有3位.
	 * 2:将每一段只保留3位.这样所有的ip地址都是每一段3位.
	 */
	
	private static void ipSort() {
		String ip = "192.68.1.254 102.49.23.013 10.10.10.10 2.2.2.2 8.109.90.30";
		ip = ip.replaceAll("(\\d+)", "00$1");
		System.out.println(ip);
		ip = ip.replaceAll("0*(\\d{3})", "$1");
		System.out.println(ip);
		
		String[] arr = ip.split(" +");
//		Arrays.sort(arr);//可以用这个,也可以用TreeSet也能排序,但是如果数组里有重复,就一定要用这个.
//		for(String str : arr){
//			System.out.println(str);
//		}
		//或者存到一个list集合里,先把集合转成list集合,在吧list集合用Collections.sort.
//		List<String> al = Arrays.asList(arr);
//		Collections.sort(al);
//		for (String string : al) {
//			System.out.println(string);
//		}
		TreeSet<String> tree = new TreeSet<String>();
		for (String string : arr) {
			tree.add(string);
		}
		for (String string : tree) {
			System.out.println(string.replaceAll("0*(\\d+)", "$1"));
		}
	}
	
	/*
	 * 重要!
	 * 需求:对邮件地址进行校验.
	 */
	private static void checkMail() {
		String mail = "abc12@sina.com.cn";
		String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";//较为精确的匹配
		String reg = "\\w+@\\w+(\\.\\w+)+";//相对不太精确的匹配.
		System.out.println(mail.matches(regex));
		String mail2 = "1@1.1";
		System.out.println(mail2.matches(reg));
	}
}
