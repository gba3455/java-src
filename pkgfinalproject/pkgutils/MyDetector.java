package pkgfinalproject.pkgutils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.mozilla.universalchardet.UniversalDetector;
public class MyDetector {
	  public static void main(String[] args) throws java.io.IOException {
	    byte[] buf = new byte[4096];
	    String fileName = args[0];
	    java.io.FileInputStream fis = new java.io.FileInputStream(fileName);

	    // (1)
	    UniversalDetector detector = new UniversalDetector(null);

	    // (2)
	    int nread;
	    while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
	      detector.handleData(buf, 0, nread);
	    }
	    // (3)
	    detector.dataEnd();

	    // (4)
	    String encoding = detector.getDetectedCharset();
	    if (encoding != null) {
	      System.out.println("Detected encoding = " + encoding);
	    } else {
	      System.out.println("No encoding detected.");
	    }

	    // (5)
	    detector.reset();
	  }
	  
	  public static String getProbablyEncode(String filePath) throws IOException{
		  byte[] buf = new byte[4096];
		    String fileName = filePath;
		    UniversalDetector detector = null;
		    java.io.FileInputStream fis;
			try {
				fis = new java.io.FileInputStream(fileName);
			    // (1)
			    detector = new UniversalDetector(null);

			    // (2)
			    int nread;
			    while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
			      detector.handleData(buf, 0, nread);
			    }
			    // (3)
			    detector.dataEnd();

			    // (4)
			    String encoding = detector.getDetectedCharset();
			    if (encoding != null) {
			      System.out.println("Detected encoding = " + encoding);
			      return encoding;
			    } else {
			      System.out.println("No encoding detected.");
			      return "No encoding detected.";
			    }

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{

			    // (5)
			    detector.reset();
			}
			return "Unknow Error";

	  }
}
