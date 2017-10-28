package Course;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import Entity.Lecturer;
import Entity.Student;
import MainScene.MainScene;

public class Course {

	private String courseID;
	private String name;
	private String subject;
	private Course preReq;
	private int semester;
	private int year;
	private int capacity;
	private List<Student> count;

	// constructor
	public Course(String coID, String coName, String coSubject, Course coPreReq, int semester, int year, int capacity,
			List<Student> count) {
		this.courseID = coID;
		this.name = coName;
		this.subject = coSubject;
		this.preReq = coPreReq;
		this.semester = semester;
		this.year = year;
		this.capacity = capacity;
		this.count = count;
	}

	public String getCourseID() {
		return courseID;
	}

	public String getCourseName() {
		return name;
	}

	public String getSubject() {
		return subject;
	}

	public Course getPreReq() {
		return preReq;
	}

	public int getSemester() {
		return semester;
	}

	public int getYear() {
		return year;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int cap) {
		this.capacity = cap;
	}

	public int count() {
		return count.size();
	}

	public List<Student> countList() {
		return count;
	}

	public void setCount(Student student) {
		this.count.add(student);
	}

	public void removeCount(Student student) {
		this.count.remove(student);
	}

	public void setStudentResult(Student student, String result) {
		student.setResult(result);
	}

	public static void createNewCourse() {
		String ID = createCourseID();
		String name = createCourseName();
		String sub = createCourseSub();
		Course preReq = createCoursePreReq();
		int semester = createSemester();
		int year = createYear();
		int capacity = createCapacity();

		System.out.println("Review Course:");
		System.out.printf("ID: %s, Name: %s, Subject: %s, Pre-requisites: %s, Semester: %d, Year: %d, Capacity: %d", ID,
				name, sub, preReq.getCourseName(), semester, year, capacity);
		System.out.println("\nConfirm? (Y/N)");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.nextLine();
		if (choice.equals("Y") || choice.equals("y")) {

			Course newCourse = new Course(ID, name, sub, preReq, semester, year, capacity, null);
			addCourse(newCourse);

		} else {
			System.out.println("Course canceled.");
			MainScene.displayMenu(MainScene.currentAdmin);
		}

	}

	private static String createCourseID() {
		System.out.println("Enter Course ID:");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	private static String createCourseName() {
		System.out.println("Enter Course Name:");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	private static String createCourseSub() {
		return "COSUB";
	}

	private static Course createCoursePreReq() {
		System.out.println("Does this course have pre-requisites? (Y/N)");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.nextLine();
		if (choice.equals("Y") || choice.equals("y")) {
			System.out.println("Choose a course:");
			for (int i = 0; i < MainScene.courseArray.size(); i++) {
				System.out.println(" - " + MainScene.courseArray.get(i).getCourseName() + " - Press " + i);
			}
			Scanner scanner2 = new Scanner(System.in);
			return MainScene.courseArray.get(scanner2.nextInt());
		} else {
			return null;
		}
	}

	private static int createSemester() {
		System.out.println("Which semester will this course run?\n - Semester 1 - Press 1\n - Semester 2 - Press 2");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	private static int createYear() {
		return 2017;
	}

	private static int createCapacity() {
		System.out.println("What is the capacity?");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	public static void addCourse(Course course) {

		try {
			Path path = Paths.get("/Users/markdidio/Desktop/Courses.txt");

			List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

			int position = lines.size();
			String extraLine = String.format("%s;%s;%s;%s;%d;%d;%d;null", course.getCourseID(), course.getCourseName(),
					course.getSubject(), course.getPreReq().getCourseName(), course.getSemester(), course.getYear(),
					course.getCapacity());

			lines.add(position, extraLine);
			Files.write(path, lines, StandardCharsets.UTF_8);

			System.out.printf("%s was successfully created.", course.getCourseName());

		} catch (IOException ex) {
			System.out.println("Error");
		}

	}

	public static void addOffering(Course course) {
		try {
			Path path = Paths.get("/Users/markdidio/Desktop/CourseOfferings.txt");

			List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

			int position = lines.size();
			String preReq = null;
			
			if (course.getPreReq() != null) {
				preReq = course.getPreReq().getCourseName();
			} else {
				preReq = "null";
			}
			
			String extraLine = String.format("%s;%s;%s;%s;%d;%d;%d;null", course.getCourseID(), course.getCourseName(),
					course.getSubject(), preReq, course.getSemester(), course.getYear(),
					course.getCapacity());

			lines.add(position, extraLine);
			Files.write(path, lines, StandardCharsets.UTF_8);

			System.out.printf("%s was successfully created.", course.getCourseName());

		} catch (IOException ex) {
			System.out.println("Error");
		}

	}

	public void printDetails() {
		System.out.println("Course ID: " + courseID);
		System.out.println("Course name: " + name);
		System.out.println("Course Subject: " + subject);
		System.out.println("Course pre-requisite: " + preReq);
		System.out.println("************************************************");
	}

	public boolean confirmLec(String lecturer) {
		// TODO Auto-generated method stub
		return false;
	}

}
