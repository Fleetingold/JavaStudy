package com.designpattern.j2ee.transferobject;

import java.util.ArrayList;
import java.util.List;

public class StudentBO {

	//列表是当作一个数据库
	List<StudentVO> students;
	
	public StudentBO() {
		// TODO Auto-generated constructor stub
		students = new ArrayList<StudentVO>();
		StudentVO student1 = new StudentVO("Robert", 0);
		StudentVO student2 = new StudentVO("John", 1);
		students.add(student1);
		students.add(student2);
	}
	
	public List<StudentVO> getAllStudents() {
		// TODO Auto-generated method stub
		return students;
	}

	public StudentVO getStudent(int rollNo) {
		// TODO Auto-generated method stub
		return students.get(rollNo);
	}

	public void updateStudent(StudentVO student) {
		// TODO Auto-generated method stub
		students.get(student.getRollNo()).setName(student.getName());
		System.out.println("Student: Roll No " + student.getRollNo() + ", update in the database");
	}

	public void deleteStudent(StudentVO student) {
		// TODO Auto-generated method stub
		students.remove(student.getRollNo());
		System.out.println("Student: Roll No " + student.getRollNo() + ", delete from database");
	}
}
