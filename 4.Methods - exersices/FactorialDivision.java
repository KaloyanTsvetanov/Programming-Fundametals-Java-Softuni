import java.io.IOException;
import java.util.*;

public class FactorialDivision {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        double result = sum(n1,n2);
        System.out.printf("%.2f",result);
    }

    public static double sum(int a, int b) {
        double sum1 = 1;
        double sum2 = 1;
        double sum = 0;
        for (int i = 1; i <=a ; i++) {
            sum1*=i;
        }
        for (int i = 1; i <=b ; i++) {
            sum2*=i;
        }
        sum = sum1/sum2;
        return sum;
    }
}
