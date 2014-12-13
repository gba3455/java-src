package pkgfinalproject.pkgutils;

import java.io.FileWriter;
import java.io.IOException;

public class OutPutContent {
	public static boolean OutPut(String str) {

		FileWriter fw = null;
		try {
			fw = new FileWriter(StaticTools.MACDESKTOP);
			fw.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
}
