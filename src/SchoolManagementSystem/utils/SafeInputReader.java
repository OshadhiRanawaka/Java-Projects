package utils;

import java.util.Scanner;

public class SafeInputReader {
    public static int readIntSafe(int min, int max, String msg) {
        Scanner input = new Scanner(System.in);
        while (true) {
            if (input.hasNextInt()) {
                int value = input.nextInt();
                input.nextLine(); // Clear the newline character
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.print("Error: " + msg);
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a whole number.");
                System.out.print("Enter your choice: ");
                input.next(); // Clear the invalid input
            }
        }

    }

    public static String readNonEmptyLine(String msg) {
        Scanner input = new Scanner(System.in);
        while (true) {
            String value = input.nextLine();
            if (!value.isEmpty()) {
                return value;
            } else {
                System.out.println(msg);
                System.out.print("Enter your choice: ");
            }
        }
    }


}
