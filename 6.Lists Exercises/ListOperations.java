import java.util.*;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> numbersList = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        input = scanner.nextLine();
        while (!input.equals("End")) {
            List<String> subList = Arrays
                    .stream(input.split(" "))
                    .collect(Collectors.toList());
            if (subList.get(0).equals("Add")) {
                int addNumber = Integer.parseInt(subList.get(1));
                numbersList.add(addNumber);
            } else if (subList.get(0).equals("Insert")) {
                int addNumber = Integer.parseInt(subList.get(1));
                int index = Integer.parseInt(subList.get(2));
                if (index >= 0 && index < numbersList.size()) {
                    numbersList.add(index, addNumber);
                }else System.out.println("Invalid index");
            } else if (subList.get(0).equals("Remove")) {
                int index = Integer.parseInt(subList.get(1));
                if (index >= 0 && index < numbersList.size()) {
                    numbersList.remove(index);
                }else System.out.println("Invalid index");
            }

            if (subList.get(1).equals("left")) {
                int n = Integer.parseInt(subList.get(2));
                for (int i = 0; i < n; i++) {
                    int getNUmber = numbersList.get(0);
                    numbersList.remove(0);
                    numbersList.add(getNUmber);
                }
            } else if (subList.get(1).equals("right")) {
                int n = Integer.parseInt(subList.get(2));
                for (int i = 0; i < n; i++) {
                    int getNUmber = numbersList.get(numbersList.size() - 1);
                    numbersList.remove(numbersList.size() - 1);
                    numbersList.add(0, getNUmber);
                }
            }
            input = scanner.nextLine();

        }
        for (int n : numbersList) {
            System.out.print(n + " ");
        }
    }
}
