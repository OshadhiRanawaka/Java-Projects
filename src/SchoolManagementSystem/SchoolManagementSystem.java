import java.util.Scanner;
public class SchoolManagementSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to CyberCrewz Academy\nSchool Management System V1\nCode name: River");

        while (true) {
            System.out.print("--Main Menu--");
            System.out.println(
                    "\n1. Student Management\n2. Teacher Management\n3. Library Management\n4. Reports\n0. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Navigating to Student Management ");
                    break;
                case 2:
                    System.out.println("Navigating to Teacher Management ");
                    break;
                case 3:
                    System.out.println("Navigating to Library Management ");
                    break;
                case 4:
                    System.out.println("Navigating to Reports ");
                    break;
                case 0:
                    System.out.println("Thank you for using the School Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 4.");
            }
        }
    }

}
