/**
 * 排序
 * @author SQZS
 *
 */
public class Sort {
	public static void SortByShell(){
		//希尔法排序：先将数据按照固定的间隔分组
//		例如每四个分成一组，然后排序各个分组的数据
//		从全部数据来看较小值已经在前面较大值已经
//		在后面。将初步处理的分组再用插入排序来排序
//		那么数据交换和移动的次数就可以减少。可以得到比插入排序花更高的效率
		int a[] = new int[5];
		a[0] = 3;
		a[1] = 4;
		a[2] = 1;
		a[3] = 5;
		a[4] = 2;
		int j = 0;
		int temp = 0;
		//分组（升序） 降序（）if(temp < a[j - increment]) 改成 if(temp > a[j - increment])
		for(int increment = a.length / 2; increment > 0 ; increment /= 2){
			//每个组内排序
			for(int i = increment; i < a.length ; i++){
				temp = a[i];
				for(j = i ; j >= increment ; j -= increment){
					if(temp < a[j - increment]){
						a[j] = a[j - increment];
					}
					else{
						break;
					}
				}
				a[j] = temp;
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	public static void SortByInsert(){
		//插入法排序
		int a[] = new int[5];
		a[0] = 3;
		a[1] = 4;
		a[2] = 1;
		a[3] = 5;
		a[4] = 2;
		int temp;
		for (int i = 1; i < a.length; i++) {//i = 1开始，因为第一个元素已经排好序了
			for (int j = i; (j > 0) && (a[j] < a[j - 1]); j--) {
				temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortByShell();
	}

}
