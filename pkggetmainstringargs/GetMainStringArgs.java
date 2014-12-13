package pkggetmainstringargs;

public class GetMainStringArgs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountChar cc = new CountChar();
		System.out.println(cc.CountOfMethod1('a', args));
		System.out.println(cc.CountOfMethod2('e', args));
		System.out.println(cc.CountOfMethod3('6', args));
	}
}
