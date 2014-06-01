package pkgio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * 用于记录应用程序运行次数
 * 如果使用次数已到,那么给出注册提示.
 * 
 * 思路:计数器,可是计数器定义在程序中,随着程序的运行而存在于
 * 内存中,并自增,可是随着该应用程序的退出,该计数器也在内存中消失乐.
 * 
 * 下一次再启动程序,又重新开始重0计算.
 * 
 * 程序即使结束,该计数器的值也存在.
 * 下一次程序启动会先加载该计数器的值并加1再重新存储起来.
 * 所以要建立一个配置文件,用于记录该软件的使用次数.
 * 
 * 该配置文件使用键值对的形式.这样便于阅读数据,并操作数据.
 * 
 * 键值对数据是map集合.数据是以文件形式存储,使用IO技术.
 * 那么map+io -->properties.
 * 
 * 配置文件可以实现应用程序数据的共享.
 */
public class RunCountByProp {
	public static void main(String[] args) {
		Properties prop = new Properties();
		File f = new File("count.ini");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			fis = new FileInputStream(f);
			prop.load(fis);
			int count = 0;
			String time = prop.getProperty("time");
			if(time != null){
				count = Integer.parseInt(time);
				if(count > 3){
					System.out.println("unLock!");
					return ;
				}
			}
			count++;
			prop.setProperty("time", count + "");
			fos = new FileOutputStream(f);
			prop.store(fos, null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
