package pkginner.inner;

public class ToStringClass {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "";
	}
	
	public static void main(String[] args) {
		System.out.println(new ToStringClass(){
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "Testing....";
			}
		});
	}
}
