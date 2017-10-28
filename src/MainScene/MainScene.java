package MainScene;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Course.Course;
import Entity.Entity;
import Entity.Lecturer;
import Entity.Admin;
import Entity.Coordinator;
import Entity.Student;
import MainScene.Login;

public class MainScene {

	public static List<Course> enrolCourseArray = new ArrayList<Course>();
	public static List<Course> passedCourseArray = new ArrayList<Course>();
	public static List<Course> currentCourseArray = new ArrayList<Course>();
	public static List<Course> courseArray = new ArrayList<Course>();

	public static List<Student> iPhoneCount = new ArrayList<Student>();

	public static List<Student> studentList = new ArrayList<Student>();
	public static List<Admin> adminList = new ArrayList<Admin>();
	public static List<Coordinator> coordinatorList = new ArrayList<Coordinator>();
	public static List<Lecturer> lecturerList = new ArrayList<Lecturer>();

	static Student mark;
	static Student ross;
	static Student zoe;
	static Student jiang;
	static Student max;

	static Admin john;
	static Coordinator bek;

	public static Admin admin;
	public static Student student;

	public static Course prog = new Course("CSID", "Programming 1", "COSUB", null, 1, 2017, 40, null);
	public static Course comp = new Course("CSID", "Computer Systems", "COSUB", null, 1, 2017, 40, null);
	public static Course web = new Course("CSID", "Web Development", "COSUB", null, 1, 2017, 40, null);
	public static Course data = new Course("CSID", "Data Communication", "COSUB", null, 1, 2017, 40, null);

	public static Course SEF = new Course("CSID", "Software Eng Fundermentals", "COSUB", prog, 2, 2017, 40,
			iPhoneCount);
	public static Course iPhone = new Course("CSID", "iPhone Software Eng", "COSUB", prog, 2, 2017, 40, iPhoneCount);
	public static Course security = new Course("CSID", "Security in Systems", "COSUB", null, 2, 2017, 40, iPhoneCount);
	public static Course database = new Course("CSID", "Database", "COSUB", null, 2, 2017, 40, iPhoneCount);

	public static int currentSemester = 2;
	public static Student currentStudent;
	public static Admin currentAdmin;
	public static Coordinator currentCoordinator;

	public MainScene() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Locations of files to load
		loadFiles("/Users/markdidio/Desktop/Courses.txt", "course");
		loadFiles("/Users/markdidio/Desktop/CourseOfferings.txt", "courseOfferings");
		loadFiles("/Users/markdidio/Desktop/Lecturer.txt", "lecturer");

		//Sets up students
		mark = new Student("s3603887", "123456", "Mark", "Di Dio", "student", MainScene.currentCourseArray,
				MainScene.passedCourseArray);
		ross = new Student("s3601834", "654321", "Ross", "Tsingos", "student", MainScene.currentCourseArray,
				MainScene.passedCourseArray);
		zoe = new Student("s3601834", "1", "Zoe", "Zhang", "student", MainScene.currentCourseArray,
				MainScene.passedCourseArray);
		jiang = new Student("s3601834", "2", "Jiang", "--", "student", MainScene.currentCourseArray,
				MainScene.passedCourseArray);
		max = new Student("s3603887", "3", "Max", "Black", "student", MainScene.currentCourseArray,
				MainScene.passedCourseArray);

		//Adds to list
		studentList.add(mark);
		studentList.add(ross);
		studentList.add(zoe);
		studentList.add(jiang);
		studentList.add(max);

//		 If I remove this course it will fail
		 passedCourseArray.add(prog);
		 passedCourseArray.add(comp);
		 passedCourseArray.add(web);
		 passedCourseArray.add(data);

		// courseArray.add(SEF);
		// enrolCourseArray.add(iPhone);
		// enrolCourseArray.add(security);
		// enrolCourseArray.add(database);

		 //Sets up other entities
		john = new Admin("e1234567", "password", "John", "Smith", "admin");
		bek = new Coordinator("c1234567", "password", "Bek", "Smith", "coordinator");

