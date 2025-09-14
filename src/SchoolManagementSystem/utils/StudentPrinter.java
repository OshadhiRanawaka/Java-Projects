package utils;

public class StudentPrinter {

    public static void printHeader(String title) {
        System.out.println("--- " + title + " ---");
        System.out.println("+================================================================================+");
        System.out.printf("|%-7s | %-19s | %-7s| %-7s| %-7s| %-7s|\n", "ID", "Name", "Final Exam", "Midterm", "Homework", "Marks");
        System.out.println("+-------+--------------------+-------+-------+-------+-------+");
    }

    public static void printStudentList(int ID, String Name, double finalExam, double midterm, double homework, double marks) {
        System.out.printf("| %-7d | %-19s | %-7.2f| %-7.2f| %-7.2f| %-7.2f| \n", ID, Name, finalExam, midterm, homework, marks);
    }

    public static void printFooter() {
        System.out.println("+-------+--------------------+-------+-------+-------+-------+");
    }

    public static void studentNotFound(String message) {
        System.out.println(message);
    }
}
