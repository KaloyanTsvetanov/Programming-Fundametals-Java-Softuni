import java.util.*;

public class CountChars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        Map<String,Integer> textMap = new LinkedHashMap<>();
        for (int i = 0; i < words.length; i++) {
            String[] currentWord = words[i].split("");
            for (int j = 0; j < currentWord.length; j++) {
                String ch = currentWord[j];

                if(!textMap.containsKey(ch)){
                    textMap.put(ch,0);
                }
                Integer currentCount = textMap.get(ch);
                textMap.put(ch,currentCount+1);
            }
        }
        for (Map.Entry<String, Integer> integerEntry : textMap.entrySet()) {
            System.out.println(integerEntry.getKey()+" -> "+integerEntry.getValue());
        }

    }
}
