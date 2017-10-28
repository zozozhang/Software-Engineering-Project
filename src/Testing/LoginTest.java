package Testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Entity.Admin;
import Entity.Entity;
import Entity.Student;
import MainScene.Login;
import MainScene.MainScene;

public class LoginTest {
	
	//Setuo Student, refrence login class
	Student mark;
	Login login = new Login();
	private Admin admin;

	@Before
	public void setUp() {
		//adds mark student 
		mark = new Student("s3603887", "1", "Mark", "Di Dio", "student", MainScene.enrolCourseArray, MainScene.passedCourseArray);
	}
	
	//Determines who is currently logged in, Admin, Student or Staff
	@Test
	public void test() {
		//Will log in an admin and display feedback to show which entity has logged in.
//		String output = login.userlogin("admin", "pass");
		//Will return true if username and password are correct. the feedback will determine who has logged in.
//		assertEquals("admin", output);
	}
	//Method found in MainScene//Login.java

}
