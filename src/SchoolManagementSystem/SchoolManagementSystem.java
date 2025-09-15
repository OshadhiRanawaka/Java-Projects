
import java.util.Scanner;
import utils.GradeCalc;
import utils.Greeter;
import utils.SafeInputReader;
import utils.StudentPrinter;

public class SchoolManagementSystem {

    static double finalExamWeight = 0.6;
    static double midtermWeight = 0.3;
    static double homeworkWeight = 0.1;

    static final int MAX_STUDENTS = 3;
    static int[] studentIDs = new int[MAX_STUDENTS];
    static String[] studentNames = new String[MAX_STUDENTS];
    static double[] Marks = new double[MAX_STUDENTS];

    // For grading scheme
    static int[] finalExamMarks = new int[MAX_STUDENTS];
    static int[] midtermMarks = new int[MAX_STUDENTS];
    static int[] homeworkMarks = new int[MAX_STUDENTS];
    static int studentCount = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to CyberCrewz Academy\nSchool Management System V1\nCode name: River");
        Greeter.sayHello();

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("--Main Menu--");
            System.out.println("1. Student Management");
            System.out.println("2. Teacher Management");
            System.out.println("3. Library Management");
            System.out.println("4. Student Analysis");
            System.out.println("5. Grading Scheme Configuration");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = SafeInputReader.readIntSafe(0, 5, "Invalid choice. Please enter a number between 0 and 5.");

