import java.util.*;
import java.util.stream.Collectors;

public class OddOccurrences {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        List<String> stringList = Arrays
                .stream(input.split(" "))
                .collect(Collectors.toList());
        Map<String, Integer> countMap = new LinkedHashMap<>();
        int n = stringList.size();
        for (int i = 0; i < n; i++) {
            countMap.putIfAbsent(stringList.get(i), 0);
            int currentValue = countMap.get(stringList.get(i));
            countMap.put(stringList.get(i), currentValue += 1);
        }
        String result = "";
        for (Map.Entry<String, Integer> integerEntry : countMap.entrySet()) {
            if (integerEntry.getValue() % 2 != 0) {
                result = result + " " + integerEntry.getKey();

            }
        }
        result=result.replaceFirst(" ","");
        result= result.replaceAll(" ",", ");
        System.out.println(result);

    }
}
