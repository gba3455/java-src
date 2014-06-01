public class ClearConsole {

	{
		try {
			String os = System.getProperty("os.name");

			if (os.contains("Mac OS")) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (Exception exception) {
			// Handle exception.
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("fdafd");
		System.out.print("\u001b[2J");
		System.out.flush();
	}
}
