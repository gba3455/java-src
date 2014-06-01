package pkgcircle;
public class Circle {
	float r;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	void setR(float radium) {
		r = radium;
	}

	float getR() {
		return r;
	}

	void init() {
		r = 5;
	}

	void init(float radium) {
		r = radium;
	}

	double area() {
		return 3.14 * r * r;
	}

	double girth() {
		return 2 * 3.14 * r;
	}
}
