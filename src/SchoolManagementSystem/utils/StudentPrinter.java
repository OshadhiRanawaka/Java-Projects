package utils;

public class StudentPrinter {

    public static void printHeader(String title) {
        System.out.println("--- " + title + " ---");
        System.out.println("+=========================================+");
        System.out.printf("|%-7s | %-19s | %-7s|\n", "ID", "Name", "Marks");
        System.out.println("+-------+--------------------+-------+");
    }

    public static void printStudentList(int ID, String Name, int Marks) {
        System.out.printf("| %-7d | %-19s | %-7d|\n", ID, Name, Marks);
    }

    public static void printFooter() {
        System.out.println("+-------+--------------------+-------+");
    }

    public static void studentNotFound(String message) {
        System.out.println(message);
    }
}
