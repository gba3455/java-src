package pkgcollection;
/*
 * ArrayList判断是否有不同只依赖equals方法.HashSet判断是否有不同先依赖Hashcode方法,再依赖equals方法.
 */
import java.util.HashSet;
import java.util.Iterator;

/*
 * |--Set:元素是无序的(存入和取出的顺序不一定一致).元素不可以重复.
 * 		|--HashSet:底层数据结构是哈希表.
 * 			HashSet是如何保证元素的唯一性的呢?
 * 			是通过元素的两个方法,hashCode和equals来完成.
 * 			如果元素的HashCode值相同,才会判断equals是否为ture
 * 			如果元素的HashCode值不同,不会调用equals.
 * 			所以我们在定义一个对象的时候,通常要复写Hashcode和equals.因为有可能对象要存放到hashset集合中.
 * 			不复写地址都不一样,无法判断是否重复.
 * 		|--TreeSet:底层
 * Set集合的功能和Collection是一致的.
 * 
 * 
 */
public class HashSetDemo {
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		
		System.out.println(hs.add("java01"));
		System.out.println(hs.add("java01"));
 		hs.add("java02");
		hs.add("java03");
		hs.add("java03");
		hs.add("java04");
		
		Iterator it = hs.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
