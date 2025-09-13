package utils;

public class StudentPrinter {
    public static void printStudentList(int ID, String Name, int Marks) {
            System.out.printf("| %-7d | %-19s | %-7d|\n", ID, Name, Marks);
    }
}
