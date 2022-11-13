import java.io.IOException;
import java.util.*;

public class Matrix {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        getMatrix(n);
    }

    public static void getMatrix(int n) {
        int[] array = new int[n];
        int count = n;
        while (count > 0) {
            for (int i = 0; i < n; i++) {
                array[i] = n;
                System.out.print(array[i] + " ");
            }
            count--;
            System.out.println();
        }
    }
}
