package pkgnetwork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 需求:建立一个文本转换服务器.
 * 客户端给服务端发送文本,服务端降文本转成大写,再返回给客户端.
 * 而且客户端可以不断的进行文本转换,当客户端输入over时,转换结束.
 * @author SQZS
 *客户端:既然是操作设备上的数据,那么就可以使用io技术,并按照io的操作规律来思考.
 *源:键盘输入.
 *目的:网络设备,网络输出流.
 *而且操作的是文本数据.可以选择字符流.
 *
 *步骤:
 *1:建立服务.
 *2:获取键盘输入.
 *3:将数据发给服务端.
 *4:获取服务端返回的数据.
 *5:结束,关闭资源.
 *
 *都是文本数据,可以使用字符流进行操作,同时提高效率,加入缓冲.
 *
 *现象:客户端和服务端都在莫名得等待.
 *因为客户端和服务端都有阻塞式的方法.这些方法没有读到结束标记.那么就会一直等.
 *而导致2端都在等待.
 */
public class TransTextDemo {

}
//class TransClient{
//	static Socket s;
//	public static void main(String[] args) throws Exception {
//		s = new Socket("192.168.1.100",10015);
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				while(true){
//					try {
//						send();
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}).start();
//		
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				while(true){
//					try {
//						rece();
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}).start();
//	}
//	private static void send() throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//		String line = null;
//		while((line = br.readLine()) != null){
//			bufOut.write(line);
//			bufOut.newLine();
//			bufOut.flush();
//			System.out.println("send success");
//		}
//	}
//	private static void rece() throws Exception{
//		System.out.println("rece start");
//		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
//		String line = null;
//		while((line = bufIn.readLine()) != null){
//			System.out.println(line);
//		}
//	}
//}
//
//class TransServer{
//	static Socket s = null;
//	static ServerSocket ss = null;
//	static BufferedReader bufIn = null;
//	static BufferedWriter bufOut = null;
//	public static void main(String[] args) throws Exception {
//		ss = new ServerSocket(10015);
//		s = ss.accept();
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				while(true){
//					try {
//						rece();
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		}).start();
//		Thread.sleep(1000);
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				while(true){
//						try {
//							send();
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				}
//		}).start();
//		
//	}
//	private static void rece() throws Exception{
//		bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
////		String line = null;
////		while((line = bufIn.readLine()) != null){
////		System.out.println("ser rece " + line);
//		System.out.println(bufIn.readLine() + "!");
//		Thread.sleep(10);
////		}
//	}
//	private static void send() throws Exception{
//		System.out.println(bufIn.readLine() + "!");
//		bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//		String line = null;
//		System.out.println("ser send start" + bufIn.readLine());
//		while((line = bufIn.readLine()) != null){
//		bufOut.write(line.toUpperCase());
//		bufOut.newLine();
//		bufOut.flush();
//		System.out.println("ser send end");
//		}
//	}
class TransClient{
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("192.168.1.100",11111);
		//定义读取键盘数据的流对象
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		//定义目的,将数据写入到soecket输出流.发给服务端
//		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		PrintWriter pr = new PrintWriter(s.getOutputStream(),true);
		//定义一个socket读取流,读取服务端返回的大写信息.
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = null;
		while((line = bufr.readLine()) != null){
			if("over".equals(line)){
				break;
			}
			pr.println(line);
//			bufOut.write(line);
//			bufOut.newLine();
//			bufOut.flush();
			
			String str = bufIn.readLine();
			System.out.println(str);
		}
		bufr.close();
		s.close();
	}
}

/**
 * 服务端:
 * 源:socket读取流.
 * 目的:socket输出流.
 * 都是文本,装饰.
 * 
 * PrintWriter 既可以处理字节流也可以处理字符流,而且可以自动刷新和换行.
 * @author SQZS
 *
 */
class TransServer{
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(11111);
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "connected...");
		//读取socket读取流中的数据.
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//目的,socket输出流.将大写数据写入到socket输出流,并发送给客户端.
//		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		PrintWriter pr = new PrintWriter(s.getOutputStream(),true);
		String line = null;
		while((line = bufIn.readLine()) != null){
			pr.println(line.toUpperCase());
//		bufOut.write(line.toUpperCase());
//		bufOut.newLine();
//		bufOut.flush();
		}
		s.close();
		ss.close();
	}
}
