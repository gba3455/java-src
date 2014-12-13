package pkgmvc;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//view
//View类的角色TextView类必须实现接口Observer，这意味着类TextView必须是implements Observe，另外还需实现其中的方法update()。
public class TextView extends JTextField implements Observer{
	static JTextField radiusIn = new JTextField();
	static JTextField volumeOut = new JTextField();
	static JTextField surfAreaOut = new JTextField();
	@Override
	//当模型Sphere类的状态发生改变时，与模型相关联的视图中的update()方法就会自动被调用，从而实现视图的自动刷新。
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		Sphere balloon = (Sphere)o;
		radiusIn.setText(" " + balloon.getRadius());
		volumeOut.setText(" " + balloon.getVolume());
		surfAreaOut.setText(" " + balloon.getSurfaceArea());
	}
}
class View extends JFrame{
	public View() {	
		this.setLayout(new FlowLayout());
		this.setTitle("MVC");
		this.setSize(new Dimension(300,330));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		TextView.radiusIn.setPreferredSize(new Dimension(140,24));
		TextView.volumeOut.setPreferredSize(new Dimension(140,24));
		TextView.surfAreaOut.setPreferredSize(new Dimension(140,24));
		this.add(TextView.radiusIn);
		this.add(TextView.volumeOut);
		this.add(TextView.surfAreaOut);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new View();
	}
}