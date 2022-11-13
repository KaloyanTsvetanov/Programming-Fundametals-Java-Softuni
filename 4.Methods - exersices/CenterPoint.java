import java.io.IOException;
import java.util.*;

public class CenterPoint {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        int pointFirst = x1+y1;
        int pointSecond = x2+y2;
        if(pointFirst>=pointSecond) {
            System.out.printf("(%d, %d)", x2,y2);
        } else System.out.printf("(%d, %d)", x1,y1);
    }
}
