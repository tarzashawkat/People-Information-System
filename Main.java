
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();

        int choice = 0;

while (choice != 19) {

    System.out.println("===== People Information System =====");

System.out.println("1. Show Person");
System.out.println("2. Show Student");
System.out.println("3. Show Teacher");
System.out.println("4. Show All Students");
System.out.println("5. Show All Teachers");
System.out.println("6. Show Total");
System.out.println("7. Search Student");
System.out.println("8. Search Teacher");
System.out.println("9. Remove Student");
System.out.println("10. Remove Teacher");
System.out.println("11. Update Student");
System.out.println("12. Update Teacher");
System.out.println("13. Save Students");
System.out.println("14. Save Teachers");
System.out.println("15. Read Students File");
System.out.println("16. Read Teachers File");
System.out.println("17. Load Students");
System.out.println("18. Load Teachers");
System.out.println("19. Exit");

System.out.print("Choose an option: ");

    while (!input.hasNextInt()) {
    System.out.println("Please enter a number!");
    input.next();
}

choice = input.nextInt();
input.nextLine();

    switch (choice) {

        case 1:

    String name;

while (true) {
    System.out.print("Enter person name: ");
    name = input.nextLine();

    if (name.trim().isEmpty()) {
        System.out.println("Name cannot be empty!");
        continue;
    }

    break;
}

    System.out.print("Enter your age: ");

int age;

while (true) {

    if (!input.hasNextInt()) {
        System.out.println("Please enter a valid age!");
        input.next();
        continue;
    }

    age = input.nextInt();

    if (age <= 0) {
        System.out.println("Age must be greater than zero!");
        continue;
    }

    break;
}

input.nextLine();
    Person p1 = new Person(name, age);

    p1.showInfo();

    break;
    
        case 2:

    System.out.print("Enter student name: ");
String studentName = input.nextLine();

while (studentName.trim().isEmpty()) {
    System.out.println("Student name cannot be empty!");
    System.out.print("Enter student name: ");
    studentName = input.nextLine();
}

    System.out.print("Enter student age: ");

int studentAge;

while (true) {

    if (!input.hasNextInt()) {
        System.out.println("Please enter a valid age!");
        input.next();
        continue;
    }

    studentAge = input.nextInt();

    if (studentAge < 15 || studentAge > 100) {
        System.out.println("Student age must be between 15 and 100!");
        continue;
    }

    break;
}

    input.nextLine();

    System.out.print("Enter department: ");
    String department = input.nextLine();
    
    while (department.trim().isEmpty()) {
    System.out.println("Department cannot be empty!");
    System.out.print("Enter department: ");
    department = input.nextLine();
}

    Student s1 = new Student(
        studentName,
        studentAge,
        department
    );
    students.add(s1);

    s1.showInfo();
    System.out.println("Student registered successfully!");

    break;

        case 3:
    System.out.print("Enter teacher name: ");
String teacherName = input.nextLine();

while (teacherName.trim().isEmpty()) {
    System.out.println("Teacher name cannot be empty!");
    System.out.print("Enter teacher name: ");
    teacherName = input.nextLine();
}

    System.out.print("Enter teacher age: ");

int teacherAge;

while (true) {

    if (!input.hasNextInt()) {
        System.out.println("Invalid age! Please enter a number.");
        input.next();
        continue;
    }

    teacherAge = input.nextInt();

    if (teacherAge < 20 || teacherAge > 70) {
        System.out.println("Teacher age must be between 20 and 70!");
        continue;
    }

    break;
}

input.nextLine();

    System.out.print("Enter subject: ");
    String subject = input.nextLine();
    
    while (subject.trim().isEmpty()) {
    System.out.println("subject cannot be empty!");
    System.out.print("Enter subject ");
    subject = input.nextLine();
}

    Teacher t1 = new Teacher(
        teacherName,
        teacherAge,
        subject
    );

    teachers.add(t1);

    t1.showInfo();

    System.out.println("Teacher registered successfully!");
    break;
    
    case 4:

    System.out.println("===== All Students =====");

    for (Student student : students) {
        student.showInfo();
        System.out.println("----------");
    }

    break;

case 5:

    System.out.println("===== All Teachers =====");

    for (Teacher teacher : teachers) {
        teacher.showInfo();
        System.out.println("----------");
    }

    break;
    
    case 6:

    System.out.println("Total Students: " + students.size());
    System.out.println("Total Teachers: " + teachers.size());

    break;
    
    case 7:

    System.out.print("Enter student name to search: ");
    String searchName = input.nextLine();

    boolean found = false;

    for (Student student : students) {

        if (student.name.equalsIgnoreCase(searchName)) {

            student.showInfo();
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Student not found!");
    }

    break;
    
    case 8:

    System.out.print("Enter teacher name to search: ");
    String searchTeacher = input.nextLine();

    boolean teacherFound = false;

    for (Teacher teacher : teachers) {

        if (teacher.name.equalsIgnoreCase(searchTeacher)) {

            teacher.showInfo();
            teacherFound = true;
            break;
        }
    }

    if (!teacherFound) {
        System.out.println("Teacher not found!");
    }

    break;
    
    case 9:

    System.out.print("Enter student name to remove: ");
    String removeName = input.nextLine();

    boolean removed = false;

    for (int i = 0; i < students.size(); i++) {

        if (students.get(i).name.equalsIgnoreCase(removeName)) {

            students.remove(i);
            removed = true;
            System.out.println("Student removed successfully!");

            break;
        }
    }

    if (!removed) {
        System.out.println("Student not found!");
    }

    break;
    
    case 10:

    System.out.print("Enter teacher name to remove: ");
    String removeTeacher = input.nextLine();

    boolean teacherRemoved = false;

    for (int i = 0; i < teachers.size(); i++) {

        if (teachers.get(i).name.equalsIgnoreCase(removeTeacher)) {

            teachers.remove(i);
            teacherRemoved = true;

            System.out.println("Teacher removed successfully!");

            break;
        }
    }

    if (!teacherRemoved) {
        System.out.println("Teacher not found!");
    }

    break;
    
    case 11:

    System.out.print("Enter student name to update: ");
    String updateName = input.nextLine();

    boolean updated = false;

    for (Student student : students) {

        if (student.name.equalsIgnoreCase(updateName)) {

            System.out.print("Enter new name: ");
            student.name = input.nextLine();

            System.out.print("Enter new age: ");
            student.age = input.nextInt();
            input.nextLine();

            System.out.print("Enter new department: ");
            student.department = input.nextLine();

            updated = true;

            System.out.println("Student updated successfully!");

            break;
        }
    }

    if (!updated) {
        System.out.println("Student not found!");
    }

    break;
    
    case 12:

    System.out.print("Enter teacher name to update: ");
    String updateTeacher = input.nextLine();

    boolean teacherUpdated = false;

    for (Teacher teacher : teachers) {

        if (teacher.name.equalsIgnoreCase(updateTeacher)) {

            System.out.print("Enter new name: ");
            teacher.name = input.nextLine();

            System.out.print("Enter new age: ");
            teacher.age = input.nextInt();
            input.nextLine();

            System.out.print("Enter new subject: ");
            teacher.subject = input.nextLine();

            teacherUpdated = true;

            System.out.println("Teacher updated successfully!");

            break;
        }
    }

    if (!teacherUpdated) {
        System.out.println("Teacher not found!");
    }

    break;
    
    case 13:

    try {

        FileWriter writer = new FileWriter("students.txt");

        for (Student student : students) {

            writer.write("Name: " + student.name + "\n");
            writer.write("Age: " + student.age + "\n");
            writer.write("Department: " + student.department + "\n");
            writer.write("------------------\n");
        }

        writer.close();

        System.out.println("Students saved successfully!");

    } catch (IOException e) {

        System.out.println("Error saving students!");

    }

    break;
    
    case 14:

    try {

        FileWriter writer = new FileWriter("teachers.txt");

        for (Teacher teacher : teachers) {

            writer.write("Name: " + teacher.name + "\n");
            writer.write("Age: " + teacher.age + "\n");
            writer.write("Subject: " + teacher.subject + "\n");
            writer.write("------------------\n");
        }

        writer.close();

        System.out.println("Teachers saved successfully!");

    } catch (IOException e) {

        System.out.println("Error saving teachers!");

    }

    break;
    
    case 15:

    try {

        File file = new File("students.txt");
        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {

            String line = reader.nextLine();
            System.out.println(line);

        }

        reader.close();

    } catch (IOException e) {

        System.out.println("File not found!");

    }

    break;
    
    case 16:

    try {

        File file = new File("teachers.txt");
        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {

            String line = reader.nextLine();
            System.out.println(line);

        }

        reader.close();

    } catch (IOException e) {

        System.out.println("File not found!");

    }

    break;
    
    case 17:

    try {

        BufferedReader reader =
            new BufferedReader(new FileReader("students.txt"));

        String line;

        while ((line = reader.readLine()) != null) {

            if (line.startsWith("Name: ")) {

                String loadedName = line.substring(6);

                int loadedAge = Integer.parseInt(
                    reader.readLine().substring(5)
                );

                String loadedDepartment =
                    reader.readLine().substring(12);

                Student student =
                    new Student(loadedName, loadedAge, loadedDepartment);

                students.add(student);

                reader.readLine();
            }
        }

        reader.close();

        System.out.println("Students loaded successfully!");

    } catch (IOException e) {

        System.out.println("Error loading students!");

    }

    break;
    
    case 18:

    try {

        BufferedReader teacherReader =
            new BufferedReader(new FileReader("teachers.txt"));

        String teacherLine;

        while ((teacherLine = teacherReader.readLine()) != null) {

            if (teacherLine.startsWith("Name: ")) {

                String loadedTeacherName = teacherLine.substring(6);

                int loadedTeacherAge = Integer.parseInt(
                    teacherReader.readLine().substring(5)
                );

                String loadedSubject =
                    teacherReader.readLine().substring(9);

                Teacher loadedTeacher = new Teacher(
                    loadedTeacherName,
                    loadedTeacherAge,
                    loadedSubject
                );

                teachers.add(loadedTeacher);

                teacherReader.readLine();
            }
        }

        teacherReader.close();

        System.out.println("Teachers loaded successfully!");

    } catch (IOException e) {

        System.out.println("Error loading teachers!");

    }

    break;
    
    case 19:
    System.out.println("Goodbye!");
    break;

        default:
    System.out.println("Invalid option! Please choose from 1 to 19.");
    break;
    }
}


input.close();
    }
}