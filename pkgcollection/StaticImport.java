package pkgcollection;

import java.util.Arrays;
import static java.util.Arrays.*;

import static java.lang.System.*;//导入了System类中所有静态成员.
/*
 * 静态导入
 * 
 * 当类名重名时,需要指定具体的包名;
 * 当方法重名时,需要指定具体所属的对象或者类.
 */
public class StaticImport {
	public static void main(String[] args) {
		
		out.print("fda");
		
		int[] arr = {3,4,6};
		
		sort(arr);
		
		int index = binarySearch(arr, 4);
		
		out.println(Arrays.toString(arr));
		
		System.out.println(index);
	}
}
