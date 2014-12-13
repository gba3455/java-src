package pkgregex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 网页爬虫(蜘蛛)
 */
public class NetSpider {
	public static void main(String[] args) throws IOException {
//		NetSpiderBug("http://tieba.baidu.com/p/2720132008");
		URL url = new URL("http://www.baidu.com/#wd=留邮箱&rsv_spt=1&issp=1&rsv_bp=0&ie=utf-8&tn=baiduhome_pg&rsv_sug3=1&rsv_sug4=480&rsv_sug1=1&rsv_sug2=0&inputT=6");
		URLConnection conn = url.openConnection();
		BufferedReader bufr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String str = null;
		//<a href="http://tieba.baidu.com/f?kw=&fr=wwwt"
		String regex = "[<a href=]\"{1}+[a-zA-Z]+[:]//[a-zA-Z]+(\\.\\w+)+\\/[^\"]+";
		Pattern p = Pattern.compile(regex);
		Matcher m = null;
		while((str = bufr.readLine()) != null){
			m = p.matcher(str);
			while(m.find()){
			System.out.println(m.group());
			}
		}
	}

	private static void NetSpiderBug(String urlAdd) throws MalformedURLException,
			IOException {
		URL url = new URL(urlAdd);
		URLConnection conn = url.openConnection();
		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		String line = null;
		String regex = "\\w+@\\w+(\\.\\w+)+";
		Pattern p = Pattern.compile(regex);
		Matcher m = null;
		int count = 0;
		while ((line = bufr.readLine()) != null) {
			m = p.matcher(line);
			while (m.find()) {
				count++;
				System.out.println(m.group());
			}
		}
		System.out.println(count);
	}
}
