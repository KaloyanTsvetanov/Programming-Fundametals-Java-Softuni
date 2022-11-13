import java.util.*;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> numbersList = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        input = scanner.nextLine();
        int[] num = Arrays
                .stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int size = numbersList.size();
        int sum = 0;
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) == num[0]) {
                if (i - num[1] >= 0) {
                    for (int j = i - num[1]; j < i; j++) {
                        numbersList.remove(j);
                        j--;
                        i--;
                    }
                } else {
                    for (int j = 0; j < i; j++) {
                        numbersList.remove(j);
                        j--;
                        i--;
                    }
                }
                int p = i;
                if (i + num[1] < numbersList.size()) {
                    for (int j = p + 1; j <= i + num[1]; j++) {
                        numbersList.remove(j);
                        j--;
                        i--;
                    }
                } else {
                    for (int j = numbersList.size() - 1; j > i; j--) {
                        numbersList.remove(j);
                        j--;
                        i--;
                    }
                }
                numbersList.remove(p);
                i = 0;
            }
        }
        for (int n : numbersList) {
            sum += n;
        }
        System.out.println(sum);
    }
}
