package pkgset.pkgmysetinsteadofsetclass;

public class MySet {
	//用来存放所有添加进来的对象,初始长度为0表示刚开始是空额
	static Object[] objs = new Object[0];
	public static boolean contains(Object obj){
		for(Object tm : objs){
			if(tm.equals(obj)){
				return true;
			}
		}
		return false;
	}
	public static boolean add(Object obj){

		//判断是否重复
		if(contains(obj)){		
			return false;
		}
		//1创建一个新的数组	长度为原来数组长度+1
		Object[] objArr = new Object[objs.length + 1];
		//2复制原来的数组对象到新的数组对象
		System.arraycopy(objs, 0, objArr, 0, objs.length);
		//3吧对象添加到新的数组对象的最后一个
		objArr[objs.length] = obj;
		//4吧新的数组对象赋值给原来的数组对象
		objs = objArr;
		
		return true;
	}
	public static Object[] getAll(){
		return objs;
	}
	public int getLen(){
		return objs.length;
	}
}
