import java.io.IOException;
import java.util.*;

public class TribonaciSequence {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int p =0;
        int j = 0;
        int k = 1;
        int t = 0;
        System.out.print("1 ");
        for (int i = 1; i <n; i++) {
            t= k+j+p;
            p=j;
            j=k;
            k=t;
            System.out.print(t+" ");
        }
    }
}
