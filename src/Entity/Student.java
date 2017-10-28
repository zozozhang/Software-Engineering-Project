package Entity;

import java.util.Iterator;
import java.util.List;

import Course.Course;
import MainScene.MainScene;

public class Student extends Entity {

//	private String ID;
//	private String firstName;
//	private String lastName;
	private List<Course> currentCourseArray;
	private List<Course> passedCourses;
	private String result;

	public Student(String ID, String password, String firstName, String lastName, String type, List<Course> currentCourseArray,
			List<Course> passedCourses) {
		
		super(ID, password, firstName, lastName, type);
		this.currentCourseArray = currentCourseArray;
		this.passedCourses = passedCourses;
	}

	public List<Course> getCurrentCourseArray() {
		return currentCourseArray;
	}
	
	public void setCurrentCourseArray(Course course) {
		this.currentCourseArray.add(course);
		System.out.println("You have successfully enrolled in " + course.getCourseName());
	}

	public List<Course> getPassedCourses() {
		return passedCourses;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	

	public Boolean assignCourse(Course enrolCourses) {
		return semesterPassed(enrolCourses);
	}

	public Boolean semesterPassed(Course enrolCourses) {

		int avaliableCourseSem = enrolCourses.getSemester();
		if (avaliableCourseSem == MainScene.currentSemester) {
			return capacityPassed(enrolCourses);
		} else {
			return false;
		}

	}

	public boolean capacityPassed(Course enrolCourses) {
		int count = enrolCourses.count();
		int capacity = enrolCourses.getCapacity();
		Student student = this;

		if (count >= capacity) {
			return false;
		} else {
			enrolCourses.setCount(student);
			return preReqPassed(enrolCourses);
		}
	}

	public Boolean preReqPassed(Course enrolCourses) {
		Course preReq = enrolCourses.getPreReq();
		Student student = this;

		if (preReq != null) {
			if (student.passedCourses.indexOf(preReq) != -1) {
				setCurrentCourseArray(enrolCourses);
				return true;
			} else {
				System.out.println(" You do not qualify for: " + enrolCourses.getCourseName());
				return false;
			}
		} else {
			setCurrentCourseArray(enrolCourses);
			return true;
		}
	}
	
	

	public Boolean withdrawFromCourse(Course course) {
		Student student = this;
		if (course.countList().indexOf(student) != -1) {
			course.removeCount(student);
			
			//scanns list of students in course array and removes the specific student from the subject. 
			for (Iterator<Course> iter = student.currentCourseArray.listIterator(); iter.hasNext();) {
				
				Course a = iter.next();
				
				//
				for (int i = 0; i < student.getCurrentCourseArray().size(); i++) {
					if (a == course) {
						iter.remove();
					}
				}
			}
			
			System.out.println("You successefully dropped out of: " + course.getCourseName());
			return true;
		} else {
			System.out.println("Something went wrong! Try again later.");
			return false;
		}

	}

}
