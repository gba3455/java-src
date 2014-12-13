package pkdefault;
import java.math.BigDecimal;
/**
 * double d1 = 0.3 * 3; 结果不是0.9; 是0.8999999999999999
 * BigDecimal类可以实现精度计算，BigDecimal 类提供以下操作：算术、标度操作、舍入、比较、哈希算法和格式转换
 * 
 * @author SQZS
 *
 */

public class BigDecimalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal bd1 = new BigDecimal("0.3");
		BigDecimal bd2 = new BigDecimal("3");
		BigDecimal bd3 = bd1.multiply(bd2);//乘
		double temp = bd3.doubleValue();
		System.out.println("0.3 * 3 =" + temp);
		double d4 = 0.3*3;
		System.out.println(d4);
		BigDecimal bd4 = bd1.divide(bd2,2,BigDecimal.ROUND_HALF_UP);//除
		System.out.println(bd4.doubleValue());
		BigDecimal bd5 = new BigDecimal("3.1415");
		BigDecimal bd6 = bd3.setScale(3,BigDecimal.ROUND_HALF_UP);//四舍五入
		System.out.println(bd6.doubleValue());
		
	}

}