            switch (choice) {
                case 1 -> {
                    System.out.println("Navigating to Student Management ");
                    studentManagementMenu(input);
                }
                case 2 ->
                    System.out.println("Navigating to Teacher Management ");
                case 3 ->
                    System.out.println("Navigating to Library Management ");
                case 4 -> {
                    System.out.println("Navigating to Student Analysis ");
                    studentAnalysis(input);
                }
                case 5 -> {
                    System.out.println("--- Grading Schema Setup ---");
                    System.out.println(
                            "You will define the components of the final grade.\nAll weights must sum to 1.0 (e.g., 0.6 for 60%).");

                    while (true) {
                        double totalSum = 1.0;
                        System.out.print("Enter weight for 'Final Exam': ");
                        finalExamWeight = input.nextDouble();
                        System.out.print("Enter weight for 'Midterm': ");
                        midtermWeight = input.nextDouble();
                        System.out.print("Enter weight for 'Homework': ");
                        homeworkWeight = input.nextDouble();

                        double sum = finalExamWeight + midtermWeight + homeworkWeight;

                        if (sum == totalSum) {
                            System.out.println("Checking weights... " + finalExamWeight + " + " + midtermWeight + " + "
                                    + homeworkWeight + " = " + sum);

                            System.out.println("Success! Grading scheme has been configured for this session");
                            break;
                        } else {
                            System.out.println("Error: Weights must sum to 1.0. Please try again.");
                        }
                    }

                }
                case 0 -> {
                    System.out.println("Thank you for using the School Management System. Goodbye!");
                    return;
                }
                // default ->
                //     System.out.println("Invalid choice. Please enter a number between 0 and 4.");
            }
        }
    }

    private static int readIntSafe(Scanner input) {
        while (true) {
            if (input.hasNextInt()) {
                int value = input.nextInt();
                input.nextLine(); // Clear the newline character
                return value;
            } else {
                System.out.println("Error: Invalid input. Please enter a whole number.");
                System.out.print("Enter your choice: ");
                input.next(); // Clear the invalid input
            }
        }

    }

    public static void studentManagementMenu(Scanner input) {
        boolean studentMenu = true;
        // int studentID = 0;
        // String studentName = "";
        // int studentMark = 0;

        while (studentMenu) {
            System.out.println("\n--Student Management--");
            System.out.println("1. Add a New Student");
            System.out.println("2. List All Students");
            System.out.println("3. Search for a Student by ID");
            System.out.println("4. Update a Student's Marks");
            System.out.println("5. Delete a Student");
            System.out.println("6. View Final Weighted Grade");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int studentChoice = SafeInputReader.readIntSafe(0, 6, "Invalid choice. Please enter a number between 0 and 6.");

            switch (studentChoice) {
                case 1 -> {

                    if (studentCount <= MAX_STUDENTS) {
                        System.out.print("Enter Student ID: ");
                        studentIDs[studentCount] = readIntSafe(input);
                        System.out.print("Enter Student Name: ");
                        studentNames[studentCount] = SafeInputReader.readNonEmptyLine("Error: Input cannot be empty.");

                        System.out.print("Enter Student Final Exam Marks: ");
                        finalExamMarks[studentCount] = readIntSafe(input);

                        System.out.print("Enter Student Midterm Marks: ");
                        midtermMarks[studentCount] = readIntSafe(input);
                        System.out.print("Enter Student Homework Marks: ");
                        homeworkMarks[studentCount] = readIntSafe(input);

                        int[] totalMarks = new int[]{finalExamMarks[studentCount], midtermMarks[studentCount],
                            homeworkMarks[studentCount]};

                        double[] gradeWeight = {finalExamWeight, midtermWeight, homeworkWeight};

                        Marks[studentCount] = GradeCalc.weightedGrade(totalMarks, gradeWeight, totalMarks.length);
                        studentCount++;

                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Error: Cannot add more students. The database is full.");
                    }
                }
                case 2 -> {
                    if (studentCount == 0) {
                        StudentPrinter.studentNotFound("No students found");

                    } else {
                        StudentPrinter.printHeader("Student List");
                        for (int i = 0; i < studentCount; i++) {
                            StudentPrinter.printStudentList(studentIDs[i], studentNames[i], finalExamMarks[i], midtermMarks[i], homeworkMarks[i], Marks[i]);
                        }
                        StudentPrinter.printFooter();
                    }
                }
                case 3 -> {
                    System.out.print("Enter the Student ID to search for: ");
                    int searchID = readIntSafe(input);
                    for (int i = 0; i < studentCount; i++) {
                        if (studentIDs[i] == searchID) {
                            StudentPrinter.printHeader("Student Found");
                            StudentPrinter.printStudentList(studentIDs[i], studentNames[i], finalExamMarks[i], midtermMarks[i], homeworkMarks[i], Marks[i]);
                            StudentPrinter.printFooter();
                        } else {
                            StudentPrinter.studentNotFound("Student with ID " + searchID + " not found.");
                        }
                    }
                }
                case 4 -> {
                    System.out.print("Enter the Student ID to update: ");
                    int updateID = readIntSafe(input);
                    for (int i = 0; i < studentCount; i++) {
                        if (studentIDs[i] == updateID) {
                            System.out.println(
                                    "Found Student : " + studentNames[i] + " (Current Marks: " + Marks[i] + ")");
                            System.out.print("Enter score for Final Exam (0-100): ");
                            int updateFianlExam = readIntSafe(input);
                            finalExamMarks[i] = updateFianlExam;
                            System.out.print("Enter score for Midterm (0-100): ");
                            int updateMidterm = readIntSafe(input);
                            midtermMarks[i] = updateMidterm;
                            System.out.print("Enter score for Homework (0-100): ");
                            int updateHomework = readIntSafe(input);
                            homeworkMarks[i] = updateHomework;

                            System.out.print("Enter new total marks: ");
                            double studentMarks = input.nextDouble();
                            Marks[i] = studentMarks;
                            System.out.println("Student marks updated successfully!");
                        }
                    }
                }
                case 5 -> {
                    System.out.print("Enter the Student ID to delete: ");
                    int deleteID = readIntSafe(input);

                    for (int i = 0; i < studentCount; i++) {
                        if (studentIDs[i] == deleteID) {
                            System.out.println("Found Student: " + studentNames[i]
                                    + ". Are you sure you want to delete? (yes/no): ");
                            String confirmation = input.next();

                            if (confirmation.equalsIgnoreCase("yes")) {
                                for (int j = i; j < studentCount - 1; j++) {
                                    studentIDs[j] = studentIDs[j + 1];
                                    studentNames[j] = studentNames[j + 1];
                                    Marks[j] = Marks[j + 1];
                                }
                                studentCount--;
                                System.out.println("Student with ID " + deleteID + " has been deleted.");

                            }
                        }
                    }
                }
                case 6 -> {

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

    public static void studentAnalysis(Scanner input) {
        System.out.println("\n--- Student Analysis Menu ---");
        System.out.println("1. Calculate Class Average Mark");
        System.out.println("2. Find Highest and Lowest Marks");
        System.out.println("3. View Full Class Performance Report");
        System.out.println("4. Rank Students by Marks");
        System.out.println("5. View Top 2 Students");
        System.out.println("0. Back to Main Menu: ");
        System.out.print("Enter your choice:");
        int analysisChoice = SafeInputReader.readIntSafe(0, 5, "Invalid choice. Please enter a number between 0 and 5.");

        if (studentCount > 0) {
            switch (analysisChoice) {
                case 1 -> {
                    System.out.println("Calculating class average...");

                    int totalMarks = 0;
                    for (int i = 0; i < studentCount; i++) {
                        totalMarks += Marks[i];
                    }
                    System.out.println("Total marks of all " + studentCount + " students: " + totalMarks);

                    double average = (double) totalMarks / studentCount;
                    System.out.println("Class Average Mark: " + average);

                }

                case 2 -> {
                    System.out.println("Analyzing scores...");

                    int highestMark = (int) Marks[0];
                    int lowestMark = (int) Marks[0];

                    for (int i = 1; i < studentCount; i++) {
                        if (Marks[i] > highestMark) {
                            highestMark = (int) Marks[i];
                        }
                        if (Marks[i] < lowestMark) {
                            lowestMark = (int) Marks[i];
                        }
                    }

                    System.out.println("Highest Mark in the Class: " + highestMark);
                    System.out.println("Lowest Mark in the Class: " + lowestMark);

                }
                case 3 -> {
                    performanceReport();
                }
                case 4 -> {
                    System.out.println("Sorting Students...");
                    sortStudentMarks();
                    System.out.println("Students have been ranked. Please use 'List All Students' to view.");
                }
                case 5 -> {
                    sortStudentMarks();

                    StudentPrinter.printHeader("Top 2 Students");
                    for (int i = 0; i < 2; i++) {
                        StudentPrinter.printStudentList(studentIDs[i], studentNames[i], finalExamMarks[i], midtermMarks[i], homeworkMarks[i], Marks[i]);
                    }
                    StudentPrinter.printFooter();
                }
            }
        } else {
            StudentPrinter.studentNotFound(
                    "Error: Cannot perform analysis. There are no students in the system.\nPlease add students first.");
        }
    }

    public static void performanceReport() {
        int totalMarks = 0;
        int highestMark = (int) Marks[0];
        int lowestMark = (int) Marks[0];

        for (int i = 0; i < studentCount; i++) {
            totalMarks += Marks[i];
        }
        double average = (double) totalMarks / studentCount;

        for (int i = 1; i < studentCount; i++) {
            if (Marks[i] > highestMark) {
                highestMark = (int) Marks[i];
            }
            if (Marks[i] < lowestMark) {
                lowestMark = (int) Marks[i];
            }
        }

        System.out.println("--- Class Performance Report ---");
        System.out.println("+-------------------------+-------+");
        System.out.printf("|%-25s | %-8s |\n", "Metric", "Value");
        System.out.println("+-------------------------+-------+");
        System.out.printf("| %-25s | %-7d |\n", "Total Students", studentCount);
        System.out.printf("| %-25s | %-7.2f |\n", "Average Mark", (double) average);
        System.out.printf("| %-25s | %-7d |\n", "Highest Mark", highestMark);
        System.out.printf("| %-25s | %-7d |\n", "Lowest Mark", lowestMark);
        System.out.println("+-------------------------+-------+");
    }

    public static void sortStudentMarks() {
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - 1 - i; j++) {
                if (Marks[j] < Marks[j + 1]) {
                    int temp = (int) Marks[j];
                    Marks[j] = Marks[j + 1];
                    Marks[j + 1] = temp;

                    int tempID = studentIDs[j];
                    studentIDs[j] = studentIDs[j + 1];
                    studentIDs[j + 1] = tempID;

                    String tempName = studentNames[j];
                    studentNames[j] = studentNames[j + 1];
                    studentNames[j + 1] = tempName;

                }
            }
        }
    }
}
