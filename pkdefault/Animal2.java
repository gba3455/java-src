package pkdefault;
/**
 * 
 * @author SQZS
 * 多态
 *
 */
import java.util.ArrayList;
public abstract class Animal2 {
	//Animal2[] animal = new Animal2[4];
	//static：静态方法，不需要new一个对象就可以调用它
	static Animal2[] animal = new Animal2[4];
    void eat() {
        System.out.println("动物在进食！");
    }

    void roam() {
        System.out.println("动物在活动！");
    }
    static void init(int i,Animal2 a){
    	animal[i] = a;
    }
    public static void main(String[] args) {
    	
        //在这里写代码
        //Animal2 an = new Animal2();
        Hippo hi = new Hippo();
        Wolf wo = new Wolf();
        Lion li = new Lion();
        Dog d = new Dog();
        init(0, hi);
        init(1, wo);
        init(2, li);
        init(3, d);
        /*这就是多态最强的地方，你可以将数组元素逐个调出来当做是animal来操作*/
        for(int i = 0; i < animal.length; i++){
        	animal[i].eat();
        	animal[i].roam();
        }
//        一旦数组被声明出来，你就只能装入所声明类型的元素。
//        但是你可以将byte放进int的数组中，因为byte
//        可以放进int尺寸的杯子中。这被称为隐含展开。
//        byte b = 127;
//        int[] in = new int[2];
//        in[0] = b;
        ArrayList<Animal2> arr = new ArrayList<Animal2>();
        arr.add(0,hi);
        arr.add(1,wo);
        arr.add(2,li);
        arr.add(3,d);
        System.out.println(arr.size());
    }
}
class Dog extends Animal2{
	
}

class Hippo extends Animal2 {
    void eat() {
        System.out.println("Hippo在进食！");
    }

    void roam() {
        System.out.println("Hippo在活动！");
    }
}

class Wolf extends Animal2 {
    void eat() {
        System.out.println("Wolf在进食！");
    }

    void roam() {
        System.out.println("Wolf在活动！");
    }
}

class Lion extends Animal2 {
    void eat() {
        System.out.println("Lion在进食！");
    }

    void roam() {
        System.out.println("LIon在活动！");
    }
}