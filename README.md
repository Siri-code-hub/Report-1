Build a Java program to input and manage student grades
import java.util.*;

class Student {
    String name;
    int grade;

    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Student Grade Manager ---");
            System.out.println("1. Add student");
            System.out.println("2. Display all students");
            System.out.println("3. Calculate average grade");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student grade: ");
                    int grade = scanner.nextInt();
                    students.add(new Student(name, grade));
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    System.out.println("\n--- Student Grades ---");
                    for (Student s : students) {
                        System.out.println(s.name + ": " + s.grade);
                    }
                    break;
                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No student data available.");
                        break;
                    }
                    int total = 0;
                    for (Student s : students) {
                        total += s.grade;
                    }
                    double average = (double) total / students.size();
                    System.out.println("Average grade: " + average);
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

