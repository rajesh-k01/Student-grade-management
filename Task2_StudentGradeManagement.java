import java.util.ArrayList;
import java.util.Scanner;

/**
 * Task 2: Student Grade Management System
 * -----------------------------------------
 * A console application that stores student names and marks using an
 * ArrayList, then calculates and displays the average, highest, and
 * lowest marks in a clearly formatted summary report.
 */
public class Task2_StudentGradeManagement {

    // Simple inner class to hold a student's name and marks together.
    // Keeping name+marks in one object (instead of two separate lists)
    // makes it easier to keep the data linked correctly.
    static class Student {
        String name;
        double marks;

        Student(String name, double marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ArrayList to dynamically store any number of students
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume leftover newline after nextInt()

        // Collecting student data from the user
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks: ");
            double marks = sc.nextDouble();
            sc.nextLine(); // consume leftover newline after nextDouble()

            students.add(new Student(name, marks));
        }

        // Guard clause: avoid divide-by-zero / empty-list errors below
        if (students.isEmpty()) {
            System.out.println("No student data entered.");
            sc.close();
            return;
        }

        // Calculating average, highest, and lowest marks
        double total = 0;
        double highest = students.get(0).marks;
        double lowest = students.get(0).marks;
        String topStudent = students.get(0).name;
        String bottomStudent = students.get(0).name;

        for (Student s : students) {
            total += s.marks;

            if (s.marks > highest) {
                highest = s.marks;
                topStudent = s.name;
            }
            if (s.marks < lowest) {
                lowest = s.marks;
                bottomStudent = s.name;
            }
        }

        double average = total / students.size();

        // Displaying a clear, formatted summary report
        System.out.println("\n===================================");
        System.out.println("        STUDENT SUMMARY REPORT");
        System.out.println("===================================");
        System.out.printf("%-15s %-10s%n", "Name", "Marks");
        System.out.println("-----------------------------------");
        for (Student s : students) {
            System.out.printf("%-15s %-10.2f%n", s.name, s.marks);
        }
        System.out.println("-----------------------------------");
        System.out.printf("Average Marks : %.2f%n", average);
        System.out.printf("Highest Marks : %.2f (%s)%n", highest, topStudent);
        System.out.printf("Lowest Marks  : %.2f (%s)%n", lowest, bottomStudent);
        System.out.println("===================================");

        sc.close();
    }
}
