import java.util.ArrayList;
import java.util.Scanner;

// Class to hold student details
class Student {
    String name;
    int grade;

    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Student> students = new ArrayList<>();

            System.out.println("=== Student Grade Tracker ===");

            while (true) {
                System.out.print("Enter student name (or type 'done' to finish): ");
                String name = sc.nextLine();

                if (name.equalsIgnoreCase("done")) {
                    break;
                }

                System.out.print("Enter grade for " + name + ": ");
                int grade = sc.nextInt();
                sc.nextLine(); // clear the newline

                students.add(new Student(name, grade));
            }

            // If no students were entered
            if (students.isEmpty()) {
                System.out.println("No student data entered.");
                return;
            }

            // Calculating total, highest and lowest
            int total = 0;
            int highest = -1;
            int lowest = 101;

            for (Student s : students) {
                total += s.grade;

                if (s.grade > highest) {
                    highest = s.grade;
                }

                if (s.grade < lowest) {
                    lowest = s.grade;
                }
            }

            double average = (double) total / students.size();

            // Display report
            System.out.println("\n--- Student Grades ---");
            for (Student s : students) {
                System.out.println(s.name + ": " + s.grade);
            }

            System.out.printf("\nAverage Grade: %.2f\n", average);
            System.out.println("Highest Grade: " + highest);
            System.out.println("Lowest Grade: " + lowest);
        }
    }
}
