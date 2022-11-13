import java.io.IOException;
import java.util.*;

public class PasswordValidator {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        boolean isValid1 = checkLength(password);
        boolean isValid2 = checkContent(password);
        boolean isValid3 = checkDigits(password);
        if (!isValid1) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!isValid2) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!isValid3) {
            System.out.println("Password must have at least 2 digits");
        }
        if (isValid1 && isValid2 && isValid3) {
            System.out.println("Password is valid");
        }
    }

    public static boolean checkLength(String password) {
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkDigits(String password) {
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9' || ch == '0') {
                counter++;
            }
        }
        if (counter < 2) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkContent(String password) {
        for (char symbol : password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        return true;
    }
}
