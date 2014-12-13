package pkgio;

import java.io.IOException;
import java.io.InputStream;

public class MyBufferedInputStream {
	private InputStream in = null;
	private byte[] buf = new byte[1024];
	private int pos = 0 , counter = 0;
	public MyBufferedInputStream(InputStream in) {
		this.in = in;
	}
	//一次读一个字节,从缓冲区(字节数组)获取.
	public int MyRead() throws IOException{
		//通过in对象读取硬盘上数据,并存在buf里
			if(counter == 0){
				counter = in.read(buf);
				if(counter < 0){
					return -1;
				}
				pos = 0;
				byte b = buf[pos];
				counter--;
				pos++;
				return b&255;
			}else if(counter > 0){
				byte b = buf[pos];
				counter--;
				return b&255;
			}
		return -1;
	}
	public void MyClose() throws IOException{
		in.close();
	}
}
/*
mp3文件 2进制存放
11111111-11111111111110101100000011111101001

byte:-1 ----> int :-1;
00000000 00000000 00000000 11111111 255
11111111 11111111 11111111 11111111

11111111 -->提升成一个int类型.还是-1.是-1的原因是因为在8个1前面补得全是1导致的.
那么我只要在前面补0,既可以保留原字节数据不变,又可以避免-1的出现.
补0方法.

 11111111 11111111 11111111 11111111
&00000000 00000000 00000000 11111111
-------------------------------------
 00000000 00000000 00000000 11111111
 
0000-0001
1111-1110
0000-0001
1111-1111  -1
*/