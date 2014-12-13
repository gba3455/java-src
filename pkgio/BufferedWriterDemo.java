package pkgio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 缓冲区的出现是为了提高流的操作效率而出现的.
 * 所以在创建缓冲区之前,必须要先有流对象.
 */
public class BufferedWriterDemo {

	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bufw = null;
		try {
			fw = new FileWriter("/users/sqzs/desktop/buf.txt");
			//为了提高字符写入流效率,加入了缓存技术.
			//缓存技术的原理:里面封装了数组,先把数据都存起来,再一次性的写出去.
			//只要将需要被提高效率的流对象作为参数传递给缓冲区的构造函数即可.
			bufw = new BufferedWriter(fw);
			for (int i = 0; i < 5; i++) {
				bufw.write("ab\r\ncde");
				bufw.newLine();//是一个跨平台的换行方法,其实就等于bufw.write("\r\n");
				//记住,只要用到缓冲区,就要记得刷新flush
				bufw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fw != null){
				try {
					//其实关闭缓冲区,就是在关闭缓冲区中的流对象.fw
					bufw.close();
//					fw.close();//所以这个不需要乐.
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
