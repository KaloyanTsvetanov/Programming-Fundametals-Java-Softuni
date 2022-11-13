import java.util.*;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> numbersList = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        input = scanner.nextLine();
        List<String> codeList = Arrays
                .stream(input.split(""))
                .collect(Collectors.toList());
        int n = numbersList.size();
        String result = "";
        while (n > 0) {
            int index = numbersList.get(0);
            int sumOfEachIndex = 0;
            while (index > 0) {
                sumOfEachIndex += index % 10;
                index /= 10;
            }
            if (sumOfEachIndex < codeList.size()) {
                result += codeList.get(sumOfEachIndex);
                codeList.remove(sumOfEachIndex);
            } else {
                sumOfEachIndex -= codeList.size();
                result += codeList.get(sumOfEachIndex);
                codeList.remove(sumOfEachIndex);
            }
            numbersList.remove(0);
            n--;
        }
        System.out.println(result);
    }
}
