import java.util.*;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");


        for (int i = 0; i < input.length; i++) {
            String word = input[i];
            boolean onlyLetter = true;
            if(word.length()>2 && word.length()<17){
                for (int j = 0; j < word.length(); j++) {
                    char ch = word.charAt(j);
                    if(!Character.isLetterOrDigit(ch) && ch!='-' && ch!='_'){
                        onlyLetter = false;
                    }
                }
                if(onlyLetter){
                    System.out.println(word);
                }
            }

        }

    }
}
