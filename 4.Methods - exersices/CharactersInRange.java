import java.io.IOException;
import java.util.*;

public class CharactersInRange {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String a= scanner.nextLine();
        String b = scanner.nextLine();
        char a1 = a.charAt(0);
        char b1 = b.charAt(0);
        getVowels(a1,b1);
    }

    public static void getVowels(char firstLetter, char secondLetter) {
        int a = (int) firstLetter;
        int b = (int) secondLetter;
        if(b>a) {
            for (int i = a + 1; i < b; i++) {
                char result = (char) i;
                System.out.print(result + " ");
            }
        }else {
            for (int i = b + 1; i < a; i++) {
                char result = (char) i;
                System.out.print(result + " ");
            }
        }
    }
}
