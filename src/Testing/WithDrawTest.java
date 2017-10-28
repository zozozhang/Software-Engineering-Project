package Testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Entity.Student;
import MainScene.MainScene;

public class WithDrawTest {
	
	Student mark;
	Student ross;
	Student zoe;
	Student jiang;
	Student max;
	
	@Before
	public void setUp() {
		
		MainScene.main(null);
		
		//Defining/constructing students using id,name,cources to enrol in and past courses 
		mark = new Student("s3603887", "1", "Mark", "Di Dio", "student", MainScene.enrolCourseArray, MainScene.passedCourseArray);
		ross = new Student("s3601834", "1", "Ross", "Tsingos", "student", MainScene.enrolCourseArray, MainScene.passedCourseArray);
		zoe = new Student("s3601834", "1", "Zoe", "Zhang", "student", MainScene.enrolCourseArray, MainScene.passedCourseArray);
		jiang = new Student("s3601834", "1", "Jiang", "--", "student", MainScene.enrolCourseArray, MainScene.passedCourseArray);
		max = new Student("s3603887", "1", "Max", "Black", "student", MainScene.enrolCourseArray, MainScene.passedCourseArray);
		
		//Adds a student to iphone course to be removed
		mark.assignCourse(MainScene.iPhone);
		System.out.println(MainScene.iPhone.count());
	}

	//Tests the function that will remove a student from a course.
	@Test
	public void test() {
		//Will return true when Mark has successfully been removed from the iPhone course.
		boolean output = mark.withdrawFromCourse(MainScene.iPhone);
		assertTrue(output);
		//Demonstrates that the courses count will reduce.
		System.out.print(MainScene.iPhone.count());
	}
	//Method found in Entity//Student.java

}
