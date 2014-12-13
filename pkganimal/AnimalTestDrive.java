/**
 *3、多态的使用如果不使用ArrayList，自己写数组来保存对象时，自己创建的Dog专用list
 */
package pkganimal;
abstract class Animal3 {
    String name;
    abstract public void eat();
}

class Dog extends Animal3 {
    public void eat() {
        System.out.println("狗吃骨头");
    }
}

class Cat extends Animal3 {
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

class MyAnimalList {
    private Animal3[] animals = new Animal3[5];
    private int nextIndex = 0;
    
    public void add(Animal3 a) {
        if (nextIndex < animals.length) { 
            animals[nextIndex] = a;
            System.out.println("Animal added at " + nextIndex);
            nextIndex++;
        }
    }
}

public class AnimalTestDrive {
    public static void main(String[] args) {
        //在这里写代码
        MyAnimalList list = new MyAnimalList();
        Dog d = new Dog();
        Cat c = new Cat();
        list.add(d);
        list.add(c);
    }
}
