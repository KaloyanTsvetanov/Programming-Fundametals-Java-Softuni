import java.util.*;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder text = new StringBuilder(input);
        int power = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if(ch=='>'){
                String ch1 = text.charAt(i+1)+"";
                int attack = Integer.parseInt(ch1);
                power+=attack;
            }
            else if(ch!='>'&& power>0){
                text.deleteCharAt(i);
                power--;
                i--;
            }
        }
        System.out.println(text);

    }
}
