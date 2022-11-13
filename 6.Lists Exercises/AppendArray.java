import java.util.*;
import java.util.stream.Collectors;

public class AppendArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> ourList = Arrays
                .stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());
        List<String> newList = new ArrayList<>();
        int j = 0;
        for(int i = ourList.size()-1; i>=0; i--){
            newList.add(ourList.get(i));
            j++;
        }
        String result = newList.toString().replaceAll("[\\]\\[,]","").trim();
        result = result.replaceAll("\\s+"," ");
        System.out.println(result);
    }
}
