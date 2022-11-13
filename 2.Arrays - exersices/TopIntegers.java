import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < array.length; i++) {
            // int counter = 0;
            boolean hasGreaterNumber = false;
            for (int j = i + 1; j < array.length && !hasGreaterNumber; j++) {
                if (array[i] <= array[j]) hasGreaterNumber = true;
            }
            if (!hasGreaterNumber)
                System.out.print(array[i] + " ");

        }
    }
}
