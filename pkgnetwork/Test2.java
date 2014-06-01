package pkgnetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Test2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {

			@Override
			public void run() {

				DatagramSocket ds = null;
				try {
					ds = new DatagramSocket(1024);
				} catch (SocketException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				while (true) {
					try {
						byte[] buf = new byte[1024];
						DatagramPacket dp = new DatagramPacket(buf, buf.length);
						ds.receive(dp);
						String ip = dp.getAddress().getHostAddress();
						int port = dp.getPort();
						String data = new String(dp.getData(),0,dp.getData().length);
						System.out.println(ip + ":" + port + "=" + data);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				DatagramSocket ds = null;
				try {
					ds = new DatagramSocket();
				} catch (SocketException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					String line = null;
					while (true) {
						BufferedReader br = new BufferedReader(
								new InputStreamReader(System.in));
						line = br.readLine();
						if(line.equals("886")){
							break;
						}
						byte[] bufsend = line.getBytes();
						DatagramPacket dp = new DatagramPacket(bufsend,
								bufsend.length,
								InetAddress.getByName("192.168.1.100"), 8888);
						ds.send(dp);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();
	}

}
