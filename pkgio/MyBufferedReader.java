package pkgio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
/**
 * 装饰和继承的区别
 * 继承:
 * ①
 * MyReader//专门用于读取数据的类
 * 		|--MyTextReader
 * 			|--MyBufferTextReader
 * 		|--MyMediaReader
 * 			|--MyBufferMediaReader
 * 		|--MyDataReader
 * 			|--MyBufferDataReader
 * ②
 * class MyBufferReader{
 * 		MyBufferReader(MyTextReader text){
 * 		}
 * 		MyBufferReader(MyMediaReader media){
 * 		}
 * }
 * 上面这个类扩展性很差.
 * 找到其参数的共同类型.通过多态的形式,可以提高扩展性.
 * ③
 * class MyBufferReader extends MyReader{
 * 		private MyReader r;
 * 		MyBufferReader(MyReader r){
 * 		}
 * }
 * ④
 * MyReader
 * 	|--MyTextReader
 * 	|--MyMediaReader
 * 	|--MyDataReader
 * 	|--MyBufferReader
 * 
 * 装饰模式比继承要灵活.避免了继承提醒臃肿.
 * 而且降低了类与类之间的关系.
 * 
 * 装饰类因为是增强已有对象,具备的功能和已有对象的功能是相同的.
 * 只不过提供了更强的功能.所以装饰类和被装饰类通常都属于一个体系中.
 * 
 * 建议继承不要写得过多,不要以继承为主,因为如果仅仅为了其中的某种功能
 * 而产生子类,体系非常臃肿.可以通过装饰的模式来扩展他的功能.
 * 如果觉得功能不够,直接写一个装饰类,把你的功能导入进来加强.
 * @author SQZS
 *
 */
/*
 * 明白了BufferedReader类中特有方法readLine的原理后,
 * 可以自定义一个类中包含一个功能和readLine一直的方法.
 * 来模拟一下BufferedReader
 */
public class MyBufferedReader extends Reader{
	/*
	 * BufferedReader里面实际上还是调用read来读取,是对FileReader的增强.
	 * 把被增强的对象传给增强类,因为FileReader里面只有读一个的方法.
	 * 所以MyBufferedReader是对FileReader的增强.
	 * 这种设计模式叫做装饰设计模式.
	 * 
	 * 装饰设计模式:
	 * 当想要对已有的对象进行功能增强时,可以定义类,将已有对象传入,
	 * 基于已有的功能,并提供加强功能.那么之定义的该类就称为装饰类.
	 */
	private Reader r;
	public MyBufferedReader(Reader r) {
		this.r = r;
	}
	//可以一次读一行数据的方法.
	public String MyReadLine() throws IOException{
		//定义一个临时容器,原BufferedReader封装的是字符数组.
		//这里定义一个StringBuilder容易.因为最终还是要将数据变成字符串
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		while((ch = r.read()) != -1){
			if(ch == '\r'){
				continue;
			}
			if(ch == '\n'){//flag1
				return sb.toString();
			}else{
				sb.append((char)ch);
			}
		}
		if(sb.length() != 0){//如果文本最后一行没有回车符,则flag1处不执行,所以最后一行内容没返回回来,所以判断如果里面有内容,再返回一下.
			return sb.toString();
		}
		return null;
	}
	public void myClose() throws IOException{
		r.close();
	}
	
	public static void main(String[] args) {
		FileReader fr = null;
		MyBufferedReader mybuf = null;
		try {
			fr = new FileReader("./src/Test.java");
			mybuf = new MyBufferedReader(fr);
			String line = null;
			while((line = mybuf.MyReadLine()) != null){
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(mybuf != null){
				try {
					mybuf.myClose();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	/*
	 * 覆盖Reader类中的抽象方法.
	 * 覆盖后必须要实现Reader类中的抽象方法.如果不知道怎么实现对应的抽象方法,可以直接用传进来的对象对应的方法.
	 */
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		return r.read(cbuf, off, len);
	}
	@Override
	public void close() throws IOException {
		r.close();
	}

}
