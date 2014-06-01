interface ChangingWind{
	void turnWind(int power,boolean directing);
}
public abstract class AirConditioner {
	private int powerOfWind,windDirection;
	public double coldParam,powerParam;
	public int getPowerOfWind() {
		return powerOfWind;
	}
	public void setPowerOfWind(int powerOfWind) {
		this.powerOfWind = powerOfWind;
	}
	public int getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(int windDirection) {
		this.windDirection = windDirection;
	}
	abstract void turnOn();
	abstract void turnOff();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GELI gl = new GELI();
		gl.turnOn();
		gl.turnWind(10, true);
		gl.coldParam = 100;
		gl.powerParam = 100;
		gl.turnOff();
	}
}

class GELI extends AirConditioner implements ChangingWind{
	public void turnOn(){
		System.out.println("GELI to be ON");
	}
	public void turnOff(){
		System.out.println("GELI to be OFF");
	}
	public void turnWind(int power,boolean directing){
		System.out.println("GELI power is" + power + "方向" + directing);
	}
}
class MEIDE extends AirConditioner implements ChangingWind{
	public void turnOn(){
		System.out.println("MEIDE to be ON");
	}
	public void turnOff(){
		System.out.println("MEIDE to be OFF");
	}
	public void turnWind(int power,boolean directing){
		System.out.println("MEIDE power is" + power + "方向" + directing);
	}
}
