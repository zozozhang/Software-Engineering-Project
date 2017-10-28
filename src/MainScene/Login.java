package MainScene;

import java.util.List;
import java.util.Scanner;

import Course.Course;
import Entity.Admin;
import Entity.Coordinator;
import Entity.Entity;
import Entity.Student;

public class Login {

	private String ID;
	private String password;

	private Admin admin;
	private Student student;
	private Coordinator coordinator;

	public void studentLoginPrompt() {
		System.out.println("Enter your student ID: ");
		Scanner scanner = new Scanner(System.in);
		ID = scanner.nextLine();

		System.out.println("Enter your password: ");
		scanner = new Scanner(System.in);
		password = scanner.nextLine();

		studentExistanceCheck(MainScene.studentList, ID, password);

	}

	public static void studentExistanceCheck(List<Student> studentArray, String ID, String password) {

		for (int i = 0; i < studentArray.size(); i++) {
			if (studentArray.get(i).getID().toLowerCase().indexOf(ID.toLowerCase()) != -1) {
				
				studentLogin(ID, password, studentArray.get(i));
				
				break;
			}
		}
	}
	
	public static void studentLogin(String ID, String password, Student currentEntity) {

		if (ID.equals(currentEntity.getID()) && (password.equals(currentEntity.getPassword()))) {
			System.out.println("Successfully logged in!");
			MainScene.currentStudent = currentEntity;
			MainScene.displayMenu(MainScene.currentStudent);
		} else {
			System.out.println("Wrong password");
		}
	}
	
	
	
	
	
	public void adminLoginPrompt() {
		System.out.println("Enter your admin ID: ");
		Scanner scanner = new Scanner(System.in);
		ID = scanner.nextLine();

		System.out.println("Enter your password: ");
		scanner = new Scanner(System.in);
		password = scanner.nextLine();

		adminExistanceCheck(MainScene.adminList, ID, password);

	}

	public static void adminExistanceCheck(List<Admin> adminArray, String ID, String password) {

		for (int i = 0; i < adminArray.size(); i++) {
			if (adminArray.get(i).getID().toLowerCase().indexOf(ID.toLowerCase()) != -1) {
				adminLogin(ID, password, adminArray.get(i));
			}
		}
	}
	
	public static void adminLogin(String ID, String password, Admin currentEntity) {

		if (ID.equals(currentEntity.getID()) && (password.equals(currentEntity.getPassword()))) {
			System.out.println("Successfully logged in!");
			MainScene.currentAdmin = currentEntity;
			MainScene.displayMenu(MainScene.currentAdmin);
		} else {
			System.out.println("Wrong password");
		}
	}
	
	
	
	
	public void coordinatorLoginPrompt() {
		System.out.println("Enter your coordinator ID: ");
		Scanner scanner = new Scanner(System.in);
		ID = scanner.nextLine();

		System.out.println("Enter your password: ");
		scanner = new Scanner(System.in);
		password = scanner.nextLine();

		coordinatorExistanceCheck(MainScene.coordinatorList, ID, password);

	}

	public static void coordinatorExistanceCheck(List<Coordinator> coordinatorArray, String ID, String password) {

		for (int i = 0; i < coordinatorArray.size(); i++) {
			if (coordinatorArray.get(i).getID().toLowerCase().indexOf(ID.toLowerCase()) != -1) {
				coordinatorLogin(ID, password, coordinatorArray.get(i));
			}
		}
	}
	
	public static void coordinatorLogin(String ID, String password, Coordinator currentEntity) {

		if (ID.equals(currentEntity.getID()) && (password.equals(currentEntity.getPassword()))) {
			System.out.println("Successfully logged in!");
			MainScene.currentCoordinator = currentEntity;
			MainScene.displayMenu(MainScene.currentCoordinator);
		} else {
			System.out.println("Wrong password");
		}
	}

}
