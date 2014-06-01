package pkgswing;

import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class TestJFrame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// JFrame类的特性:
		// 默认不可视;
		// 默认宽高为0;
		// JFrame与JFrame不能相互嵌套;
		JFrame jframe = new JFrame("第一个窗口");
		// 设置标题
		jframe.setTitle("java第一个窗口 JFrame");
		// 设置宽和高

		jframe.setSize(new Dimension(300, 280));
		// 居中显示
		jframe.setLocationRelativeTo(null);// size与居中的顺序不可以颠倒
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 关闭模式 关闭的时候推出应用程序
		// DISPOSE_ON_CLOSE 移除窗口的默认窗口关闭操作。
		// DO_NOTHING_ON_CLOSE 无操作默认窗口关闭操作。
		// EXIT_ON_CLOSE 退出应用程序默认窗口关闭操作。
		// HIDE_ON_CLOSE 隐藏窗口的默认窗口关闭操作

		jframe.setVisible(true);// 设置可视化 最好放在所有属性设置之后

		// 对话框
		// 常用构造方法: JDialog(JFrame f,String s);
		// JDialog具有和JFrame一样的特性;
		// JDialog分两种: 有模,无模;
		JDialog dialog = new JDialog(jframe, "第一个对话框");
		dialog.setSize(new Dimension(200, 180));
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setLocationRelativeTo(jframe);
		dialog.setModal(true);// 有模的对话框
		dialog.setVisible(true);

		// 对有模的对话框设置之后后面的代码都不会走 (占用当前方法的执行权)
		// 等对话框销毁之后才可以执行后续的代码
		System.out.println("main结束....");

	}

}
