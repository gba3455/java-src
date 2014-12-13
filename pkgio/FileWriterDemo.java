package pkgio;
import java.io.*;
/**
 * 字符流和字节流:
 * 字节流的2个基类:
 * InputStream OUtputStream
 * 
 * 字符流2个基类:
 * Reader Writer
 * 
 * 既然IO流是用于操作数据的,
 * 那么数据的最常见体现形式是:文件
 * 
 * 需求:在硬盘上,创建一个文件并写入一些文字数据.
 * 
 * 找到一个专门用于操作文件的Writer子类对象.FileWriter 
 * 后缀名是父类名.前缀名是该流对象的功能
 * @author SQZS
 *
 * 标准的专业IO异常处理方式.
 */
public class FileWriterDemo {

	public static void main(String[] args) {
		//在外面建立引用,在里面初始化
		FileWriter fw = null;
		try {
			//创建一个FileWriter对象,改对象一倍初始化就必须要明确被操作的文件
			//而且改文件会被创建到指定目录下,如果该目录下一有同名文件,将被覆盖.
			//其实该步就是在明确数据要存放的目的地.
			fw = new FileWriter("pkgiodemo.txt");
			//调用write方法,讲字符串写入到流中
			fw.write("abcde");
			//刷新流对象中的缓冲中的数据.
			//将数据刷到目的地中.
//			fw.flush();
			//关闭流资源.但是关闭之前会刷新一次内部的缓冲中的数据
			//讲数据刷到目的地中
			//和flush区别:flush刷新后,流可以继续使用,close刷新后,会将流关闭.
			//java调用windows系统中的写动作,也就是流资源,其实java本身是不能往硬盘写
			//数据的,所以要靠window系统来写数据.这些调用方式都是在使用windows的资源
			//所以使用完后要释放出来.所以要close
			fw.close();//掉用close会自动调用一次flush
			
//			fw.write("hah");
		} catch (IOException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}finally{
			try {
				if (fw != null) {//如果路径出错,创建失败,fw为空,finally必须执行,没这句if的话,close会报空指针异常
					fw.close();//关闭资源一定要执行,所以放到finally里.
					//如果有多个,就要多次关闭.
				}
			} catch (IOException e) {
				System.out.println(e.toString());
				e.printStackTrace();
			}
		}
	}

}
