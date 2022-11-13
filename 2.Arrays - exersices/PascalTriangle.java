import java.util.Scanner;

public class PascalTriangle {
    static int factorial(int n) {
        int f;

        for (f = 1; n > 1; n--) {
            f *= n;
        }
        return f;
    }

    static int ncr(int n, int r) {
        return factorial(n) / (factorial(n - r) * factorial(r));
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        int n, i, j;
        int n1 = scanner.nextInt();

        for (i = 0; i < n1; i++) {
            for (j = 0; j <= i; j++) {
                System.out.print(ncr(i, j) + " ");
            }
            System.out.println();
        }
    }
}
