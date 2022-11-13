import java.util.*;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();
        System.out.println(printMin(n1, n2, n3));
    }

    public static int printMin(int n, int n1, int n2) {
        int min;
        min = Math.min(n, n1);
        return (Math.min(min, n2));
    }
}
