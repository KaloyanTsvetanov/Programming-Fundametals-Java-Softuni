import java.util.*;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        int numberOfLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        int n = numberOfStudents;
        double maxBonus = 0;
        double maxAttendance = 0;
        while (n > 0) {
            double studentAttendance = Integer.parseInt(scanner.nextLine());
            double bonus;

            bonus = (studentAttendance / numberOfLectures) * (5 + additionalBonus);
            if (bonus > maxBonus) {
                maxBonus = bonus;
                maxAttendance = studentAttendance;
            }
            n--;
        }
        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonus));
        System.out.printf("The student has attended %.0f lectures.", maxAttendance);
    }
}
