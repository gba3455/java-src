package pkghomework14;

public class Person {
	public int id;
	public String name;
	public String sex;
	public Person(int id, String name, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == this){
			return true;
		}
		if(obj instanceof Person){
			Person p = (Person)obj;
			if(p.id == this.id){
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id" + id + "名字" + name + "性别" + sex;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
