import java.util.*;
import java.util.stream.Collectors;

public class ListManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> firstList = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        while (!input.equals("end")) {
            input = scanner.nextLine();
            List<String> subList = Arrays
                    .stream(input.split(" "))
                    .collect(Collectors.toList());
            if (subList.get(0).equals("Contains")) {
                int number = Integer.parseInt(subList.get(1));
                if (firstList.contains(number)) {
                    System.out.println("Yes");
                } else System.out.println("No such number");
            }

            if (subList.get(0).equals("Print")) {
                if (subList.get(1).equals("even")) {
                    for (int even : firstList) {
                        if (even % 2 == 0) {
                            System.out.print(even + " ");
                        }
                    }
                    System.out.println();
                } else if (subList.get(1).equals("odd")) {
                    for (int odd : firstList) {
                        if (odd % 2 != 0) {
                            System.out.print(odd + " ");
                        }
                    }
                    System.out.println();
                }
            }

            if (subList.get(0).equals("Get")) {
                int sum = 0;
                for (int n : firstList) {
                    sum += n;
                }
                System.out.println(sum);
            }

            if (subList.get(0).equals("Filter")) {
                int index = Integer.parseInt(subList.get(2));
                for (int n : firstList) {
                    switch (subList.get(1)) {
                        case ">":
                            if (n > index) {
                                System.out.print(n + " ");
                            }
                            break;
                        case ">=":
                            if (n >= index) {
                                System.out.print(n + " ");
                            }
                            break;
                        case "<":
                            if (n < index) {
                                System.out.print(n + " ");
                            }
                            break;
                        case "<=":
                            if (n <= index) {
                                System.out.print(n + " ");
                            }
                            break;
                    }
                }
                System.out.println();
            }
        }
    }
}
