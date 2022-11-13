import java.util.*;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        String text = scanner.nextLine();
        for(String word : input){
            if(text.contains(word)){
                text=text.replace(word,repeatString("*",word.length()));
            }
        }
        System.out.println(text);

    }
    public static String repeatString(String s, int count){

        String result = "";
        for (int i = 0; i < count; i++) {
            result+=s;
        }
        return result;
    }
}
