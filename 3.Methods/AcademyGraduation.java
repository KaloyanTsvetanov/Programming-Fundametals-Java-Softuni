import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> studentMap = new TreeMap<>();

        DecimalFormat df = new DecimalFormat("0.##################################");

        while (n-- > 0) {
            String input = scanner.nextLine();
            String name = input;
            input = scanner.nextLine();
            List<Double> gradeList = Arrays
                    .stream(input.split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
            double sum = 0;
            double avg;
            for (double grade : gradeList) {
                sum += grade;
            }
            avg = sum / gradeList.size();
            studentMap.put(name, avg);
        }

        studentMap.forEach((name, avgGrade) -> {
            System.out.printf("%s is graduated with %s%n", name, df.format(avgGrade));
        });

    }
}
