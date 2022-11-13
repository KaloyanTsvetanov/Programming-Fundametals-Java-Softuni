import java.util.*;

public class CharMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String firstWord = input.split(" ")[0];
        String secondWord = input.split(" ")[1];
        int minLength =Math.min(firstWord.length(), secondWord.length());
        int maxLength =Math.max(firstWord.length(), secondWord.length());
        int sum = 0;
        for (int i = 0; i < minLength; i++) {
            int a = (int) firstWord.charAt(i);
            int b = (int) secondWord.charAt(i);
            sum+=(a*b);
        }
        for (int i = minLength; i < maxLength; i++) {
            if(firstWord.length()==maxLength){
                int a = (int) firstWord.charAt(i);
                sum+=a;
            } else {
                int a = (int) secondWord.charAt(i);
                sum+=a;
            }
        }
        System.out.println(sum);

    }
}
