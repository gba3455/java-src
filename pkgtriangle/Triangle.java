package pkgtriangle;
public class Triangle {
	private double side1;
	private double side2;
	private double side3;

	public Triangle(double side1, double side2, double side3) {
		super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public double getPerimeter() {
		return side1 + side2 + side3;
	}

	public double getArea() {
		double s = (side1 + side2 + side3) / 2;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Triangle t = new Triangle(1, 1.5, 1);
		return "边长为" + t.getPerimeter() + "面积为" + t.getArea();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Triangle t = new Triangle(1, 1.5, 1);
		System.out.println(t);

	}

}