		adminList.add(john);
		coordinatorList.add(bek);

		//Begin 
		ask();

	}

	//Loads in the files into the array lists
	public static void loadFiles(String destination, String type) {
		// This will reference one line at a time
		String line = null;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(destination);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				//splits the line into seperate parts
				String[] tokens = line.split(";");
				switch (type) {
				case "course":
					if (tokens[3].equals("null")) {
						courseArray.add(new Course(tokens[0], tokens[1], tokens[2], null, Integer.parseInt(tokens[4]),
								Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]), null));
					} else {
						for (int i = 0; i < courseArray.size(); i++) {
							if (tokens[3].equals(courseArray.get(i).getCourseName())) {
								courseArray.add(new Course(tokens[0], tokens[1], tokens[2], courseArray.get(i), Integer.parseInt(tokens[4]),
										Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]), null));
							}
						}
					}
					break;
				case "courseOfferings":
					if (tokens[3].equals("null")) {
						enrolCourseArray.add(new Course(tokens[0], tokens[1], tokens[2], null, Integer.parseInt(tokens[4]),
								Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]), null));
					} else {
						for (int i = 0; i < enrolCourseArray.size(); i++) {
							if (tokens[3].equals(enrolCourseArray.get(i).getCourseName())) {
								enrolCourseArray.add(new Course(tokens[0], tokens[1], tokens[2], enrolCourseArray.get(i), Integer.parseInt(tokens[4]),
										Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]), null));
							}
						}
					}
					break;
				case "lecturer":
					lecturerList.add(
							new Lecturer(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], currentCourseArray));
					break;
				}
			}
			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + destination + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + destination + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
	}

	public static void ask() {
		Login loginClass = new Login();
		System.out.println("Coordinator - Press 1\nAdmin - Press 2\n" + "Student - Press 3");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		if (number == 1) {
			loginClass.coordinatorLoginPrompt();
		} else if (number == 2) {
			loginClass.adminLoginPrompt();
		} else if (number == 3) {
			loginClass.studentLoginPrompt();
		}
	}

	public static void displayMenu(Entity entity) {
		if (entity.getType() == "coordinator") {
			System.out.println("Welcome to Course Management System Program Coordinator Console\n"
					+ "Add new course - Press 1\n" + "Grant exemption - Press 2\n" + "Grant Special Permissions");
			Scanner scanner = new Scanner(System.in);
			delegateOption(entity, scanner.nextInt());
		} else if (entity.getType() == "admin") {
			System.out.println(
					"Welcome to Course Management System Admin Console\n" + "Add new course offerings - Press 1\n"
							+ "Assign lecturer to course - Press 2\n" + "Advance system to next week - Press 3\n"
							+ "View past performace of students - Press 4\n" + "Log Out - Press 5");
			Scanner scanner = new Scanner(System.in);
			delegateOption(entity, scanner.nextInt());
		} else if (entity.getType() == "student") {
			System.out.println("Welcome to Course Management System Student Console\n" + "Enrol - Press 1\n"
					+ "View offerings - Press 2\n" + "Drop Course - Press 3\n" + "Log Out - Press 4");
			Scanner scanner = new Scanner(System.in);
			delegateOption(entity, scanner.nextInt());
		} else {
			System.out.println("Ouch");
		}
	}

	public static void delegateOption(Entity entity, int option) {

		if (entity.getType() == "coordinator") {
			if (option == 1) {
				Course.createNewCourse();
			}
		} else if (entity.getType() == "admin") {
			if (option == 1) {
				System.out.println("Select Course:");
				for (int i = 0; i < courseArray.size(); i++) {
					System.out.println(" - " + courseArray.get(i).getCourseName() + " - Press " + i);
				}

				System.out.println("\nGO BACK - Press " + courseArray.size());
				Scanner scanner = new Scanner(System.in);
				int index = scanner.nextInt();
				Course.addOffering(courseArray.get(index));
			}
			if (option == 2) {
				System.out.println("Search lecturer:");
				for (int i = 0; i < lecturerList.size(); i++) {
					System.out.println(" - " + lecturerList.get(i).getFirstName() + " "
							+ lecturerList.get(i).getLastName() + " - Press " + i);
				}

				System.out.println("\nGO BACK - Press 9");
				Scanner scanner = new Scanner(System.in);
				int index = scanner.nextInt();
				Lecturer selectedLect = lecturerList.get(index);

				System.out.printf("Assign %s %s to course:\n", selectedLect.getFirstName(), selectedLect.getLastName());
				for (int i = 0; i < enrolCourseArray.size(); i++) {
					System.out.println(" - " + enrolCourseArray.get(i).getCourseName() + " - Press " + i);
				}

				System.out.println("\nGO BACK - Press 9");
				Scanner scanner2 = new Scanner(System.in);
				selectedLect.assignCourse(enrolCourseArray.get(scanner2.nextInt()), index);

			} else if (option == 2) {

			}
		}

		if (entity.getType() == "student") {
			if (option == 1) {
				System.out.println("Avaliable Classes:");
				System.out.println("Select Course to enrol into.");
				for (int i = 0; i < getOfferings().size(); i++) {
					System.out.println(" - " + getOfferings().get(i).getCourseName() + " - Press " + i);
				}

				System.out.println("\nGO BACK - Press 9");
				Scanner scanner = new Scanner(System.in);

				currentStudent.assignCourse(getOfferings().get(scanner.nextInt()));

				if (scanner.nextInt() == 9) {
					displayMenu(currentStudent);
				} else {
					System.out.print(currentStudent.getCurrentCourseArray());
					System.out.println("\nGO BACK - Press 9");
					if (scanner.nextInt() == 9) {
						displayMenu(currentStudent);
					}
				}

			} else if (option == 2) {
				System.out.println("Avaliable Classes:");
				for (int i = 0; i < getOfferings().size(); i++) {
					System.out.println(" - " + getOfferings().get(i).getCourseName());
				}
				Scanner scanner = new Scanner(System.in);
				System.out.println("\nGO BACK - Press 9");
				if (scanner.nextInt() == 9) {
					displayMenu(currentStudent);
				}

			} else if (option == 3) {

				System.out.println("Enrolled Classes:");
				for (int i = 0; i < currentStudent.getCurrentCourseArray().size(); i++) {
					System.out.println(currentStudent.getCurrentCourseArray().get(i).getCourseName() + " - Press " + i);
				}
				Scanner scanner = new Scanner(System.in);
				if (currentStudent.getCurrentCourseArray().size() == 0) {
					System.out.println("No courses to drop.");
					System.out.println("\nGO BACK - Press 9");
					if (scanner.nextInt() == 9) {
						displayMenu(currentStudent);
					}
				} else {
					System.out.println("Select course to drop.");
					currentStudent.withdrawFromCourse(currentStudent.getCurrentCourseArray().get(scanner.nextInt()));
				}
			}
		}
	}

	public static List<Course> getOfferings() {
		List<Course> offerings = new ArrayList<Course>();
		offerings.addAll(enrolCourseArray);

		for (Iterator<Course> iter = offerings.listIterator(); iter.hasNext();) {
			Course a = iter.next();
			for (int i = 0; i < currentStudent.getCurrentCourseArray().size(); i++) {
				if (a == currentStudent.getCurrentCourseArray().get(i)) {
					iter.remove();
				}
			}
		}

		return offerings;
	}

	public static int numberOfCourses(List<Course> courseArray) {
		return courseArray.size();
	}

	public static int contains(List<Course> courseArray, String keyWord) {
		int count = 0;

		for (int i = 0; i < courseArray.size(); i++) {
			if (courseArray.get(i).getCourseName().toLowerCase().indexOf(keyWord.toLowerCase()) != -1) {
				count++;
			}
		}
		return count;
	}

}
