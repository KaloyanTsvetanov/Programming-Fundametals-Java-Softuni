import java.util.Arrays;
import java.util.Scanner;

public class EqualSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < array.length; i++) {
            int sumRight = 0;
            int sumLeft = 0;
            for (int j = i + 1; j < array.length; j++) {
                sumRight += array[j];
            }
            for (int j = 0; j < i; j++) {
                sumLeft += array[j];
            }
            if (sumLeft == sumRight) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("no");
    }
}
