package com.flyofinterface;
/**
 * 
 *为什么可以赋值给接口，然后用接口调用对象里的方法？

赋值给接口调用和我直接用对象调用bd.fly()有什么区别？
 * @author SQZS
第一个问题，接口不能实例化

第二个问题

Bird bd = new Bird();FlyOfInterface foi = bd;假定这是第一种，

Bird bd = new Bird()这是第二种

两者的区别：第一种体现了多态性，但是第一种foi不能调用Bird中自定义的方法，只能调用重载的方法
 */
public class FlyDemo {
	public static void main(String[] args) {
		Bird bd = new Bird();
		Airplane ap = new Airplane();
		FlyOfInterface foi = bd;
		foi.fly();
		FlyOfInterface fio2 = ap;
		fio2.fly();
		//fio2.eat();
		bd.fly();
		bd.equals(ap);
		
	}
}
