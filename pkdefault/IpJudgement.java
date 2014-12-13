package pkdefault;

public class IpJudgement {

	public static boolean isIp(String ip){
		String[] temp = ip.split("\\.");
		int count = 0;
		for (int i = 0; i < temp.length; i++) {
			if (Integer.parseInt(temp[i]) >= 0 && Integer.parseInt(temp[i]) <= 255) {
				count++;
			}
		}
		if (count != 4) {
			return false;
		}
		else{
		return true;
		}
	}
	public static int checkPort(String port){
		int temp = Integer.parseInt(port);
		if (temp < 1024 || temp > 65535) {
			return -1;
		}
		return 0;
	}
	public static int checkAge(String age){
		int temp = Integer.parseInt(age);
		if (temp >= 16 && temp <= 150) {
			return temp;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIp("192.168.1.256"));
		System.out.println(checkPort("1023"));
		System.out.println(checkAge("150"));
	}

}
