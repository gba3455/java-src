import java.io.IOException;

/**
 * Runtime对象
 * 该类并没有提供构造函数
 * 说明不可以new对象,那么会直接想到该类中的方法都是静态的
 * 发现该类中还有非静态方法
 * 说明该类肯定会提供给了方法获取本类对象,而且改方法是静态的,并且返回值类型是本类类型
 * 
 * 由这个特点可以看出该类使用了单例设计模式完成
 * 
 * 该方法是static Runtime getRuntime();
 * @author SQZS
 *
 */
public class RuntimeDemo {

	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		try {
			String[] cmd = new String[]{"/usr/bin/open","-n","/Applications/QQ.app"};
			Process p = r.exec(cmd);
//			Process p = r.exec("notepad.exe RuntimeDemo.java");
			
//			Thread.sleep(4000);
//			p.destroy();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
