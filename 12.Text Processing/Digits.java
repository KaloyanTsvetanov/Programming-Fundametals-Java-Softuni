import java.util.*;

public class Digits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder digits = new StringBuilder();
        StringBuilder letter = new StringBuilder();
        StringBuilder symbol = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentCh = input.charAt(i);

            if(Character.isDigit(currentCh)){
                digits.append(currentCh);
            }else if(Character.isLetter(currentCh)){
                letter.append(currentCh);
            }else {
                symbol.append(currentCh);
            }

        }
        System.out.printf("%s%n%s%n%s",digits,letter,symbol);

    }
}
