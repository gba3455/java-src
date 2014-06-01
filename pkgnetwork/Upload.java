package pkgnetwork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Upload {

}
class TextClient{
	public static void main(String[] args) throws IOException {
		Socket s;
		try {
			s = new Socket("192.168.1.100", 10086);
			try {
				BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/SQZS/Desktop/1.txt"),"UTF-8"));
				PrintWriter bufpw = new PrintWriter(s.getOutputStream(),true);
				
				//加标记方法1
//				long endFlagByTime = System.currentTimeMillis();
//				bufpw.println(endFlagByTime);
				
				//加标记方法2
//				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
//				dos.writeLong(endFlagByTime);
				
				String line = null;
				while((line = buf.readLine()) != null){
					bufpw.println(line);
				}
//				bufpw.println(endFlagByTime);//结束标记 方法1
//				bufpw.println(endFlagByTime);//方法2
				
				//加标记方法3
				s.shutdownOutput();//关闭客户端得输出流,相等于给流中加一个结束标记-1
				
				BufferedReader feedBack = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String str = feedBack.readLine();
				System.out.println(str);
				
				bufpw.close();
				s.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class TextServer{
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(10086);
			Socket s = ss.accept();
			System.out.println(s.getInetAddress().getHostAddress());
			BufferedReader buf = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter pw = new PrintWriter(new FileOutputStream("/Users/SQZS/Desktop/未命名文件夹/copy.txt"),true);
			
			//加标记方法1
//			String endFlagByTime = buf.readLine();
			
			//加标记方法2
//			DataInputStream dis = new DataInputStream(s.getInputStream());
//			Long endFlagByTime = dis.readLong();
			
			String line = null;
			while((line = buf.readLine()) != null){
//				if(line.equals(endFlagByTime)){
//					break;
//				}
//				if(endFlagByTime.toString().equals(line)){
//					break;
//				}
				pw.println(line);
			}
			
			PrintWriter pwBack = new PrintWriter(s.getOutputStream(),true);
			pwBack.println("Upload Successful");
//			BufferedWriter br = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//			br.write("Upload Successful");
//			br.newLine();
//			br.flush();
			
//			pw.close();
//			s.close();
//			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class PicClient{
	/**
	 * 上传图片.客户端:图片不能用字符流
	 * 1:服务端点.
	 * 2:读取客户端图片数据
	 * 3:通过socket输出流将数据发给服务端.
	 * 4:读取服务端反馈信息.
	 * 关闭.
	 */
	public static void main(String[] args) {
		try {
			Socket s = new Socket("192.168.1.101", 10086);
			File file = new File("/Users/SQZS/Desktop/1.jpg");
			
			if(!(file.exists() && file.isFile())){
				System.out.println("文件不存在或不是文件");
				return ;
			}
			
			if(file.length() > 1024 * 1024 * 5){//5M
				System.out.println("文件大小超过5M");
				return ;
			}
			
			if(!file.getName().endsWith(".jpg")){
				System.out.println("非jpg文件");
				return ;
			}
			
			FileInputStream fis = new FileInputStream(file);
			
			OutputStream osw = s.getOutputStream();
			
			byte[] buf = new byte[1024];
			
			int len = 0;
			
			while((len = fis.read(buf)) != -1){
				
				osw.write(buf,0,len);
				
			}
			System.out.println("test");
			
			s.shutdownOutput();
			
			InputStream in = s.getInputStream();
			
			byte[] bufIn = new byte[1024];
			
			int num = in.read(bufIn);
			
			System.out.println(new String(bufIn,0,num));
//			System.out.println(isr.read());
			
			fis.close();
			
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

/**
 * 这个服务端有个局限性,当A客户端连接上以后,被服务端获取到.服务端执行具体流程.
 * 这时B客户端连接,只有等待.
 * 因为服务端还没有处理完A客户端得请求.还没有循环回来执行下一次accpet方法
 * 所以暂时获取不到B客户端对象.
 * 
 * 那么为了能让多个客户端同时并发访问服务端,那么服务端最好
 * 就是将每个客户端封装到一个单独的线程中,这样就可以同时处理
 * 多个客户端请求.
 * 
 * 如何定义线程:
 * 只要明确了每一个客户端要在服务端执行的代码.将该代码存入
 * run方法中.
 * @author SQZS
 *
 */

class PicThread implements Runnable{
	private Socket s;
	public PicThread(Socket s) {
		this.s = s;
	}
	@Override
	public void run() {
		InputStream in;
		int count = 1;
		try {
			String ip = s.getInetAddress().getHostAddress();
			System.out.println(ip);
			in = s.getInputStream();
			File file = new File("/Users/SQZS/Desktop/未命名文件夹/" + ip + ".jpg");
			
			while(file.exists()){
				file = new File("/Users/SQZS/Desktop/未命名文件夹/" + ip + "(" + count++ + ")" + ".jpg");
			}
			
			FileOutputStream fos = new FileOutputStream(file);
			
			byte[] buf = new byte[1024];
			
			int len = 0;
			
			while((len = in.read(buf)) != -1){
				fos.write(buf,0,len);
			}
			
			OutputStream os = s.getOutputStream();
			
			os.write("上传成功".getBytes());
			
			fos.close();
			
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class PicServer{
public static void main(String[] args) {
		ServerSocket ss;
		try {
			ss = new ServerSocket(10086);
			while(true){
				Socket s = ss.accept();
				new Thread(new PicThread(s)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
}
}
//class PicServer{
//	public static void main(String[] args) {
//		try {
//			ServerSocket ss = new ServerSocket(10010);
//			
//			Socket s = ss.accept();
//			
//			InputStream in = s.getInputStream();
//			
//			FileOutputStream fos = new FileOutputStream("/Users/SQZS/Desktop/未命名文件夹/1.jpg");
//			
//			byte[] buf = new byte[1024];
//			
//			int len = 0;
//			
//			while((len = in.read(buf)) != -1){
//				fos.write(buf,0,len);
//			}
//			
//			OutputStream os = s.getOutputStream();
//			
//			os.write("上传成功".getBytes());
//			
//			fos.close();
//			
//			s.close();
//			
//			ss.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//}