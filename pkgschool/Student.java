package pkgschool;


public class Student {
	static int classNum;
	String name;
	int age;
	float score;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	void setClassNum(int c){
		classNum = c;
	}
	int getClassNum(){
		return classNum;
	}
	void setName(String n){
		name = n;
	}
	String getName(){
		return name;
	}
	void setAge(int a){
		age = a;
	}
	int getAge(){
		return age;
	}
	void setScore(float s){
		score = s;
	}
	float getScore(){
		return score;
	}
	void init(){
		name = "xiaoming";
		age = 16;
		score = 90;
		classNum = 1;
	}
	void init(String n,int a,float s,int c){
		name = n;
		age = a;
		score = s;
		classNum = c;
	}
	void speak(){
		System.out.println("say chinese...");
	}
}
