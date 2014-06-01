/**
 * 题目：有人邀请ＡＢＣＤＥＦ６个人参加一项会议，这６个人有些奇怪，因为他们有很多要求，已知：
１．ＡＢ两人至少有１人参加会议。

２．ＡＥＦ３人中有２人参加会议。

３．Ｂ和Ｃ两人一致决定，要么两人都去，要么两人都不去。

４．ＡＤ中１人参加。

５．ＣＤ两人中也只要１人参加会议。

６．如果Ｄ不去，那么Ｅ也决定不去。
 * @author SQZS
 *
 */
public class Question2 {
	public static boolean q1(int A,int B,int C,int D,int E,int F){
		//１．ＡＢ两人至少有１人参加会议。
		if((A + B) >= 1){
				return true;
			}
		return false;
	}
	public static boolean q2(int A,int B,int C,int D,int E,int F){
		//ＡＥＦ３人中有２人参加会议。
		if((A + E + F) == 2){
				return true;
			}
		return false;
	}
	public static boolean q3(int A,int B,int C,int D,int E,int F){
		//３．Ｂ和Ｃ两人一致决定，要么两人都去，要么两人都不去。
		if((B + C) == 2 || (B + C) == 0){
			return true;
		}
		return false;
	}
	public static boolean q4(int A,int B,int C,int D,int E,int F){
		//ＡＤ中１人参加。
		if((A + D) == 1){
			return true;
		}
		return false;
	}
	public static boolean q5(int A,int B,int C,int D,int E,int F){
		//５．ＣＤ两人中也只要１人参加会议。
		if((C + D) == 1){
			return true;
		}
		return false;
	}
	public static boolean q6(int A,int B,int C,int D,int E,int F){
		//如果Ｄ不去，那么Ｅ也决定不去。
		if(D == 0 && E == 0){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int A = 0; A <= 1; A++) {
			for (int B = 0; B <= 1; B++) {
				for (int C = 0; C <= 1; C++) {
					for (int D = 0; D <= 1; D++) {
						for (int E = 0; E <= 1; E++) {
							for (int F = 0; F <= 1; F++) {
								if(q1(A,B,C,D,E,F)&&q2(A,B,C,D,E,F)&&q3(A,B,C,D,E,F)
								&&q4(A,B,C,D,E,F)&&q5(A,B,C,D,E,F)&&q6(A,B,C,D,E,F)){
									System.out.println(" A " + A + " B " + B + " C " + C + " D " + D + " E " + E + " F " + F);
								}
							}
						}
					}
				}
			}
		}
	}
	//countGo(A,B);//countGo(int[] intArray{A,B});
	static int countGo(int ... as) {//...参数可变的方法编译器会在悄悄地把这最后一个形参转化为一个数组形参，
		int sum = 0;
		for (int a : as) {
			if (a == 1) {
				sum++;
			}
		}
		return sum;
	}
	
}
