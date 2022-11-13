import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstArr = scanner.nextLine().split(" ");
        String[] secondArr = scanner.nextLine().split(" ");
        for (String element :secondArr) {
            for (String element1 : firstArr) {
                if (element.equals(element1)) {
                    System.out.print(element+" ");
                }
            }
        }
    }
}
