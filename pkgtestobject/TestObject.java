package pkgtestobject;
import java.util.ArrayList;
class Animal {
    String name;
    void eat() {
        System.out.println("动物吃东西啦");
    }
}

class Dog extends Animal {}
class Cat extends Animal {}

public class TestObject {
    public static void main(String[] args) {
        Dog a = new Dog();
        Cat c = new Cat();
        /*使用equals方法*/
        if (a.equals(c)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        System.out.println(c.getClass());
        System.out.println(a.hashCode());
        System.out.println(c.toString());
        
        ArrayList<Object> arr = new ArrayList<Object>();
        arr.add(a);
        arr.add(c);
        Object oa = arr.get(0);
        Object oc = arr.get(1);
        //任何从ArrayList<Object>取出的东西
//        都会被当作Object类型的引用而不管它原来是什么。
//        无论放进去的对象是什么，出来后都变成Object。
        //oa.eat();//不能这么做，因为Object根本就不知道什么是eat()
        ((Dog)oa).eat();
        ((Cat)oc).eat();
        //仿照上面的调用其他的方法吧
    }
}