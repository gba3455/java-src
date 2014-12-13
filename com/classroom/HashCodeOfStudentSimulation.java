package com.classroom;

public class HashCodeOfStudentSimulation {
	private int nid;
	private String sname;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public HashCodeOfStudentSimulation(int nid, String sname) {
		super();
		this.nid = nid;
		this.sname = sname;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return nid;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		//当学生学号相同 就认为两个对象相等
		if (this == obj) {
			return true;
		}
		//有可能obj是不同类型 所以用instanceof
		if (obj instanceof HashCodeOfStudentSimulation) {
			HashCodeOfStudentSimulation student = (HashCodeOfStudentSimulation)obj;
			if (this.nid == student.nid && this.sname.equals(student.sname)) {
				return true;
			}
		}
		return false;
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println("toString method");
		return super.toString();
	}
	public static void main(String[] args) {
		HashCodeOfStudentSimulation stu1 = new HashCodeOfStudentSimulation(1,"小红");
		HashCodeOfStudentSimulation stu2 = new HashCodeOfStudentSimulation(1,"小红");
		System.out.println("==" + (stu1 == stu2));
		System.out.println("equals " + stu1.equals(stu2));

		String s1 = "fda";
		String s2 = "fda";
		if (s1 == s2) {
			System.out.println("deng");
		}
	}
}
