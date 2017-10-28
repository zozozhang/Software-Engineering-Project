package Testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Course.Course;
import MainScene.MainScene;

public class ContainsComputingTest {
	
	@Before
	public void setUp() {
		
		MainScene.main(null);
		
	}

	//Search function that determines if courses are stored correctly in the course array.
	@Test
	public void test() {
		//Uses the keyword: "Comp" to search through the course array
		//A counter is increased whenever the keyword is found.
		int output = MainScene.contains(MainScene.passedCourseArray, "Comp");
		//As there is only one course with "Comp" in it, it will return 1
		assertEquals(1, output);
	}
	//Method found in MainScene//MainScene.java

}
