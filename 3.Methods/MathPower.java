import java.text.DecimalFormat;
import java.util.*;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a= Double.parseDouble(scanner.nextLine());
        double b= Double.parseDouble(scanner.nextLine());
        double result = inputPower(a,b);

        DecimalFormat df = new DecimalFormat("0.####");
        System.out.println(df.format(result));

    }

    public static double inputPower(double num, double index) {
        double result = 1;
        for (int i = 0; i < index; i++) {
            result*=num;
        }
        return result;
    }
}
