package pkgnetwork;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 需求,通过udp传输方式,将一段文字数据发出去
 * 1:建立updsocket服务.
 * 2:提供数据,并将数据封装到数据包中
 * 3:通过socket服务的发送功能,将数据包发出去.
 * 4:关闭资源.
 * @author SQZS
 *
 */
public class UdpDemo {

	public static void main(String[] args) throws Exception {
		//1:创建udp服务.通过DategrameSocket对象.
		DatagramSocket ds = new DatagramSocket(8888);
		//2:确定数据,并封装成数据包.
		byte[] buf = "需求,通过udp传输方式,将一段文字数据发出去".getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), 10000);
		//3:通过socket服务,通过send方法.发送.
		ds.send(dp);
		//4:关闭资源
		ds.close(); 
	}

}
/**
 * 需求:定义一个应用程序,用于接收udp协议传输的数据并处理.
 * 1:定义UDPsocket服务.通常会监听一个端口,给这个程序一个数字标示.
 * 方便明确哪个数据过来该程序可以处理.
 * 2:定义一个数据包,存储接收到的字节数据.
 * 3:通过socket服务的receive方法降收到的数据存入已定义好的数据包中.
 * 4:通过数据包对象的特有功能,将这些不同的数据取出.
 * 5:关闭资源.
 * @author SQZS
 *
 */
class UdpRece {

	public static void main(String[] args) throws Exception {
			//1:创建updsocket服务.建立端点.
			DatagramSocket ds = new DatagramSocket(10000);
		while(true){
			//2:定义数据包.用于存储数据.
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			//3:通过服务的receive方法将收到的数据存入数据包中.//阻塞式方法
			ds.receive(dp); 
			//4:通过数据包的方法读取其中的数据.
			String ip = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(),0,dp.getData().length);
			int port = dp.getPort();
			System.out.println(ip + ":" + port + "-" + data);
		}
		//5:关闭资源.
//		ds.close();
	}

}