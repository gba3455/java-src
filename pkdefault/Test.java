package pkdefault;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test extends JFrame {

	// static void Test1(){
	// //int x = 9;
	// //int y = (x++)+(++x)+7+(++x)+(--x)+8+(x--);
	// //System.out.print(y);
	// int x = 5;
	// System.out.println("x= "+x);
	// System.out.println("++x= "+(++x));
	// System.out.println("x= "+x);
	// System.out.println("--x= "+(--x));
	// System.out.println("x= "+x);
	// System.out.println("x++= "+(x++));
	// System.out.println("x= "+x);
	// System.out.println("x--= "+(x--));
	// System.out.println("x= "+x);
	//
	// String s1 = "fda";
	// String s2 = "fda";
	// if (s1 == s2) {
	// //因为s1和s2都指向常量“fda”，所以hashcode一样，相等。如果吧常量改变就不相等了
	// System.out.println(s1.hashCode() + "!" + s2.hashCode());
	// }
	// String s3 = new String("fda");
	// String s4 = new String("fda");
	// //new了两个对象出来，不再是常量了哦。
	// if (s3 == s4) {
	// System.out.println("==");
	// }
	// System.out.println(s3.hashCode() + "!" + s4.hashCode());
	// }
	// static void TestFile(){
	// File file = new File("/Users/SQZS/Desktop/newFileFromJavaProgram.txt");
	// try {
	// FileInputStream fileInputStream = new FileInputStream(file);
	// try {
	// while (fileInputStream.read() == -1) {
	//
	// System.out.print((char)fileInputStream.read());
	//
	// }
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// } catch (FileNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// static void Table(){
	// List<List<Integer>> table = new ArrayList<List<Integer>>();
	// for (int i = 0; i <= 10; i++) {
	// List<Integer> row = new ArrayList<Integer>();
	// for (int j = 0; j <= 10; j++)
	// row.add(i * j);
	// table.add(row);
	// }
	// for (List<Integer> row : table)
	// System.out.println(row);
	// }

	// JTextField[] field = new JTextField[3];
	//
	// String[] arr = { "+", "-", "*", "/" };
	//
	// JComboBox comboBox = new JComboBox(arr);
	//
	// JPanel panel = new JPanel();
	//
	// public Test() {
	//
	// init();
	//
	// this.setTitle("test");
	//
	// this.setSize(new Dimension(400, 100));
	//
	// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//
	// this.setLocationRelativeTo(null);
	//
	// this.setVisible(true);
	//
	// }

	// public enum beSelect{
	// "+","-";
	// }
	// private void init() {
	//
	// JButton button = new JButton("=");
	// String temp = "+";
	// button.addActionListener(new ActionListener() {
	//
	// @Override
	// public void actionPerformed(ActionEvent e) {
	//
	// if(((JButton)e.getSource()).getText().equals("=")){
	// switch (temp) {
	// case value:
	//
	// break;
	//
	// default:
	// break;
	// }
	// Integer temp = Integer.parseInt(field[0].getText()) +
	// Integer.parseInt(field[1].getText());
	// field[2].setText(temp.toString());
	// }
	// }
	//
	// });
	//
	// comboBox.addItemListener(new ItemListener() {
	//
	// @Override
	// public void itemStateChanged(ItemEvent e) {
	// int selected = e.getStateChange();
	// if(selected == 2){
	//
	// }
	// }
	// });
	//
	// for (int i = 0; i < 3; i++) {
	//
	// field[i] = new JTextField();
	// field[i].setPreferredSize(new Dimension(50,24));
	// }
	//
	// panel.add(field[0]);
	//
	// panel.add(comboBox);
	//
	// panel.add(field[1]);
	//
	// panel.add(button);
	//
	// panel.add(field[2]);
	//
	// this.add(panel);
	//
//	private static JLabel label1;
//
	public Test() {
		init();
		this.setTitle("tab");
		this.setSize(new Dimension(400, 440));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
//
	private void init() {
		JLabel[][] mapLabel = new JLabel[8][8];
		JPanel panel = new JPanel();
//		panel.setLayout(new GridLayout(8, 8));
//		for (int i = 0; i < mapLabel.length; i++) {
//			for (int j = 0; j < mapLabel[i].length; j++) {
//				mapLabel[i][j] = new JLabel();
//				mapLabel[i][j].setBorder(new LineBorder(Color.white));
//				mapLabel[i][j].setPreferredSize(new Dimension(50, 50));
//				mapLabel[i][j].setOpaque(true);
//				mapLabel[i][j].setText(i + "x" + j);
//				if (i == 0 || i == 7) {
//					mapLabel[i][j].setBackground(Color.BLACK);
//				} else if (j == 0 || j == 7) {
//					mapLabel[i][j].setBackground(Color.BLACK);
//				}
//				mapLabel[i][j].setForeground(Color.magenta);
//				panel.add(mapLabel[i][j]);
//			}
//		}
//		 TableModel dataModel = new AbstractTableModel() {
//		
//		 @Override
//		 public Object getValueAt(int rowIndex, int columnIndex) {
//		 // TODO Auto-generated method stub
//		 return new Integer(rowIndex * columnIndex);
//		 }
//		
//		 @Override
//		 public int getRowCount() {
//		 // TODO Auto-generated method stub
//		 return 10;
//		 }
//		
//		 @Override
//		 public int getColumnCount() {
//		 // TODO Auto-generated method stub
//		 return 10;
//		 }
//		 };
//		 JTable table = new JTable(dataModel);
//		 JButton btn = new JButton("open");
//		 TestActionListener tal = new TestActionListener(this);
//		 btn.addActionListener(tal);
//		 panel.add(table);
//		 panel.add(btn);
		Graphics   g = new Graphics() {
			
			@Override
			public void translate(int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setXORMode(Color c1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPaintMode() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setFont(Font font) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setColor(Color c) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setClip(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setClip(Shape clip) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public FontMetrics getFontMetrics(Font f) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Font getFont() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Color getColor() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Rectangle getClipBounds() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Shape getClip() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void fillRoundRect(int x, int y, int width, int height,
					int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void fillArc(int x, int y, int width, int height, int startAngle,
					int arcAngle) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(AttributedCharacterIterator iterator, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawString(String str, int x, int y) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawRoundRect(int x, int y, int width, int height,
					int arcWidth, int arcHeight) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawOval(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void drawLine(int x1, int y1, int x2, int y2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2,
					int sx1, int sy1, int sx2, int sy2, Color bgcolor,
					ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2,
					int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height,
					Color bgcolor, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, int width, int height,
					ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, Color bgcolor,
					ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void drawArc(int x, int y, int width, int height, int startAngle,
					int arcAngle) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void dispose() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Graphics create() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void copyArea(int x, int y, int width, int height, int dx, int dy) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clipRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void clearRect(int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
		};
		g.setColor(Color.gray);
		g.drawLine(0, 20, 20, 20);
		this.add(panel);
	}

	public static void main(String[] args) throws Exception {
		 new Test();
		// BufferedReader bufr = new BufferedReader(new FileReader(new
		// File("/users/sqzs/desktop/tele.txt")));
		// int count = 0;
		// String str = "";
		// while((str = bufr.readLine()) != null){
		// count ++;
		// int i = str.indexOf("20140") + 5;
		// str = str.substring(i, i + 3);
		// System.out.println("https://home.kcg.ac.jp/SystemD/img/kyujin/kyujin_20140"
		// + str + ".pdf");
		// str = bufr.readLine();
		// str = bufr.readLine();
		// int count = 0;
		// int x = 100,y = 50,z = 10;
		// for(int i = 0 ; i < 3 ; i++){
		// for(int j = 0; j < 5 ; j++){
		// for(int k = 0; k < 27 ; k++){
		// if( i * x + j * y + k * z == 260){
		// count ++;
		// System.out.println(" x =" + i + " y =" + j + " z =" + k);
		// }
		// }
		// }
		// }
		// System.out.println(count);
		// int start = -1;
		// int end = -1;
		// String link = null;
		// String pa55 = null;
		// InputStreamReader isr = new InputStreamReader(new FileInputStream(
		// new File("/users/sqzs/downloads/qing.txt")), "gbk");
		// char[] chr = new char[1024];
		// int len = 0;
		// while ((len = isr.read(chr)) != -1) {
		// String str = new String(chr, 0, len);
		//
		// start = str.indexOf("链接：");
		// end = str.indexOf("密码：");
		// link = str.substring(start + 3, end);
		// pa55 = str.substring(end + 3, end + 7);
		// System.out.println(link);
		// System.out.println(pa55);
		// }
//		int count = 0;
//		BufferedReader bufr = new BufferedReader(new InputStreamReader(
//				new FileInputStream(new File("/users/sqzs/desktop/data.txt")),
//				"UTF-8"));
//		String str = null;
//		while ((str = bufr.readLine()) != null) {
//			START s = new START();
//			END e = new END();
//			if (str.contains("受付日:")) {
//				s.start = str.indexOf("受付日:");
//			}
//			if(str.contains("</a>&nbsp;]")){
//				e.end = str.indexOf("</a>&nbsp;]");
//			}
//			if(s.start != 0 && e.end != 0){
//				String temp = str.substring(s.start, e.end);
//				if(temp.contains("京都府") || temp.contains("大阪府")){
//					START s1 = new START();
//					END e1 = new END();
//					if(temp.contains("求人票番号")){
//						s1.start = temp.indexOf("求人票番号") + "&nbsp;&nbsp[&nbsp;<a href='".length() + 5;
//					}
//					if(temp.contains("#zoom=100'")){
//						e1.end = temp.indexOf("#zoom=100'");
//					}
//					System.out.println(temp.substring(s1.start, e1.end));
//					count++;
//				}
//			}
//		}
//		System.out.println(count);
//	}

//		BufferedImage bufI = ImageIO.read(new FileInputStream(new File("/users/sqzs/desktop/t0sub.png")));	
//		System.out.println(bufI.getWidth() + "xxx" + bufI.getHeight());
	}
}
//
//class START {
//	protected int start = 0;
//}
//
//class END {
//	protected int end = 0;
//}