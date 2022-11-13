import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameInput = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        String result = inputString(nameInput,n);
        System.out.println(result);
    }

    public static String inputString(String name, int n) {
        String result = "";
        for(int i=1; i<=n; i++) {
            result += name;
        }
        return result;
    }
}
