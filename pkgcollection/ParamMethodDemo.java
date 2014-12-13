package pkgcollection;
/*
 * JDK1.5版本出现的新特性
 * 可变参数
 * 在使用时注意:可变参数一定要定义在参数列表呃最后面.
 */
public class ParamMethodDemo {
	public static void main(String[] args) {
//		show(1,2);
//		show(1,2,3);
		
//		int[] arr = {1,2};
//		int[] arr2 = {1,2,3};
//		show(arr);
//		show(arr2);
		
		show(1,2);
		show(1,2,3);
		show(1,2,3,4);
		
		show2("hehe",1,2,3,4,4,5);
	}
//	private static void show(int a,int b){
//		System.out.println(a + "," + b);
//	}
//	private static void show(int a, int b,int c){
//		System.out.println();
//	}
	
//	private static void show(int[] arr){
//		
//	}
	
	private static void show(int ... arr){
		
	}
	
	private static void show2(String str,int ... arr){
		
	}
}
