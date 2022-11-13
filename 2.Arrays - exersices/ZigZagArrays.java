import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [] first = new int[n];
        int [] second = new int[n];
        int counter = 0;
        for (int i = 0; i < n; i++) {
            counter++;
            int[] arr = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j =0; j<= arr.length; j++) {
                if(counter%2==0){
                    first[i]=arr[1];
                    second[i]=arr[0];
                }else {
                    second[i]=arr[1];
                    first[i]=arr[0];
                }
            }
        }
        for(int i = 0 ; i< first.length; i++){
            System.out.print(first[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < second.length; i++) {
            System.out.print(second[i]+" ");
        }
    }
}
