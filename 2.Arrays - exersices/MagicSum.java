import java.util.Arrays;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < array.length - 1; i++) {
            int j = i + 1;
            while (j < array.length) {
                if (array[i] + array[j] == n) {
                    System.out.print(array[i] + " " + array[j]);
                    System.out.println();
                }
                j++;
            }
        }
    }
}
