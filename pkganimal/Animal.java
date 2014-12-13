/**
 * 
 * @author SQZS
 * 多态
 *
 */
package pkganimal;
public abstract class Animal {
    void eat() {
        System.out.println("动物在进食！");
    }

    void roam() {
        System.out.println("动物在活动！");
    }
    abstract void bark();

    public static void main(String[] args) {
        //在这里写代码
        Animal[] animal = new Animal[4];
        animal[0] = new Hippo();
        animal[1] = new Wolf();
        animal[2] = new Lion();
        animal[3] = new Hippo();
        /*这就是多态最强的地方，你可以将数组元素逐个调出来当做是animal来操作*/
        for(int i = 0; i < animal.length; i++){
            animal[i].eat();
            animal[i].roam();
            animal[i].bark();
        }
    }
}

class Hippo extends Animal {
    void eat() {
        System.out.println("Hippo在进食！");
    }

    void roam() {
        System.out.println("Hippo在活动！");
    }
    void bark(){
    	System.out.println("Hippo在叫");
    }
}

class Wolf extends Animal {
    void eat() {
        System.out.println("Wolf在进食！");
    }

    void roam() {
        System.out.println("Wolf在活动！");
    }
    void bark(){
    	System.out.println("Wolf在叫");
    }
}

class Lion extends Animal {
    void eat() {
        System.out.println("Lion在进食！");
    }

    void roam() {
        System.out.println("Lion在活动！");
    }
    void bark(){
    	System.out.println("Lion在叫");
    }
}