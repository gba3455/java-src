package pkgnetwork;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1:tcp分客户端和服务端.
 * 2:客户端对应的对象是Socket
 * 服务端对应的对象是ServerSocket
 * 
 * 客户端:socket对象在建立时,就可以去连接指定主机
 * 因为tcp是面向连接的,所以在建立socket服务时,就
 * 要有服务端存在,并连接成功.形成通路后,在该通道进行数据的传输.
 * 
 * 1:创建socket服务,并指定要连接的主机和端口.
 * 
 * @author SQZS
 *
 */
public class TcpDemo {
}
class TcpSend{
	public static void main(String[] args) throws Exception {
		//1:创建客户端得socket服务,指定目的主机和端口//建立成功就会有个socket流.包含输入流和输出流.
		Socket s = new Socket("192.168.1.101", 10010);
		//2:为了发送数据,应该获取socket流中的输出流.
		OutputStream os = s.getOutputStream();
		os.write("client".getBytes());
		s.close();
	}
}
/**
 * 服务端:
 * 1:建立服务端的socket服务.通过ServerSocket
 * 并监听一个端口.
 * 2:获取连接过来的客户端对象.
 * 通过serverSocket的accpet方法.所以这个方法是阻塞式的.
 * 3:客户端如果发过来数据那么,服务端要使用对应的客户端对象,并获取到该
 * 客户端对象的读取流来读取发过来得数据.
 * 4:关闭服务端.(可选);
 * @author SQZS
 *
 */
class TcpRece{
	public static void main(String[] args) throws Exception {
//		1:建立服务端的socket服务,并就爱你他一个端口.
		ServerSocket ss = new ServerSocket(10010);
		//2:通过accept方法获取连接过来的客户端对象.
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "........connected");
		//3:获取客户端发送过来的数据,那么要使用客户端对象的读取流来读取数据.
		InputStream is = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = is.read(buf);
		String data = new String(buf,0,len);
		System.out.println(data);
		//4://关闭客户端.
		s.close();
		//5:关闭服务端(可选)
//		ss.close();
		
	}
}