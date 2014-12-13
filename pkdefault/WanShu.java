package pkdefault;

public class WanShu {
//一个数如果恰好等于他的所有可能因子之和这个数就是完数。例6=1+2+3
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000; i++) {
			int sum = 0;
			for (int j = 1; j <= i/2; j++) {
				if(i % j == 0){
					sum += j;
				}
			}
			if(sum == i){
				System.out.println("Wan shu " + sum);
			}
		}
	}

}
