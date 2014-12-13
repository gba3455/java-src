package pkdefault;
/**
 * 一球从100 m高度自由落下每次落地后反弹回原高度的一半，再落下，求他在第10次落地时，共经过多少米第10次反弹多高
 * @author SQZS
 *
 */
public class BallJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sum = 0.0;
		double begin = 100.0;
		double fantan = 0.0;
		for (int i = 0; i < 10; i++) {
			if(i == 9){
				sum += begin;
				fantan = begin/2;
			}else{
				sum += begin + begin/2;				
			}
			begin = begin/2;
		}
		System.out.println("共经过" + sum + "第10次反弹" + fantan);
	}

}
