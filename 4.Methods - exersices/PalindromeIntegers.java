import java.io.IOException;
import java.util.*;

public class PalindromeIntegers {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            boolean isPalindrome = palindrome(input);
            if (isPalindrome) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            input = scanner.nextLine();
        }

    }

    public static boolean palindrome(String number) {
        int[] firstArray = Arrays
                .stream(number.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondArray = new int[number.length()];
        int j = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            secondArray[j] = firstArray[i];
            j++;
        }
        int counter = 0;
        for (int i = 0; i < firstArray.length; i++) {
            if(firstArray[i]==secondArray[i]){
                counter++;
            }
        }
        if (counter==firstArray.length){
            return true;
        }else return false;
    }
}
