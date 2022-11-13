import java.io.IOException;
import java.util.*;

public class DataTypes {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input) {
            case "int":
                int n = Integer.parseInt(scanner.nextLine());
                number(n);
                break;
            case "real":
                double n1 = Double.parseDouble(scanner.nextLine());
                realNumber(n1);
                break;
            case "string": String word = scanner.nextLine();
                realString(word);
                break;
        }
    }

    public static void number(int n) {
        System.out.println(n * 2);
    }

    public static void realNumber(double n) {
        System.out.printf("%.2f",n * 1.5);
    }

    public static void realString(String word) {
        System.out.println("$" + word + "$");
    }
}
