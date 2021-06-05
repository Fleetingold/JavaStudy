package com.designpattern.j2ee.mvc;

public class MVCPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//从数据库获取学生记录
		Student model = retrieveStudentFromDatabase();
		
		//创建一个视图: 把学生详细信息输出到控制台
		StudentView view = new StudentView();
		
		StudentController controller = new StudentController(model, view);
		
		controller.updateView();
		
		//更新模型数据
		controller.setStudentName("John");
		
		controller.updateView();
	}

	private static Student retrieveStudentFromDatabase() {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setName("Robert");
		student.setRollNo("10");
		return student;
	}

}
