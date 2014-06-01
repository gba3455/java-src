
/**
 * 1、第一个答案是b的问题是哪一个？
　　（a）2；（b） 3；（c）4；（d）5；（e）6

　　2、唯一的连续两个具有相同答案的问题是：
　　（a）2，3；（b）3，4；（c）4，5；（d）5，6；（e）6，7；

　　3、本问题答案和哪一个问题的答案相同？
　　（a）1；（b）2；（c）4；（d）7；（e）6

　　4、答案是a的问题的个数是：
　　（a）0；（b）1；（c）2；（d）3；（e）4

　　5、本问题答案和哪一个问题的答案相同？
　　（a）10；（b）9；（c）8；（d）7；（e）6

　　6、答案是a的问题的个数和答案是什么的问题的个数相同？
　　（a）b；（b）c；（c）d；（d）e；（e）以上都不是

　　7、按照字母顺序，本问题的答案和下一个问题的答案相差几个字母？
　　（a）4；（b）3；（c）2；（d）1；（e）0。（注：a和b相差一个字母）

　　8、答案是元音字母的问题的个数是：
　　（a）2；（b）3；（c）4；（d）5；（e）6。（注：a和e是元音字母）

　　9、答案是辅音字母的问题的个数是：
　　（a）一个质数；（b）一个阶乘数；（c）一个平方数；（d）一个立方数; （e）5的倍数

　　10、本问题的答案是：
　　（a）a；（b）b；（c）c；（d）d；（e）e。
 * @author SQZS
 *
 */
