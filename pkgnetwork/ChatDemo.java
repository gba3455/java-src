package pkgnetwork;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.management.RuntimeErrorException;

/**
 * 编写一个聊天程序.
 * 有收数据的部分和发数据的部分.这2个部分同时执行.
 * 因为收和发的动作是不一致的,所以定义2个run方法.
 * 而且这2个方法要封装到不同的类中.
 * @author SQZS
 *
 */
class Send implements Runnable{
	private DatagramSocket ds;
	Send(DatagramSocket ds){
		this.ds = ds;
	}
	@Override
	public void run() {
		try {
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			while((line = bufr.readLine()) != null){
				if(line.equals("886")){
					break;
				}
				byte[] buf = line.getBytes();
				
				DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("196.168.1.100"),10002);
				
				ds.send(dp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException( "发送端失败");
		}
	}
}

class Rece implements Runnable{
	private DatagramSocket ds;
	Rece(DatagramSocket ds){
		this.ds = ds;
	}
	@Override
	public void run() {
		try {
			while(true){
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				
				ds.receive(dp);
				
				String ip = dp.getAddress().getHostAddress();
				
				String data = new String(dp.getData(),0,dp.getData().length);
				
				System.out.println(ip + ":" + data);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException( "接受端失败");
		}
	}
}

public class ChatDemo {

	public static void main(String[] args) throws SocketException {
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receSocket = new DatagramSocket(10002);
		
		new Thread(new Send(sendSocket)).start();
		new Thread(new Rece(receSocket)).start();
	}

}
