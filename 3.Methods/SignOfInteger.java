import java.util.Scanner;

public class SignOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        printIsItPositive(number);
    }

    public static void printIsItPositive(int number){
        if(number>0){
            System.out.printf("The number %d is positive.",number);
        } else if(number<0){
            System.out.printf("The number %d is negative.",number);
        } else {
            System.out.printf("The number %d is zero.",number);
        }
    }
}
