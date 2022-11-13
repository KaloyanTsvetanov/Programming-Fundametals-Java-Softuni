import java.util.Scanner;

public class Calculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        switch (action){
            case "add":printAdd(num1,num2);
                break;
            case "multiply":printMultiply(num1,num2);
                break;
            case "subtract":printSubtract(num1,num2);
                break;
            case "divide":printDivide(num1,num2);
                break;
        }
    }

    public static void printAdd(int a,int b){
        System.out.println(a+b);
    }
    public static void printMultiply(int a,int b){
        System.out.println(a*b);
    }
    public static void printSubtract(int a,int b){
        System.out.println(a-b);
    }
    public static void printDivide(int a,int b){
        System.out.println(a/b);
    }
}
