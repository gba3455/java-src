package pkgset;
/**
 * 扩展了Collection接口
具有顺序的集合
元素可以通过其整型下标访问
可以包含重复元素
方法分类
定位方法：get()、set()、add()、remove()、addAll()
搜索方法：indexOf() 和 lastIndexOf() 
ListIterator方法：listIterator() 和 subList() 

 */
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class TestListDemo {
	public static void main(String[] args) {
		List list = new ArrayList();//LinkedList
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("ab");
		list.add("ac");
		list.add("aa");
		list.add("a");
		System.out.println("list = " + list);
		Object get = list.get(3);//ab
		int indexOf = list.indexOf("aa");//5
		int lastIndexOf = list.lastIndexOf("a");//6
		list.set(1, "element");//修改替换
		System.out.println("list = " + list);
		list.add(2, "add(index,element)");//插入添加 后移
		List list2 = new LinkedList();
		list2 = list.subList(2, 5);
		System.out.println(list2);
	}
}
