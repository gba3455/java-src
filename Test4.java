import java.applet.*; 
import java.awt.*; 
public class Test4 extends Applet{

	 public void paint(Graphics g) { 
		 //画竖线
		 g.drawLine(10, 20, 10, 40); 
		 //画平衡线
		  for (int i = 1; i <= 2; i++) {
		   g.drawLine(10, 40 + 10 * i, 150, 40 + 10 * i); 
		  }
		  //画斜线
		  g.drawLine(10, 80, 60, 120); 
		  //画矩形
		  g.drawLine(10, 150, 10, 170); 
		  g.drawLine(10, 150, 100, 150); 
		  g.drawLine(100, 150, 100, 170); 
		  g.drawLine(10, 170, 100, 170); 
		  //画字母A
		  g.drawLine(30, 200, 10, 250); 
		  g.drawLine(30, 200, 50, 250); 
		  g.drawLine(20, 230, 40, 230); 
	} 
}
