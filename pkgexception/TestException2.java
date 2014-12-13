//package pkgexception;
//class IpWrongException extends Exception{//自定义异常
//	public IpWrongException(){
//		
//	}
//}
//public class TestException2 {
//	public static boolean isIP(String str)throws IpWrongException{
//		if (IpJudgement.isIp(str) == false) {
//			throw new IpWrongException();
//		}
//		return true;
//	}
//	public static void main(String[] args) {
//		try{
//			isIP("192.168.1.256");
//		}catch(IpWrongException iwe){
//			System.out.println("发现异常");
//		}
//	}
//}
