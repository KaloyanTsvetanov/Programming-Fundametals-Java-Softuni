import java.util.*;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] codes = input.split("\\s+");

        double sum = 0;

        for (String code : codes) {

            double localSum = getSum(code);
            sum += localSum;

        }
        System.out.printf("%.2f", sum);

    }

    private static double getSum(String code) {
        char firstLetter =code.charAt(0);
        char secondLetter =code.charAt(code.length()-1);
        double number = Double.parseDouble(code.substring(1,code.length()-1));

        if(Character.isUpperCase(firstLetter)){
            int firstPosition =(int) firstLetter - 64;
            number/=firstPosition;
        }else {
            int firstPosition =(int) firstLetter - 96;
            number*=firstPosition;
        }
        if(Character.isUpperCase(secondLetter)){
            int secondPosition =(int) secondLetter - 64;
            number-=secondPosition;
        }else{
            int secondPosition =(int) secondLetter - 96;
            number+=secondPosition;
        }

        return number;
    }
}