public class Question {
	static int count = 0;
	/*1、第一个答案是b的问题是哪一个？
　　（a）2；（b） 3；（c）4；（d）5；（e）6*/
	public static boolean q1(int a1,int a2,int a3,int a4,int a5,int a6,int a7,int a8,int a9,int a10){
		if((a1 == 1 && a2 == 2)
		||(a1 == 2 && a2 == 3 && a1 != 2 && a2 != 1)
		||(a1 == 3 && a4 == 2 && a2 != 2 && a3 != 2)
		||(a1 == 4 && a5 == 2 && a2 != 2 && a3 != 2 && a4 != 2)
		||(a1 == 5 && a6 == 2 && a2 != 2 && a3 != 2 && a4 != 2 && a5 != 2)){
			return true;
		}
		return false;
	}
	public static boolean q2(int a1,int a2,int a3,int a4,int a5,int a6,int a7,int a8,int a9,int a10){
	/*2、唯一的连续两个具有相同答案的问题是：
　　（a）2，3；（b）3，4；（c）4，5；（d）5，6；（e）6，7；*/
		if((a2 == 1 && a2 == a3 && a3 != a4 && a4 != a5 && a5 != a6 && a6 != a7 && a7 != a8 && a8 != a9 && a9 != a10)
		||(a2 == 2 && a2 != a3 && a3 == a4 && a4 != a5 && a5 != a6 && a6 != a7 && a7 != a8 && a8 != a9 && a9 != a10)
		||(a2 == 3 && a2 != a3 && a3 != a4 && a4 == a5 && a5 != a6 && a6 != a7 && a7 != a8 && a8 != a9 && a9 != a10) 
		||(a2 == 4 && a2 != a3 && a3 != a4 && a4 != a5 && a5 == a6 && a6 != a7 && a7 != a8 && a8 != a9 && a9 != a10)
		||(a2 == 5 && a2 != a3 && a3 != a4 && a4 != a5 && a5 != a6 && a6 == a7 && a7 != a8 && a8 != a9 && a9 != a10)){
			return true;
		}
		return false;
	}	
	public static boolean q3(int a1,int a2,int a3,int a4,int a5,int a6,int a7,int a8,int a9,int a10){
		/*3、本问题答案和哪一个问题的答案相同？
	　　（a）1；（b）2；（c）4；（d）7；（e）6*/
		if((a3 == 1 && a3 == a1)
		||(a3 == 2 && a3 == a2)
		||(a3 == 3 && a3 == a4)
		||(a3 == 4 && a3 == a7)
		||(a3 == 5 && a3 == a6)){
			return true;
		}
		return false;
	}	
	public static boolean q4(int a1,int a2,int a3,int a4,int a5,int a6,int a7,int a8,int a9,int a10){
		/*4、答案是a的问题的个数是：
　　（a）0；（b）1；（c）2；（d）3；（e）4*/
		if((a4 == 1 && sumA(1,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) == 0)
		||(a4 == 2 && sumA(1,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) == 1)
		||(a4 == 3 && sumA(1,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) == 2)
		||(a4 == 4 && sumA(1,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) == 3)
		||(a4 == 5 && sumA(1,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) == 4)){
			return true;
		}
		return false;
	}	
	public static boolean q5(int a1,int a2,int a3,int a4,int a5,int a6,int a7,int a8,int a9,int a10){
		/*5、本问题答案和哪一个问题的答案相同？
　　（a）10；（b）9；（c）8；（d）7；（e）6*/
		if((a5 == 1 && a5 == a10)
			||(a5 == 2 && a5 == a9)
			||(a5 == 3 && a5 == a8)
			||(a5 == 4 && a5 == a7)
			||(a5 == 5 && a5 == a6)){
			return true;
		}
		return false;
	}
	public static boolean q6(int a1,int a2,int a3,int a4,int a5,int a6,int a7,int a8,int a9,int a10){
		/*6、答案是a的问题的个数和答案是什么的问题的个数相同？
　　（a）b；（b）c；（c）d；（d）e；（e）以上都不是*/
		if((a6 == 1 && sumA(1,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) == sumA(2,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10))
		||(a6 == 2 && sumA(1,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) == sumA(3,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10))
		||(a6 == 3 && sumA(1,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) == sumA(4,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10))
		||(a6 == 4 && sumA(1,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) == sumA(5,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10))
		||a6 == 5 && (sumA(1,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) != sumA(2,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)
		&&sumA(1,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) != sumA(3,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)
		&&sumA(1,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) != sumA(4,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)
		&&sumA(1,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) != sumA(5,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10))){
			return true;
		}
		return false;
	}
	public static boolean q7(int a1,int a2,int a3,int a4,int a5,int a6,int a7,int a8,int a9,int a10){
		/*7、按照字母顺序，本问题的答案和下一个问题的答案相差几个字母？
　　（a）4；（b）3；（c）2；（d）1；（e）0。（注：a和b相差一个字母）*/
		//相差可能是正的相差也可能是负的相差
		if((a7 == 1 && Math.abs(a8 - a7) == 4) 
		|| (a7 == 2 && Math.abs(a8 - a7) == 3) 
		|| (a7 == 3 && Math.abs(a8 - a7) == 2) 
		|| (a7 == 4 && Math.abs(a8 - a7) == 1) 
		|| (a7 == 5 && Math.abs(a8 - a7) == 0)){
			return true;
		}
		return false;
	}
	public static boolean q8(int a1,int a2,int a3,int a4,int a5,int a6,int a7,int a8,int a9,int a10){
		/*8、答案是元音字母的问题的个数是：
　　（a）2；（b）3；（c）4；（d）5；（e）6。（注：a和e是元音字母）*/
		if((a8 == 1 && sumA(1,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) + sumA(5,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) == 2)
		||(a8 == 2 && sumA(1,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) + sumA(5,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) == 3)
		||(a8 == 3 && sumA(1,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) + sumA(5,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) == 4)
		||(a8 == 4 && sumA(1,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) + sumA(5,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) == 5)
		||(a8 == 5&& sumA(1,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) + sumA(5,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) == 6)
		){
			return true;
		}
		return false;
	}
	public static boolean q9(int a1,int a2,int a3,int a4,int a5,int a6,int a7,int a8,int a9,int a10){
		/*9、答案是辅音字母的问题的个数是：
　　（a）一个质数；（b）一个阶乘数；（c）一个平方数；（d）一个立方数; （e）5的倍数*/
		if(
		(a9 == 1 && zhiShu(sumA(2,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) + sumA(3,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) + sumA(4,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)))
		||(a9 == 2 && jieCheng(sumA(2,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) + sumA(3,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) + sumA(4,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)))
		||(a9 == 3 && pingFang(sumA(2,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) + sumA(3,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) + sumA(4,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)))
		||(a9 == 4 && liFang(sumA(2,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) + sumA(3,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) + sumA(4,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)))
		||(a9 == 5 && (sumA(2,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) + sumA(3,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10) + sumA(4,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)) % 5 == 0)
		){
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int a1 = 1; a1 < 6; a1++) {
			for (int a2 = 1; a2 < 6; a2++) {
				for (int a3 = 1; a3 < 6; a3++) {
					for (int a4 = 1; a4 < 6; a4++) {
						for (int a5 = 1; a5 < 6; a5++) {
							for (int a6 = 1; a6 < 6; a6++) {
								for (int a7 = 1; a7 < 6; a7++) {
									for (int a8 = 1; a8 < 6; a8++) {
										for (int a9 = 1; a9 < 6; a9++) {
											for (int a10 = 1; a10 < 6; a10++) {
												count++;
												if(q1(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)
												&&q2(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)
												&&q3(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)
												&&q4(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)
												&&q5(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)
												&&q6(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)
												&&q7(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)
												&&q8(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)
												&&q9(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10)){
													System.out.println("a1 = " + a1
															+ "	a2 = " + a2
															+ "	a3 = " + a3
															+ "	a4 = " + a4
															+ "	a5 = " + a5
															+ "	a6 = " + a6
															+ "	a7 = " + a7
															+ "	a8 = " + a8
															+ "	a9 = " + a9
															+ "	a10 = " + a10);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		System.out
				.println(count + "!");
	}
	public static boolean liFang(int num){
		for(int i = 1; i < num; i++){
			if(i * i * i == num){
				return true;
			}
		}
		return false;
	}
	public static boolean pingFang(int num){
		for(int i = 1; i < num; i++){
			if(i * i == num){
				return true;
			}
		}
		return false;
	}
	public static boolean jieCheng(int num){
		int temp = 1;
		for(int i = 1; i < num; i++){
			temp = temp * i;
			if(temp == num){
				return true;
			}
		}
		return false;
	}
	public static boolean zhiShu(int num){
		if(num == 2){
			return true;
		}
		for(int i = 2; i < num ; i++){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}
	public static int sumA(int answer,int a1,int a2,int a3,int a4,int a5,int a6,int a7,int a8,int a9,int a10){
		int sum = 0;
		if(a1 == answer){
			sum += 1;
		}
		if(a2 == answer){
			sum += 1;
		}
		if(a3 == answer){
			sum += 1;
		}
		if(a4 == answer){
			sum += 1;
		}
		if(a5 == answer){
			sum += 1;
		}
		if(a6 == answer){
			sum += 1;
		}
		if(a7 == answer){
			sum += 1;
		}
		if(a8 == answer){
			sum += 1;
		}
		if(a9 == answer){
			sum += 1;
		}
		if(a10 == answer){
			sum += 1;
		}
		return sum;
	}
}
