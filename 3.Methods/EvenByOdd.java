import java.util.*;

public class EvenByOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(getMultiply(n));
    }

    public static int getMultiply(int n) {
        int sumOdd = 0;
        int sumEven = 0;
        while (n != 0) {
            int lastNumber = n % 10;
            if(lastNumber%2==0){
                sumEven+=lastNumber;
            }else sumOdd+=lastNumber;
            n/=10;
        }
        return sumEven*sumOdd;
    }
}
