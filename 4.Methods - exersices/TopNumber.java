import java.io.IOException;
import java.util.*;

public class TopNumber {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [] array = new int[n];
        int j=0;
        for (int i = 17; i <=n ; i++) {
            int sum = 0;
            array[j]=i;
            int index = i;
            int oddIndex = i;
            boolean isOdd = false;
            while (index>0){
                sum+=index%10;
                index/=10;
            }
            while (oddIndex>0){
                int checker = oddIndex%10;
                if(checker%2!=0){
                    isOdd = true;
                }
                oddIndex/=10;
            }
            if(sum%8==0 && isOdd){
                System.out.println(array[j]);
            }
            j++;
        }
    }
}
