package pkdefault;
class Test3 {
	public static void main(String[] args) throws Exception {
		System.out.println(md5_3("abc"));
	}
	public static String md5_3(String s) throws Exception {
		java.security.MessageDigest md = java.security.MessageDigest
				.getInstance("MD5");
		md.update(s.getBytes("UTF-8"));
		byte tmp[] = md.digest(); // MD5 的計算結果是一個 128 位的長整數，
//		md.update(tmp);
//		tmp = md.digest();
//		md.update(tmp);
//		tmp = md.digest();
		char hexDigits[] = { // 用來將位元組轉換成 16 進位表示的字元
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D','E', 'F' };
		char str[] = new char[16 * 2];
		int k = 0;
		for (int i = 0; i < 16; i++) {
			byte byte0 = tmp[i]; // 取第 i 個位元組
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
			str[k++] = hexDigits[byte0 & 0xf];
			// 取位元組中低 4 位的數字轉換
		}
		s = new String(str);
		return s;
	}
}