package Entity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import Course.Course;

public class Lecturer extends Entity {

	private List<Course> currentTeachingCourse;

	public Lecturer(String ID, String password, String firstName, String lastName, String type,
			List<Course> currentTeachingCourse) {

		super(ID, password, firstName, lastName, type);
		this.currentTeachingCourse = currentTeachingCourse;
	}

	public void assignCourse(Course course, int index) {
		Lecturer lecturer = this;

		try {
			Path path = Paths.get("/Users/markdidio/Desktop/Lecturer.txt");

			List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

			int position = lines.size();
			String extraLine = String.format("%s;%s;%s;%s;%s;%s", lecturer.getID(), lecturer.getPassword(),
					lecturer.getFirstName(), lecturer.getLastName(), lecturer.getType(), course.getCourseName());

			lines.add(position, extraLine);
			Files.write(path, lines, StandardCharsets.UTF_8);

			removeLineFrom("/Users/markdidio/Desktop/Lecturer.txt", index);

			System.out.printf("%s %s was successfully added as a lecturer for %s", lecturer.getFirstName(),
					lecturer.getLastName(), course.getCourseName());

		} catch (IOException ex) {
			System.out.println("Error");
		}

	}

	public void removeLineFrom(String filePath, int lineToRemove) {
		try {
			File oldFile = new File(filePath);
			File tempFile = new File("myTempFile.txt");

			BufferedReader br = new BufferedReader(new FileReader(filePath));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

			String line = null;
			int count = 0;

			// Read from the original file and write to the new
			// unless content matches data to be removed.
			while ((line = br.readLine()) != null) {
				// if (!line.equals(lineToRemove)) {
				if (count != lineToRemove) {
					pw.write(line + "\n");
					pw.flush();
				}
				count++;
			}
			pw.close();
			br.close();

			// Delete the original file
			oldFile.delete();

			// Rename the new file to the filename the original file had.
			tempFile.renameTo(oldFile);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
