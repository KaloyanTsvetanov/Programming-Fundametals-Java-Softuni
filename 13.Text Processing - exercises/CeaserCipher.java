import java.util.*;

public class CeaserCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            int a = (int) ch;
            a+=3;
            char newCh = (char) a;
            sb.append(newCh);
        }
        System.out.println(sb);
    }
}
