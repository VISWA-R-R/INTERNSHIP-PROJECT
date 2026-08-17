import java.util.Scanner;

public class StudentGradeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume the newline.

        if (count <= 0) {
            System.out.println("Number of students must be greater than zero.");
            scanner.close();
            return;
        }

        // Arrays to store student names and marks.
        String[] names = new String[count];
        double[] marks = new double[count];

        // Read student details.
        for (int i = 0; i < count; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter name: ");
            names[i] = scanner.nextLine();

            System.out.print("Enter marks (0-100): ");
            marks[i] = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline.

            // Validate marks.
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid marks. Enter marks between 0 and 100: ");
                marks[i] = scanner.nextDouble();
                scanner.nextLine();
            }
        }

        // Calculate total, highest, and lowest marks.
        double total = 0;
        double highest = marks[0];
        double lowest = marks[0];
        int highestIndex = 0;
        int lowestIndex = 0;

        for (int i = 0; i < count; i++) {
            total += marks[i];

            if (marks[i] > highest) {
                highest = marks[i];
                highestIndex = i;
            }

            if (marks[i] < lowest) {
                lowest = marks[i];
                lowestIndex = i;
            }
        }

        double average = total / count;

        // Display the formatted summary report.
        System.out.println("\n================ STUDENT GRADE REPORT ================");
        System.out.printf("%-5s %-25s %-10s %-10s%n", "No.", "Name", "Marks", "Grade");
        System.out.println("-------------------------------------------------------");

        for (int i = 0; i < count; i++) {
            System.out.printf(
                "%-5d %-25s %-10.2f %-10s%n",
                i + 1, names[i], marks[i], getGrade(marks[i])
            );
        }

        System.out.println("-------------------------------------------------------");
        System.out.printf("Average Marks : %.2f%n", average);
        System.out.printf("Highest Marks : %.2f (%s)%n", highest, names[highestIndex]);
        System.out.printf("Lowest Marks  : %.2f (%s)%n", lowest, names[lowestIndex]);
        System.out.println("=======================================================");

        scanner.close();
    }

    // Return a grade based on the student's marks.
    public static String getGrade(double marks) {
        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
