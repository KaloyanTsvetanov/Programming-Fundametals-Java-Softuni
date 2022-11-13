import java.util.*;
import java.util.stream.Collectors;

public class MerginList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> firstList = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        input = scanner.nextLine();
        List<Integer> secondList = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();

        int minSize = Math.min(firstList.size(), secondList.size());
        for (int i = 0; i < minSize; i++) {
            int firstItem = firstList.get(i);
            int secondItem = secondList.get(i);
            resultList.add(firstItem);
            resultList.add(secondItem);
        }
        if (firstList.size() > secondList.size()) {
            for (int i = minSize; i < firstList.size(); i++) {
                int firstItem = firstList.get(i);
                resultList.add(firstItem);
            }
        } else {
            for (int i = minSize; i < secondList.size(); i++) {
                int firstItem = secondList.get(i);
                resultList.add(firstItem);
            }
        }
        for (int items : resultList) {
            System.out.print(items + " ");
        }
    }
}
