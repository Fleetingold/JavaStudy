package com.mystudy.java8;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class JavaLocalDataTimeStudy02 {
	public static void main(String args[]){
		JavaLocalDataTimeStudy02 student = new JavaLocalDataTimeStudy02();
		student.testZonedDateTime();
	   }
	
	public void testZonedDateTime(){
	      // ��ȡ��ǰʱ������
	      ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
	      System.out.println("date1: " + date1);
	        
	      ZoneId id = ZoneId.of("Europe/Paris");
	      System.out.println("ZoneId: " + id);
	        
	      ZoneId currentZone = ZoneId.systemDefault();
	      System.out.println("����ʱ��: " + currentZone);
	   }
}
