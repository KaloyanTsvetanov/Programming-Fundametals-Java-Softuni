import java.util.*;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char ch = input.charAt(0);
        input=scanner.nextLine();
        char ch1 =input.charAt(0);
        input =scanner.nextLine();
        int start = (int) ch;
        int end = (int) ch1;
        int sum = 0;
        if(start>end){
            for (int i = 0; i < input.length(); i++) {
                int x = (int) input.charAt(i);
                if(x>end && x<start){
                    sum+=x;
                }
            }
        } else if(start<end){
            for (int i = 0; i < input.length(); i++) {
                int x = (int) input.charAt(i);
                if(x>start && x<end){
                    sum+=x;
                }
            }
        }
        System.out.println(sum);

    }
}
