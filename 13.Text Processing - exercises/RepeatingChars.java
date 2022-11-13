import java.util.*;

public class RepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        for (int i = 0; i < input.length()-1; i++) {
            String ch = input.split("")[i];
            String ch1 = input.split("")[i + 1];
            if (!ch.equals(ch1)) {
                System.out.print(ch);
            }
            if(i==input.length()-2){
                System.out.print(ch1);
            }
        }
    }
}
