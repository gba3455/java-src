package pkdefault;
/**
 * 
 * @author SQZS
 * 调用父类的方法

如果创建出一个具体的子类且必须要覆盖某个方法，
但又需要执行父类的方法时要怎么办？也就是说不
打算完全地覆盖掉原来的方法，只是要加入额外的动作
要怎么做？super这个关键句能让你在子类中调用父类的方法。
 *
 */
abstract class Report {
    void runReport() {
        System.out.println("设置报告");
    }
    
    void printReport(){
        System.out.println("输出报告");
    }
}

public class SuperMethod extends Report {
    void runReport() {
        //在这里写代码
        super.runReport();
        System.out.println("子类输出报告");
    }
    
    public static void main(String[] args) {
    	SuperMethod br = new SuperMethod();
        br.runReport();
    }
} 