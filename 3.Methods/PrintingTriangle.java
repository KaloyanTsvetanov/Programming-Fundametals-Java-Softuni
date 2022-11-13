import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printColumn(n);
    }

    public static void printColumn(int num) {
        for (int i = 1; i <= num; i++) {
            printRow(1,i);
        }
        for (int i = num-1; i >=1; i--) {
            printRow(1,i);
        }
    }
    public static void printRow(int start, int end){
        for (int i = start; i <=end; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
