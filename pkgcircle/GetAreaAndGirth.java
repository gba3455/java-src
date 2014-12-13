package pkgcircle;
public class GetAreaAndGirth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c = new Circle();
		c.init();
		System.out.println("面积为" + c.area());
		System.out.println("周长为" + c.girth());
		c.init(10);
		System.out.println("面积为" + c.area());
		System.out.println("周长为" + c.girth());
	}
}
