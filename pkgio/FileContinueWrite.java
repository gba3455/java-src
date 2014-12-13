package pkgio;

import java.io.FileWriter;
import java.io.IOException;

/*
 * 对已有文件的数据续写
 */
public class FileContinueWrite {

	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			//传递一个true参数,表示不覆盖已有的文件,并在
			//已有文件的末尾处进行数据的续写
			fw = new FileWriter("pkgiodemo.txt", true);
			fw.write("hehe \r\n");//\n在linux下代表换行,在winodws下要\r\n才可以换行.
			fw.write("续写");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
