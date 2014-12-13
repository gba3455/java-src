package pkgnetwork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class UserLogin {
	public static void SendByBufferedWtr(Socket s, String msg)
			throws IOException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				s.getOutputStream()));
		System.out.println("c1");
		out.write(msg);
		out.newLine();
		out.flush();
	}

	public static void SendByPrintWtr(Socket s, String msg) throws IOException {
		PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
		pw.println(msg);
	}
}

class LogClient {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("126.125.134.90", 12315);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String input = null;
			while ((input = br.readLine()) != null) {
				// UserLogin.SendByBufferedWtr(s, input);
				UserLogin.SendByPrintWtr(s, input);
				System.out.println("c2");
				BufferedReader in = new BufferedReader(new InputStreamReader(
						s.getInputStream()));
				System.out.println("c3");
				String feedBack = in.readLine();
				System.out.println(feedBack);
				if (feedBack.contains("欢迎")) {
					break;
				}
				System.out.println("c4");
			}
			br.close();
			s.close();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

class LogServer {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(12315);
			while (true) {
				Socket s = ss.accept();
				new Thread(new SerThread(s)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static boolean isMyUser(String user) {
		boolean flag = false;
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"./pkgnetwork/database.txt"));
			String name = null;
			// while((name = br.readLine()) != null){
			// if(user.equals(name)){
			// return true;
			// }else{
			// return false;
			// }
			// }
			while ((name = br.readLine()) != null) {
				if (user.equals(name)) {
					flag = true;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

	static class SerThread implements Runnable {
		Socket s = null;

		public SerThread(Socket s) {
			this.s = s;
		}

		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						s.getInputStream()));
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
						s.getOutputStream()));
				String in = null;
				while ((in = br.readLine()) != null) {
					System.out.println("s1");
					if (isMyUser(in)) {
						System.out.println(in + ",已登录");
						out.write(in + ",欢迎观临");
						out.newLine();
						out.flush();
						System.out.println("s2");
					} else {
						System.out.println(in + "尝试登录");
						out.write(in + ",改用户不存在");
						out.newLine();
						out.flush();
						System.out.println("s3");
					}
					System.out.println("s4");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
