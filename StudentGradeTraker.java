import java.util.*;

class Student {
    private String name;
    private ArrayList<String> subjects = new ArrayList<>();
    private ArrayList<Double> marks = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void addSubjectMark(String subject, double mark) {
        subjects.add(subject);
        marks.add(mark);
    }

    public String getName() {
        return name;
    }

    public double getAverage() {
        if (marks.isEmpty()) return 0;
        double total = 0;
        for (double m : marks) total += m;
        return total / marks.size();
    }

    public double getHighest() {
        return Collections.max(marks);
    }

    public double getLowest() {
        return Collections.min(marks);
    }

    public void displayGrades() {
        System.out.println("Grades for " + name + ":");
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println("  " + subjects.get(i) + ": " + marks.get(i));
        }
        System.out.println("  ➤ Average: " + getAverage());
        System.out.println("  ➤ Highest: " + getHighest());
        System.out.println("  ➤ Lowest : " + getLowest());
    }
}

public class StudentGradeTracker {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n======== STUDENT GRADE TRACKER ========");
            System.out.println("1. Add Student");
            System.out.println("2. Display Summary Report");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int option = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (option) {
                case 1:
                    addStudentData();
                    break;
                case 2:
                    displayAllSummaries();
                    break;
                case 3:
                    System.out.println("Exiting program. Thank you!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    static void addStudentData() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        Student student = new Student(name);

        System.out.print("Enter number of subjects: ");
        int subCount = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < subCount; i++) {
            System.out.print("  Subject " + (i + 1) + " name: ");
            String subject = sc.nextLine();
            System.out.print("  Enter marks for " + subject + ": ");
            double marks = sc.nextDouble();
            sc.nextLine(); // consume newline
            student.addSubjectMark(subject, marks);
        }

        students.add(student);
        System.out.println("Student data added successfully!");
    }

    static void displayAllSummaries() {
        if (students.isEmpty()) {
            System.out.println("No student data available.");
        } else {
            for (Student s : students) {
                System.out.println("------------------------------------");
                s.displayGrades();
            }
            System.out.println("------------------------------------");
        }
    }
}
📝
