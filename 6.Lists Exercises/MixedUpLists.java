import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
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
        List<Integer> mergedList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int smallerList = Math.min(firstList.size(), secondList.size());
        int j = secondList.size()-1;
        for (int i = 0; i < smallerList; i++) {
            mergedList.add(firstList.get(i));
            mergedList.add(secondList.get(j));
            j--;
        }
        int minLimit = 0;
        int maxLimit = 0;
        if (firstList.size() > secondList.size()) {
            minLimit = Math.min(firstList.get(firstList.size() - 2), firstList.get(firstList.size() - 1));
            maxLimit = Math.max(firstList.get(firstList.size() - 2), firstList.get(firstList.size() - 1));
        } else if (firstList.size()< secondList.size()){
            minLimit = Math.min(secondList.get(0), secondList.get(1));
            maxLimit = Math.max(secondList.get(0), secondList.get(1));
        }
        for (int i = 0; i < mergedList.size(); i++) {
            if (mergedList.get(i) > minLimit && mergedList.get(i) < maxLimit) {
                result.add(mergedList.get(i));
            }
        }
        Collections.sort(result);
        for (int n : result) {
            System.out.print(n + " ");
        }
    }
}
