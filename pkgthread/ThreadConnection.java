package pkgthread;
class Res{
	String name;
	String sex;
}
class Input implements Runnable{
	Res s;
	Input(Res r){
		this.s = r;
	}
	@Override
	public void run() {
		int x = 0;
			while(true){
				synchronized (s) {//Input.class//Output.class//Res.class//ThreadConnection.class都行
				if(x == 0){
					s.name = "mike";
					s.sex = "man";
				}else{
					s.name = "李丽丽";
					s.sex = "女女女女";
				}
				x = (x + 1) % 2;
			}
		}
		
	}
	
}
class Output implements Runnable{
	Res s;
	public Output(Res r) {
		// TODO Auto-generated constructor stub
		this.s = r;
	}
	@Override
	public void run() {
		while(true){
			synchronized (s) {//Input.class//Output.class//Res.class//ThreadConnection.class都行
				System.out.println(s.name + "------" + s.sex);
			}
		}
	}
}
public class ThreadConnection {

	public static void main(String[] args) {
		Res res = new Res();
		Thread t1 = new Thread(new Input(res));
		Thread t2 = new Thread(new Output(res));
		
		t1.start();
		t2.start();
	}

}
