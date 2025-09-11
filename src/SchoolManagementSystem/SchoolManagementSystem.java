
import java.util.Scanner;

public class SchoolManagementSystem {

    static final int MAX_Students = 2;
    static int[] studentIDs = new int[MAX_Students];
    static String[] studentNames = new String[MAX_Students];
    static int[] studentMarks = new int[MAX_Students];
    static int studentCount = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to CyberCrewz Academy\nSchool Management System V1\nCode name: River");

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("--Main Menu--");
            System.out.println("1. Student Management");
            System.out.println("2. Teacher Management");
            System.out.println("3. Library Management");
            System.out.println("4. Reports");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Navigating to Student Management ");
                    studentManagementMenu(input);
                }
                case 2 ->
                    System.out.println("Navigating to Teacher Management ");
                case 3 ->
                    System.out.println("Navigating to Library Management ");
                case 4 ->
                    System.out.println("Navigating to Reports ");
                case 0 -> {
                    System.out.println("Thank you for using the School Management System. Goodbye!");
                    return;
                }
                default ->
                    System.out.println("Invalid choice. Please enter a number between 0 and 4.");
            }
        }
    }

    public static void studentManagementMenu(Scanner input) {
        boolean studentMenu = true;
        int studentID = 0;
        String studentName = "";
        int studentMark = 0;

        while (studentMenu) {
            System.out.println("\n--Student Management--");
            System.out.println("1. Add a New Student");
            System.out.println("2. List All Students"
            );
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int studentChoice = input.nextInt();

            switch (studentChoice) {
                case 1 -> {
                    if (studentCount < MAX_Students) {
                        System.out.print("Enter Student ID: ");
                        studentIDs[studentCount] = input.nextInt();
                        System.out.print("Enter Student Name: ");
                        studentNames[studentCount] = input.next();
                        System.out.print("Enter Student Marks: ");
                        studentMarks[studentCount] = input.nextInt();
                        studentCount++;
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Error: Cannot add more students. The database is full.");
                    }
                }
                case 2 -> {
                    if (studentCount == 0) {
                        System.out.println("No students found");

                    } else {
                        System.out.println("\n--Student List--");
                        for (int i = 0; i < studentCount; i++) {
                            System.out.println("ID: " + studentIDs[i] + ", Name: " + studentNames[i] + ", Marks: "
                                    + studentMarks[i]);
                        }
                    }
                }
                case 0 -> {
                    studentMenu = false;
                    break;
                }
                default -> {
                    System.out.println("Invalid choice. Please enter a number between 0 and 2.");
                    break;
                }
            }
        }
    }

}
