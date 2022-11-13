import java.io.IOException;
import java.util.*;

public class AddAndSubtract {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        subtractMethod(a, b, c);
    }

    public static int sumMethod(int first, int second) {
        int sum = 0;
        sum = first + second;
        return sum;
    }

    public static void subtractMethod(int a, int b, int c) {

        System.out.println(sumMethod(a, b) - c);
    }
}
