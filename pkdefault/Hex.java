package pkdefault;
public class Hex {
	public static String getHex(int num,int n){
		//1 用num除以n 得到商和余数
		String str = "";
		int sum = num / n;
		int yuShu = num % n;
		str = "" + numToAlphabet(yuShu);
		while(sum > 0){
			//2 继续除以n 得到商和余数
			yuShu = sum % n;
			sum = sum / n;
			str = numToAlphabet(yuShu) + str;
		}
		
		return str;
		//3 如果商为0就终止
	}
	public static String numToAlphabet(int num){
		switch (num) {
		case 10:
			return "A";
		case 11:
			return "B";
		case 12:
			return "C";
		case 13:
			return "D";
		case 14:
			return "E";
		case 15:
			return "F";
		}
		return "" + num;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getHex(1431,2));
		System.out.println(Integer.toHexString(14));
	}

}
