package pkgnetwork;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.sina.com/");
			
			System.out.println("protocal:" + url.getProtocol());
			System.out.println("host:" + url.getHost());
			System.out.println("getPort:" + url.getPort());
			System.out.println("getPath:" + url.getPath());
			System.out.println("getFile:" + url.getFile());
			System.out.println("getQuery:" + url.getQuery());
			
			int port = url.getPort();
			if(port == -1){
				port = 80;
			}
			
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			System.out.println(new String(buf,0,len));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
