package pkgnetwork;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress i = InetAddress.getLocalHost();
		System.out.println(i.toString());
		System.out.println("address:" + i.getHostAddress());
		System.out.println("name:" + i.getHostName());
		
		InetAddress ia = InetAddress.getByName("www.baidu.com");
		System.out.println(ia.getHostAddress());
		
		InetAddress[] iarr = InetAddress.getAllByName("www.baidu.com");
		for (InetAddress inetAddress : iarr) {
			System.out.println(inetAddress.getHostAddress());
		}
		
	}

}
