import java.io.IOException;
import java.util.*;

public class MiddleChars {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        getMiddle(word);

    }
    public static void getMiddle(String word) {
        if (word.length() % 2 != 0) {
            char ch = word.charAt(0);
            for (int i = 0; i <= word.length()/2; i++) {
                ch = word.charAt(i);
            }
            System.out.println(ch);
        }else {
            char ch = word.charAt(0);
            char ch1 = word.charAt(0);
            for (int i = 1; i < (word.length()/2)+1; i++) {
                ch = word.charAt(i-1);
                ch1 = word.charAt(i);
            }
            System.out.println((ch+""+ch1));
        }
    }
}
