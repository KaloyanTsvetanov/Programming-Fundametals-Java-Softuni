import java.util.Scanner;

public class RecursiveFibonaci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];
        int max = 0;
        int index =0;
        for(int i =2; i<n; i++){
            array[0]=1;
            array[1]=1;
            array[i]=array[i-1]+array[i-2];
            index=i;
        }
        if(n>2) {
            System.out.println(array[index]);
        }else System.out.println("1");
    }
}
