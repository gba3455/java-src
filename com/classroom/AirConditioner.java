package com.classroom;

public abstract class AirConditioner implements ChangingWind{
	private int powerOfWind;
	private String windDirection;
	public int getPowerOfWind() {
		return powerOfWind;
	}
	public void setPowerOfWind(int powerOfWind) {
		this.powerOfWind = powerOfWind;
	}
	public String getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}
	public abstract void turnOn();
	public abstract void turnOff();
	
}
