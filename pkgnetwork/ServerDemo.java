package pkgnetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(8080);
			Socket s = ss.accept();
			System.out.println(s.getInetAddress().getHostAddress());
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);

//			InputStream in = s.getInputStream();
//			byte[] buf = new byte[1024];
//			int len = in.read(buf);
//			System.out.println(new String(buf, 0, len));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			System.out.println("s1");
			String temp = null;
			while((temp = br.readLine()) != null){
				System.out.println(temp);
				if(temp.contains("Language")){
					System.out.println("s2");
					break;
				}
			}

			System.out.println("s3");
			out.println("<html>");
			out.println("<body>");
			out.println("<font color = 'red' size = '7' >output</font>");
			out.println("</body>");
			out.println("</html>");

			// BufferedReader br = new BufferedReader(new
			// InputStreamReader(s.getInputStream()));
			// System.out.println(br.readLine());
			// s.close();
			// ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * GET / HTTP/1.1 
	 * Host: 192.168.1.101:12306 DNT: 1 
	 * Connection: keep-alive
	 * Accept: text/html,application/xhtml+xml,application/xml;q=0.9;q=0.8
	 * User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2)
	 * AppleWebKit/537.74.9 (KHTML, like Gecko) Version/7.0.2 Safari/537.74.9
	 * Accept-Language: zh-cn Accept-Encoding: gzip, deflate Cache-Control:
	 * max-age=0
	 * 
	 * 
	 */

}
