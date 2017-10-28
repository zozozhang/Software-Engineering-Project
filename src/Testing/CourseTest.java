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

public class CourseTest {

	Student mark;

	@Before
	public void setUp() {
		
		MainScene.main(null);
		mark = new Student("s3603887", "1", "Mark", "Di Dio", "student", MainScene.enrolCourseArray, MainScene.passedCourseArray);
		
	}

	//Tests the counting function to determine how many courses are in the array.
	@Test
	public void numberTest() {
		//Gets the returned integer 
		int output = MainScene.numberOfCourses(MainScene.passedCourseArray);
		//compares the values 
		assertEquals(4, output);
	}
	//Method found in MainScene//MainScene.java
	
	//Sets the result for the iPhone course to Mark.
	@Test
	public void resultsTest() {
		//Sets Mark's score to "HD" for the course iPhone.
		MainScene.iPhone.setStudentResult(mark, "HD");
		//compares the values
		assertEquals("HD", mark.getResult());
	}
	//Method found in Course//Course.java

}