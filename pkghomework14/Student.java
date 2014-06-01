package pkghomework14;

public class Student {
	String sid;
	String sname;
	String sex;
	public Student(String sid, String sname, String sex) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Integer.parseInt(sid);
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj == this){
			return true;
		}
		if(obj instanceof Student){
			Student s = (Student)obj;
			if(s.sid == this.sid){
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "学号" + sid + "名字" + sname + "性别" + sex;
	}
}
