import java.util.Scanner;

public class StudentRecord2{
    public static void main(String[] args) {
        // Constants
        final int NUM_STUDENTS = 40 ;
        final int NUM_SUBJECTS = 5;

        // Create a 2D array to store student records
        String[][] studentRecords = new String[NUM_STUDENTS][NUM_SUBJECTS + 1]; // +1 for the total marks

        // Initialize Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Input: Populate the student records
        for (int i = 0; i < NUM_STUDENTS; i++) {
            System.out.println("Enter details for student " + (i + 1));

            // Input: Student Name
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();
            studentRecords[i][0] = studentName;

            // Input: Marks in 5 subjects
            for (int j = 1; j <= NUM_SUBJECTS; j++) {
                System.out.print("Enter marks in Subject " + j + ": ");
                String marks = scanner.nextLine();
                studentRecords[i][j] = marks;
            }

            // Calculate and store total marks
            int totalMarks = calculateTotalMarks(studentRecords[i]);
            studentRecords[i][NUM_SUBJECTS] = String.valueOf(totalMarks);
        }

        // Input: Retrieve student details by name
        System.out.print("Enter student name to display details: ");
        String searchName = scanner.nextLine();

        // Search for the student by name
        boolean found = false;
        for (int i = 0; i < NUM_STUDENTS; i++) {
            if (studentRecords[i][0].equalsIgnoreCase(searchName)) {
                // Display student details
                displayStudentDetails(studentRecords[i]);
                found = true;
                break;
            }
        }

        // If the student is not found
        if (!found) {
            System.out.println("Student not found!");
        }

        // Close Scanner
        scanner.close();
    }

    // Helper method to calculate total marks
    private static int calculateTotalMarks(String[] marksArray) {
        int totalMarks = 0;
        for (int i = 1; i <= marksArray.length - 2; i++) {
            totalMarks += Integer.parseInt(marksArray[i]);
        }
        return totalMarks;
    }

    // Helper method to display student details
    private static void displayStudentDetails(String[] studentDetails) {
        System.out.println("\nStudent Details:");
        System.out.println("Name: " + studentDetails[0]);
        for (int i = 1; i <= studentDetails.length - 2; i++) {
            System.out.println("Subject " + i + ": " + studentDetails[i]);
        }
        System.out.println("Total Marks: " + studentDetails[studentDetails.length - 1]);
    }
}