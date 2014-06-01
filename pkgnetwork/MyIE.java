package pkgnetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * GET / HTTP/1.1 
 * Host: 192.168.1.101:12306 DNT: 1 
 * Connection: keep-alive
 * Accept: text/html,application/xhtml+xml,application/xml;q=0.9;q=0.8
 * User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2)
 * AppleWebKit/537.74.9 (KHTML, like Gecko) Version/7.0.2 Safari/537.74.9
 * Accept-Language: zh-cn 
 * Accept-Encoding: gzip, deflate Cache-Control:
 * max-age=0
 * 												←这2个空行一定要.告诉服务器,http头已经结束.
 * 												←这2个空行一定要.告诉服务器,http头已经结束.
 */
public class MyIE {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("192.168.1.101", 8080);
			
			PrintWriter out = new PrintWriter(s.getOutputStream(),true);
			System.out.println("1");
			
			out.println("GET / HTTP/1.1");
			out.println("Host: 192.168.1.101:12306 DNT: 1 ");
			out.println("Connection: keep-alive");
			out.println("Accept:*/*");
			out.println("Accept-Language: zh-cn");
			
			out.println();//这2个空行一定要.告诉服务器,http头已经结束.
			out.println();
			
			System.out.println("2");
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = null;
			while((str = br.readLine()) != null){
				System.out.println(str);
			}
			System.out.println("3");
			
			s.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
