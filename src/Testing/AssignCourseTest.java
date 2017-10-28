package Testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Course.Course;
import Entity.Student;
import MainScene.MainScene;

public class AssignCourseTest {

	Student mark;
	Student ross;
	Student zoe;
	Student jiang;
	Student max;
	
	@Before
	public void setUp() {
		
		MainScene.main(null);
		
		mark = new Student("s3603887", "1", "Mark", "Di Dio", "student", MainScene.enrolCourseArray, MainScene.passedCourseArray);
		ross = new Student("s3601834", "1", "Ross", "Tsingos", "student", MainScene.enrolCourseArray, MainScene.passedCourseArray);
		zoe = new Student("s3601834", "1", "Zoe", "Zhang", "student", MainScene.enrolCourseArray, MainScene.passedCourseArray);
		jiang = new Student("s3601834","1", "Jiang", "--", "student", MainScene.enrolCourseArray, MainScene.passedCourseArray);
		max = new Student("s3603887","1", "Max", "Black", "student", MainScene.enrolCourseArray, MainScene.passedCourseArray);
	}
	
	
	//Tests to see whether the course is running in the current semester.
	//All the courses I want to enrol in are sem 2 and passes courses are sem 1
	@Test
	public void semesterTest() {
		//Attempts to add Mark to course 'Web'
		//Web is only running in semester 1 
		//Will fail as it is currently semester 2
		boolean output = mark.semesterPassed(MainScene.web);
		assertFalse(output);
	}
	//Method found in Entity//Student.java

	//Tests to see whether there is room for a student to be added to it.
	@Test
	public void capacityTest() {
		//Sets the capacity to 1 for demonstration purposes.
		MainScene.iPhone.setCapacity(1);
		//Adds one student to iPhone course
		ross.assignCourse(MainScene.iPhone);
		//Attempts to add another student but will fail as the capacity is full
		boolean output = mark.capacityPassed(MainScene.iPhone);
		assertFalse(output);
	}
	//Method found in Entity//Student.java
	
	//Tests to see if a student has the required prerequisites to enrol into the course 
	@Test
	public void preReqTest() {
		//Adds students with prerequisites to course iPhone
		boolean output = mark.assignCourse(MainScene.iPhone);
		ross.assignCourse(MainScene.iPhone);
		assertTrue(output);
		System.out.print(MainScene.iPhone.count());
	}
	//Method found in Entity//Student.java
	

}
