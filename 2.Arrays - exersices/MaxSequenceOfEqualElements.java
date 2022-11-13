import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int index = 0;
        int greatestCounter = 0;
        for (int i = 0; i < array.length; i++) {
            int j = i;
            int counter = 0;
            while (j + 1 < array.length && array[j + 1] == array[i]) {
                counter++;
                j++;
            }
            if (counter > greatestCounter) {
                greatestCounter = counter;
                index = i;
            }
        }
        for (int i = index; i <= index + greatestCounter; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
