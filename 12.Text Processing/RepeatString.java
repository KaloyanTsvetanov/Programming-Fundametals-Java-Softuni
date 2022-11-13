import java.util.*;

public class RepeatString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] words = input.split(" ");
        String result1 = "";
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                String word = words[i];
                result1 = result1.concat(word);
            }
        }
        System.out.println(result1);
    }
}
