package com.classroom;

public class TestAirCon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GELI geli = new GELI();
		geli.setPowerOfWind(1);
		geli.setWindDirection("left");
		geli.turnOn();
		geli.turnOff();
		MEIDE meide = new MEIDE();
		meide.setPowerOfWind(100);
		meide.setWindDirection("Right");
		meide.turnOn();
		meide.turnOff();
	}

}
