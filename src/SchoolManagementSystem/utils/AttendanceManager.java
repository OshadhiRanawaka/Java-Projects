package utils;

import java.util.Scanner;

public class AttendanceManager {

    public static void attendanceManagementMenu(Scanner input, String[] studentNames, int[] studentIDs,
            String[][] attendance, int studentCount) {
        boolean mainMenu = true;
        while (mainMenu) {
            System.out.println("\n--- Attendance Management ---");

            System.out.println(
                    "1. Mark Daily Attendance\n2. View Full Attendance Grid\n3. Get Student Attendance Report\n4. List Absentees for a Day\n0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int attendanceChoice = SafeInputReader.readIntSafe(0, 4,
                    "Invalid choice. Please enter a number between 0 and 4.");

            switch (attendanceChoice) {
                case 1 -> {
                    System.out.print("Enter the day to mark attendance for (1-30): ");
                    int day = SafeInputReader.readIntSafe(1, 30, "Invalid input. Please enter a day between 1 and 30.");
                    int dayIndex = day - 1;

                    System.out.println("\n--- Marking Attendance for Day " + day + " ---");

                    for (int i = 0; i < studentCount; i++) {
                        System.out.print("Student: " + studentNames[i] + "(ID: " + studentIDs[i]
                                + "). Present or Absent? (P/A): ");
                        String status = input.next();

                        if (status.equalsIgnoreCase("P")) {
                            attendance[i][dayIndex] = "P";
                        } else if (status.equalsIgnoreCase("A")) {
                            attendance[i][dayIndex] = "A";
                        } else if (status.equals("-")) {
                            attendance[i][dayIndex] = "-";
                        } else {
                            System.out.println("Invalid input. Please enter P or A.");
                        }
                    }
                    System.out.println("Attendance for Day " + day + " has been recorded.");
                }
                case 2 -> {
                    System.out.println("\n--- Full Attendance Grid ---(Term 1)");

                    System.out.println("+----------------------+----------+----------+----------+----------+");
                    System.out.printf("| %-20s | %-8s | %-8s | %-8s | %-8s |\n", "Name", "Day 1",
                            "Day 2", "Day 3", "Day 4");
                    System.out.println("+----------------------+----------+----------+----------+----------+");

                    for (int i = 0; i < studentCount; i++) {
                        System.out.printf("| %-20s ", studentNames[i]);
                        for (int j = 0; j < 4; j++) {
                            System.out.printf("| %-8s ", attendance[i][j]);
                        }
                        System.out.println();
                        System.out.println("+----------------------+----------+----------+----------+----------+");

                    }
                    System.out.println("(P = Present, A = Absent, - = Not Yet Marked)");
                }
                case 3 -> {
                    System.out.print("Enter the Student ID to check: ");
                    int studentID = input.nextInt();
                    int studentIndex = -1;
                    for (int i = 0; i < studentCount; i++) {
                        if (studentIDs[i] == studentID) {
                            studentIndex = i;
                            break;
                        }
                    }
                    if (studentIndex == -1) {
                        System.out.println("Student not found.");
                    } else {
                        System.out.println("Searching for " + studentNames[studentIndex] + "...");

                        int presentCount = 0;
                        int totalMarkedDays = 0;

                        for (int j = 0; j < 4; j++) {
                            if (!attendance[studentIndex][j].equals("-")) {
                                totalMarkedDays++;
                                if (attendance[studentIndex][j].equalsIgnoreCase("P")) {
                                    presentCount++;
                                }
                            }
                        }
                        if (totalMarkedDays > 0) {
                            double attendencePercentage = ((double) presentCount / totalMarkedDays) * 100;
                            int absentCount = totalMarkedDays - presentCount;

                            System.out.println("\n--- Attendace Report for " + studentNames[studentIndex] + " ---");
                            System.out.println("Days Marked So Far: " + totalMarkedDays);
                            System.out.println("Days Present: " + presentCount);
                            System.out.println("Days Absent: " + absentCount);

                            System.out.println("Attendance Percentage: " + attendencePercentage + "%");
                        }

                    }
                }

                case 4 -> {
                    System.out.println("Listing Absentees for a Day...");
                }

                case 0 -> {
                    mainMenu = false;
                    break;
                }
                default -> {
                    System.out.println("Invalid choice. Please enter a number between 0 and 4.");
                    break;
                }
            }
        }

    }
}
