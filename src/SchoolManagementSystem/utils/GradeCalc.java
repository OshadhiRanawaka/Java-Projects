package utils;

public class GradeCalc {

    public static double weightedGrade(int[] totalMarks, double[] gradeWeight, int num) {
        num--;
        if (num >= 0) {

            double a = (totalMarks[num] * gradeWeight[num] + weightedGrade(totalMarks, gradeWeight, num));

            return a;
        } else {
            return 0;
        }
    }
}
