package pkgnetwork;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * tcp客户端和服务端的互访.
 * 需求:客户端给服务端发送数据,服务端收到后,给客户端反馈信息.
 * 
 * 客户端:
 * 1:建立socket服务.指定要连接的主机和端口.
 * 2:获取socket流中的输出流.将数据写到该流中,通过网络发送给服务端.
 * 3:获取socket流中的输入流.讲服务端反馈的数据获取到,并打印.
 * 4:关闭客户端资源.
 * @author SQZS
 *
 */
public class TcpDemo2 {

}
class TcpClient{
	public static void main(String[] args) throws Exception {
		 Socket s = new Socket("192.168.1.101", 10015);
		 
		 
		 OutputStream out = s.getOutputStream();
		 
		 out.write("client".getBytes());
		 
		 InputStream in = s.getInputStream();
		 
		 byte[] buf = new byte[1024];
		
		 int len = in.read(buf);
		 
		 System.out.println(new String(buf,0,len));
		 
		 s.close();
	}
}
class TcpServer{
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10015);
		
		byte[] buf = new byte[1024];
		
		Socket s = ss.accept();
		
		System.out.println(s.getInetAddress().getHostAddress() + "connected....");
		
		InputStream in = s.getInputStream();
		
		int len = in.read(buf);
		
		System.out.println(new String(buf,0,len));
	
		OutputStream out = s.getOutputStream();
		
		out.write("Server feedback".getBytes());
		
		s.close();
		
		ss.close();
	}
}