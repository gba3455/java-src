package com.classroom;

public class GELI extends AirConditioner{

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("GELI ON power is " + super.getPowerOfWind()
				+ "direction is" + super.getWindDirection());
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("GELI OFF");
	}

}
