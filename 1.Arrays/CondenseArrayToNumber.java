import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numRep = num.length - 1;
        for (int i = 0; i < numRep; i++) {
            int[] condensed = new int[num.length - 1];
            for (int j = 0; j < num.length - 1; j++) {
                condensed[j] = num[j] + num[j + 1];
            }
            num = condensed;
        }
        System.out.println(num[0]);
    }
}
