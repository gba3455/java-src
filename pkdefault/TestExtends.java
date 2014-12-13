package pkdefault;

class Supper {
	int i = 10;
	public Supper(){
		super();
		print();//上转型调用形式
		System.out.println("supper 1 this=" + this);
		i = 20;
	}
	public void print(){
		System.out.println("Supper 2 ===" + i);
	}
}

class Sub extends Supper{
	int i = 30;//父类隐藏
	public Sub(){
		super();
		print();
		System.out.println("Sub 3 this=" + this);
		super.print();
		i = 40;
	}
	public void print(){
		System.out.println("sub 4 ===" + i);
	}
}

public class TestExtends{
	public static void main(String[] args){
		Sub sub = new Sub();
		System.out.println("sub 5 =" + sub);
	}
}
