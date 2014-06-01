package com.classroom;

public class MEIDE extends AirConditioner{

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("MEIDE ON power is " + super.getPowerOfWind()
				+ "direction is" + super.getWindDirection());
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("MEIDE OFF");
	}
	
}
