
public class MathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double d1 = Math.abs(-0.0232);//绝对值
		System.out.println(d1);
		double d2 = Math.round(100.6232);//四舍五入
		System.out.println(d2);
		double d3 = Math.pow(2, 3);
		System.out.println(d3);
		System.out.println(Math.random());//0~1之间的随机数
		//取0~10之间随机整数1
		double d4 = Math.random() * 10;
		long i = Math.round(d4);
		System.out.println(i);
		//取0~10之间随机整数2
		double d5 = Math.random() * 11;
		int i2 = (int)d5;
		System.out.println(i2);
	}

}
