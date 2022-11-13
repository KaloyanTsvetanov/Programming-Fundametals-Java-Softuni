import java.util.*;

public class PersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        while (n>0) {
            n--;
            String input = scanner.nextLine();
            StringBuilder name = new StringBuilder();
            StringBuilder age = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch == '@') {
                    char ch1 = input.charAt(i + 1);
                    while (ch1 != '|') {
                        name.append(ch1);
                        i++;
                        ch1 = input.charAt(i + 1);
                    }
                }
                if (ch == '#') {
                    char ch1 = input.charAt(i + 1);
                    while (ch1 != '*') {
                        age.append(ch1);
                        i++;
                        ch1 = input.charAt(i + 1);
                    }
                }

            }
            System.out.printf("%s is %s years old.%n", name, age);
        }

    }
}
