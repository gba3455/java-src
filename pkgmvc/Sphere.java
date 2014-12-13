package pkgmvc;

import java.util.Observable;
import java.util.Observer;

//model
//Model类Sphere，必须扩展Observable类，
//因为在Observable类中，方法addObserver()将视图与模型相关联，
//当模型状态改变时，通过方法notifyObservers()通知视图。
public class Sphere extends Observable{
	public Sphere(double myRadius, double volume, double surfaceArea) {
		super();
		this.myRadius = myRadius;
		this.volume = volume;
		this.surfaceArea = surfaceArea;
	}
	double myRadius = 0;
	double volume = 0;
	double surfaceArea = 0;
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getSurfaceArea() {
		return surfaceArea;
	}
	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
	public void setRadius(double r){
		myRadius = r;
		setChanged();
		notifyObservers();
	}
	public double getRadius(){
		return myRadius;
	}
	@Override
	public synchronized void addObserver(Observer o) {
		// TODO Auto-generated method stub
		super.addObserver(o);
	}
}
