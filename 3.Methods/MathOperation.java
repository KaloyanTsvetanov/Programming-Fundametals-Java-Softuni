import java.text.DecimalFormat;
import java.util.*;

public class MathOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNumber = Double.parseDouble(scanner.nextLine());
        String action = scanner.nextLine();
        double secondNumber = Double.parseDouble(scanner.nextLine());
        DecimalFormat df = new DecimalFormat("0.##");
        System.out.println(df.format(getMultiply(firstNumber,action,secondNumber)));
    }

    public static double getMultiply(double firstNumber, String action, double secondNumber) {
        double answer = 0;
        switch (action) {
            case "/": answer= firstNumber/secondNumber;
                break;
            case "*": answer= firstNumber*secondNumber;
                break;
            case "+": answer= firstNumber+secondNumber;
                break;
            case "-": answer= firstNumber-secondNumber;
                break;
        }
        return answer;
    }
}
