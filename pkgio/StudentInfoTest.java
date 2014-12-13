package pkgio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
 * 有五个学生,每个学生有3门课的成绩.
 * 从键盘输入以上数据.包括姓名,3们课的成绩.
 * 输入的格式:如:zhangshan,30,40,60,计算出总成绩.
 * 并吧学生的信息和计算出的总分数高低顺序存放在磁盘文件stud.txt中.
 * 
 * 1:描述学生对象.
 * 2:定义一个可以操作学生对象的工具类
 * 
 * 思想:
 * 1:通过获取键盘录入一行数据.并将该行中的信息取出封装成学生对象.
 * 2:因为学生对象有很多,那么就需要存储使用到集合.因为要对学生的总分排序,
 * 所以可以使用TreeSet
 * 3:将集合中的信息写入到一个文件中.
 */
class Student implements Comparable<Student>{
	private String name;
	private int yuwen,shuxue,yingyu,sum;
	public Student(String name,int yuwen,int shuxue,int yingyu){
		this.name = name;
		this.yuwen = yuwen;
		this.shuxue = shuxue;
		this.yingyu = yingyu;
		sum = yuwen + shuxue + yingyu;
	}
	public int getSum(){
		return this.sum;
	}
	public String getName(){
		return this.name;
	}
	@Override
	public int compareTo(Student o) {
		int num = new Integer(this.sum).compareTo(new Integer(o.sum));
		if(num == 0){
			return this.name.compareTo(o.name);
		}
		return num;
	}
	public int hashCode(){
		return name.hashCode() + sum * 78;
	}
	public boolean equals(Object obj){
		if(!(obj instanceof Student))
			return false;
		Student s = (Student)obj;
		if(this.name.equals(s.name) && this.sum == s.sum){
			return true;
		}
		return false;
	}
	public String toString(){ 
		return "Student[" + name + "," + yuwen + "," + shuxue + "," + yingyu + "," + sum + "]";
	}
}
class StudentInfoTool{
	static Set<Student> getStudent() throws IOException{
		return getStudent(null);//<<<不需要比较器,所以传null,往外提供2中方法,剩下的代码一样.
	}
	static Set<Student> getStudent(Comparator<Student> com) throws IOException{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		Set<Student> stus = null;
		if(com == null){
			stus = new TreeSet<Student>();
		}else{
			stus = new TreeSet<Student>(com);
		}
		String str = null;
		
		while((str = bufr.readLine()) != null){
			if(str.equals("over")){
				break;
			}
			String[] st = str.split(",");
			stus.add(new Student(st[0],Integer.parseInt(st[1]),Integer.parseInt(st[2]),Integer.parseInt(st[3])));
		}
		bufr.close();
		return stus;
	}
	static void write2File(Set<Student> stus) throws IOException{
		FileOutputStream fos = new FileOutputStream("/users/sqzs/desktop/stu.txt");
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(fos));
		for(Student s : stus){
			bufw.write(s.toString() + "\t");
			bufw.write(s.getSum() + "");//<<<<这里是整数,写后8位,会出乱码,所以要变字符串.
			bufw.newLine();
			bufw.flush();
		}
		bufw.close();
	}
}
public class StudentInfoTest {

	public static void main(String[] args) throws IOException {
		Comparator com = Collections.reverseOrder();
		StudentInfoTool.write2File(StudentInfoTool.getStudent(com));
	}

}
