/**
 * 
 * @author SQZS
 * 多态
 *
 */
package pkganimal;
public interface AnimalOfInterface {
    public void eat();
    public void roam();
    public void bark();
}

class Canine{
	
}
class Feline{
	
}
class Hippo2 extends Canine implements AnimalOfInterface{
    public void eat() {
        System.out.println("Hippo在进食！");
    }

    public void roam() {
        System.out.println("Hippo在活动！");
    }
    public void bark(){
    	System.out.println("Hippo在叫");
    }
    public static void main(String[] args) {
        //在这里写代码
    	AnimalOfInterface[] animal = new AnimalOfInterface[3];
        animal[0] = new Hippo2();
        animal[1] = new Wolf2();
        animal[2] = new Lion2();
        /*这就是多态最强的地方，你可以将数组元素逐个调出来当做是animal来操作*/
        for(int i = 0; i < animal.length; i++){
            animal[i].eat();
            animal[i].roam();
            animal[i].bark();
        }
    }
}

class Wolf2 extends Canine implements AnimalOfInterface {
	public void eat() {
        System.out.println("Wolf在进食！");
    }

	public void roam() {
        System.out.println("Wolf在活动！");
    }
	public void bark(){
    	System.out.println("Wolf在叫");
    }
}

class Lion2 extends Feline implements AnimalOfInterface {
	public void eat() {
        System.out.println("Lion在进食！");
    }

	public void roam() {
        System.out.println("Lion在活动！");
    }
	public void bark(){
    	System.out.println("Lion在叫");
    }
}