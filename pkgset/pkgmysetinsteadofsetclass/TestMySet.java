package pkgset.pkgmysetinsteadofsetclass;

public class TestMySet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a1 = new A();
		a1.a = 345;
		A a2 = new A();
		MySet s = new MySet();
		s.add(a1);
		s.add(a2);
		Object[] objs = s.getAll();	
		for (Object object : objs) {
			System.out.println(object);
		}
		
	}

}
class A{
	protected int a = 123;
	private String s = "abc";
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "a ===" + a + "s ===" + s;
	}
	@Override
	public boolean equals(Object obj) {
		A a = (A)obj;
		// TODO Auto-generated method stub
		if((a.a == this.a)&&(a.s.equals(this.s))){
			return true;
		}
		return false;
	}
}