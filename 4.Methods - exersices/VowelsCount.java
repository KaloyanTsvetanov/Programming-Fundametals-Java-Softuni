import java.util.*;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        System.out.println(getVowels(word));
    }

    public static int getVowels(String word) {
        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ch== 'A'|| ch== 'a'|| ch== 'e'|| ch== 'E'||ch== 'i'|| ch== 'I'||ch== 'O'|| ch== 'o'||ch== 'U'|| ch== 'u'){
                counter++;
            }
        }
        return counter;
    }
}
