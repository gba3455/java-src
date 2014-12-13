package pkdefault;

public class PrintTuXing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 4; i++) {
			for (int j = 0; j < (2 * i - 1); j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		for (int i = 3; i > 0; i--) {
			for (int j = 0; j < (2 * i - 1); j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

}
