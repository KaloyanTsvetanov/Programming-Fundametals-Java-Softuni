import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            char[] array = scanner.next().toCharArray();
            sum = 0;
            for (char letter : array) {
                if (letter == 'a' || letter == 'A' || letter == 'e' || letter == 'E' || letter == 'i' || letter == 'I' || letter == 'o' || letter == 'O' || letter == 'u' || letter == 'U') {
                    sum += (letter * array.length);
                } else {
                    sum += (letter / array.length);
                }
            }
            arr[i] = sum;
        }
        Arrays.sort(arr);
        for (int elements : arr) {
            System.out.println(elements);
        }
    }
}
