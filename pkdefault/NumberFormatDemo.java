package pkdefault;
import java.util.Calendar;


public class NumberFormatDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
		nf.setMinimumIntegerDigits(3);//整数部分最少3位
//		nf.setMaximumIntegerDigits(3);
		nf.setMaximumFractionDigits(2);//小数部分最多2位
//		nf.setMinimumFractionDigits(2);
		String str = nf.format(Math.PI);
		System.out.println(str);
		
		//java.text.DecimalFormat的使用
		java.text.DecimalFormat df = new java.text.DecimalFormat("##.00");
		String str2 = df.format(Math.PI);
		System.out.println(str2);
	}

}
