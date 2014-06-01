package pkgcollection;
/*
 * 
 */
class Worker{
	
}
class Students{
	
}

//一开始要每个类都对应写一个工具类.麻烦.
//class WorkerTool{
//	private Worker w;
//	public void setWorker(Worker w){
//		this.w = w;
//	}
//	public Worker getWorker(){
//		return w;
//	}
//}
//class StudentTool{
//	private Students s;
//	public void setStudents(Students s){
//		this.s = s;
//	}
//	public Students getStudents(){
//		return s;
//	}
//}

//后来改成里面是一个对象.但是这样return的值还需要强转.
class Tools{
	private Object obj;
	public void setObject(Object obj){
		this.obj = obj;
	}
	public Object getObject(){
		return obj;
	}
}
//泛型类,在类上定义一个参数.  
//什么时候需要定义泛型类?
//当类中需要操作的引用数据类型不确定的时候,
//早期定义Object来完成扩展,现在定义泛型来完成扩展.
class Utils<QQ>{
	private QQ q;
	public void setObject(QQ q){
		this.q = q;
	}
	public QQ getObject(){
		return q;
	}
}
public class GenericDemo3 {
	public static void main(String[] args) {
		Utils<Worker> u = new Utils<Worker>();
		u.setObject(new Worker());
//		u.setObject(new Students());//这里要是错误传一个Student,编译就失败了,这样就可以让错误发生再编译时期.
		Worker wk = u.getObject();//用泛型后,这里可以不需要强转了.
		
//		Tools wt = new Tools();
//		wt.setObject(new Worker());
//		Worker w = (Worker)wt.getObject();//return的值还需要强转.
	}
}
