package pkgshoppingcar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestShoppingCar extends JFrame{
	JPanel panelNorth = new JPanel();
	JPanel panelNorthCombo = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelSouth = new JPanel();
	JTextField field = new JTextField();
	JButton buy_Btn = new JButton("買う");
	JButton del_Btn = new JButton("消す");
	JButton outPut_Btn = new JButton("アウトプット");
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	public TestShoppingCar() {
		// TODO Auto-generated constructor stub
		init();
		this.setTitle("スーパーマケット");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(300,90));
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	private void init(){
		Btn_ActionListener bal = new Btn_ActionListener(this);
		field.setPreferredSize(new Dimension(100,24));
		JLabel label = new JLabel("1地瓜,2土豆,3丝瓜");
		scrollPane.setPreferredSize(new Dimension(290,200));
		buy_Btn.addActionListener(bal);
		del_Btn.addActionListener(bal);
		outPut_Btn.addActionListener(bal);
		panelNorthCombo.add(label);
		panelNorthCombo.add(outPut_Btn);
		panelNorth.add(panelNorthCombo);
		panelCenter.setLayout(new FlowLayout());
		panelCenter.add(field);
		panelCenter.add(buy_Btn);
		panelCenter.add(del_Btn);
		panelSouth.add(scrollPane);
		panelSouth.setVisible(false);
		this.add("North",panelNorth);
		this.add("Center",panelCenter);
		this.add("South",panelSouth);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		Map<Integer,OrderItemBean> map = new HashMap<Integer, OrderItemBean>();
//		ShoppingCar sc = new ShoppingCar(0, 0, map);
		new TestShoppingCar();
//		InputStreamReader in = new InputStreamReader(System.in);
//		BufferedReader br = new BufferedReader(in);
//		String s = br.readLine();
//		while(s != null){
//			if(s.equals("exit")){
//				break;
//			}
//			else if(s.equals("地瓜")){
//					sc.buy(1);
//					sc.show();
//			}else if (s.equals("土豆")) {
//				sc.buy(2);
//				sc.show();
//			}else if (s.equals("丝瓜")) {
//				sc.buy(3);
//				sc.show();
//			}else if(s.equals("del")){
//				sc.clear();
//				System.out.print("\u001b[2J");
//				sc.show();
//			}else if (Character.isDigit(s.charAt(3))) {
//				sc.delete(Integer.parseInt(s.charAt(3) + ""));
//				sc.show();
//			}
//			s = br.readLine();
//		}
//		in.close();
//		int ch;
//        Scanner scanner=new Scanner(System.in);
//        while(true)
//        {
//        	System.out.println("购物车");
//            System.out.println("1. 买地瓜");
//            System.out.println("2. 买土豆");
//            System.out.println("3. 买丝瓜");
//            System.out.println("4. 删除一个地瓜");
//            System.out.println("5. 删除一个土豆");
//            System.out.println("6. 删除一个丝瓜");
//            System.out.println("7. 清空购物车");
//            System.out.println("0. Exit");
//            System.out.print("Enter Your Choice:");
//            ch=scanner.nextInt();
//            switch(ch)
//            {
//                case 1:
//                    sc.buy(1);
//                    sc.show();
//                    break;
//                case 2:
//                	sc.buy(2);
//                	sc.show();
//                    break;
//                case 3:
//                	sc.buy(3);
//                	sc.show();
//                    break;
//                case 4:
//                    sc.delete(1);
//                    sc.show();
//                    break;
//                case 5:
//                	sc.delete(2);
//                	sc.show();
//                	break;
//                case 6:
//                	sc.delete(3);
//                	sc.show();
//                	break;
//                case 7:
//                	sc.clear();;
//                	sc.show();
//                	break;
//                case 0:
//                	System.out.println("程序退出...");
//                    System.exit(0);
//                default:
//                    System.out.println("invalid");
//            }
//        }   
	}
}
