import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int maxLength = 0;
        int lastIndex = -1;
        int[] len = new int[array.length];
        int[] previous = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            len[i] = 1;
            previous[i] = -1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    previous[i] = j;
                }
            }
            if (len[i] > maxLength) {
                maxLength = len[i];
                lastIndex = i;
            }
        }
        int[] lis = new int[maxLength];
        int currentIndex = maxLength - 1;
        while (lastIndex != -1) {
            lis[currentIndex] = array[lastIndex];
            currentIndex--;
            lastIndex = previous[lastIndex];
        }
        for (int i = 0; i < lis.length; i++) {
            System.out.print(lis[i] + " ");
        }
    }
}
