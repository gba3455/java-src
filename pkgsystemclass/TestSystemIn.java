package pkgsystemclass;

import java.io.*;

public class TestSystemIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "";
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(ir);
		System.out.println("ctrl + z to exit");
		try {
			s = in.readLine();
			while (s != null) {
				System.out.println(s);
				if (s.equals("3")) {
					// break;
					s = null;
				} else {
					s = in.readLine();
				}
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
