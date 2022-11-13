import java.util.*;

public class StudentAcademy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> courseMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n > 0) {
            String nameOfStudent = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (courseMap.containsKey(nameOfStudent)) {
                courseMap.get(nameOfStudent).add(grade);
            } else {
                List<Double> currentGrades = new ArrayList<>();
                currentGrades.add(grade);
                courseMap.put(nameOfStudent, currentGrades);
            }
            n--;
        }

        for (Map.Entry<String, List<Double>> entry : courseMap.entrySet()) {
            int size = entry.getValue().size();
            String name = entry.getKey();
            double sum = 0;
            for (int i = 0; i <= size - 1; i++) {
                double gr = entry.getValue().get(i);
                sum += gr;
            }
            double average = sum / size;
            if (average >= 4.50) {
                System.out.printf("%s -> %.2f%n", name, average);
            }
        }

    }
}
