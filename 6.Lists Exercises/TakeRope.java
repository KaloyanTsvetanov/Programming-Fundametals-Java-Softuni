import java.util.*;
import java.util.stream.Collectors;

public class TakeRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> firstArray = Arrays
                .stream(input.split(""))
                .collect(Collectors.toList());
        List<Integer> numList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        List<String> letterList = new ArrayList<>();
        for (int i = 0; i < firstArray.size(); i++) {
            if (firstArray.get(i).equals("1") || firstArray.get(i).equals("2") || firstArray.get(i).equals("3") || firstArray.get(i).equals("4") || firstArray.get(i).equals("5") ||
                    firstArray.get(i).equals("6") || firstArray.get(i).equals("7") || firstArray.get(i).equals("8") || firstArray.get(i).equals("9") || firstArray.get(i).equals("0")) {
                int num = Integer.parseInt(firstArray.get(i));
                numList.add(num);
            } else letterList.add(firstArray.get(i));
        }
        for (int i = 0; i < numList.size(); i++) {
            if (i % 2 == 0) {
                evenList.add(numList.get(i));
            } else oddList.add(numList.get(i));
        }
        String result = "";
        int p = 0;
        while (letterList.size() > 0 && p < evenList.size() && p < oddList.size()) {
            int evenIndex = evenList.get(p);
            int oddIndex = oddList.get(p);
            if (evenIndex > letterList.size()) {
                evenIndex = letterList.size();
            }
            if (oddIndex > letterList.size()) {
                oddIndex = letterList.size();
            }
            int counter = evenIndex + oddIndex;
            for (int i = 0; i < evenIndex; i++) {
                result += letterList.get(i);

            }
            while (counter > 0) {
                if (letterList.size() == 0) {
                    break;
                }
                letterList.remove(0);
                counter--;
            }
            p++;
        }
        System.out.println(result);
    }
}
