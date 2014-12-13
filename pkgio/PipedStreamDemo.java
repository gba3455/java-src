package pkgio;
import java.io.*;
class PipedRead implements Runnable{
	PipedInputStream pis = null;
	public PipedRead(PipedInputStream in){
		this.pis = in;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
		byte[] buf = new byte[1024];
		int len = pis.read(buf);
		String s = new String(buf,0,len);
		System.out.println(s);
		}catch(Exception e){
			throw new RuntimeException("ex");
		}
	}
}
class PipedWrite implements Runnable{
	PipedOutputStream pos = null;
	public PipedWrite(PipedOutputStream out){
		this.pos = out;
	}
	public void run(){
		try{
//			Thread.sleep(6000);
			pos.write("lai le".getBytes());
			pos.flush();
		}catch(Exception e){
			throw new RuntimeException("ex");
		}
	}
}
public class PipedStreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream();
		try {
			pis.connect(pos);
			new Thread(new PipedRead(pis)).start();
			new Thread(new PipedWrite(pos)).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
