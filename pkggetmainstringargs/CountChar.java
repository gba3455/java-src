package pkggetmainstringargs;
/**
 * 编写一个程序，实现从命令行参数中输入一字符串，要求此字符串的格式为”xxxxx,yyyy,zzzz,hhhh”，
 * 即字符串用逗号隔开。然后处理字符串中各逗号之间的部分并输出。并要求每一隔开的字符串中如果出现字母”s”，
 * 进行进行用”*”屏蔽。
 * @author SQZS
 *
 */
public class CountChar {
	private static int Count;

	public int CountOfMethod1(char c, String[] args) {
		Count = 0;
		String temp = args[0];
		for (int i = 0; i < temp.length(); i++) {
			char ch = temp.charAt(i);
			if (c == ch) {
				Count++;
			}
		}
		return Count;
	}

	public int CountOfMethod2(char c, String[] args) {
		Count = 0;
		String temp = args[0];
		char[] ch = temp.toCharArray();
		for (char ctemp : ch) {
			if (c == ctemp) {
				Count++;
			}
		}
		return Count;
	}

	public int CountOfMethod3(char c, String[] args) {
		Count = 0;
		String temp = args[0];
		String ctos = String.valueOf(c);
		for (int i = 0; i < temp.length(); i++) {
			if (ctos.equals(temp.substring(i, i + 1))) {
				Count++;
			}
		}
		return Count;
	}
	public static String[] handleString(char c,String[] args){
		String[] split = args[0].split(""+c);
		for (int i = 0; i < split.length; i++) {
			split[i] = split[i].replace('s', '*');
		}
		return split;
	}
	public static void main(String[] args) {
		String[] str = handleString(',', args);
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}
}
