import java.util.*;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> sequenceList = Arrays
                .stream(input.split(" "))
                .collect(Collectors.toList());
        input = scanner.nextLine();
        int counter = 1;
        boolean wonTheGame = true;
        while (!input.equals("end")) {
            int middle = sequenceList.size() / 2;
            int[] indexes = Arrays
                    .stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (wonTheGame) {
                if (indexes[0] == indexes[1] || indexes[0] < 0 || indexes[1] < 0 || indexes[0] > sequenceList.size() - 1 || indexes[1] > sequenceList.size() - 1) {
                    String penalty = "-" + (counter) + "a";
                    sequenceList.add(middle, penalty);
                    sequenceList.add(middle, penalty);
                    System.out.println("Invalid input! Adding additional elements to the board");
                } else {
                    String first = sequenceList.get(indexes[0]);
                    String second = sequenceList.get(indexes[1]);
                    if (first.equals(second)) {
                        sequenceList.remove(first);
                        sequenceList.remove(second);
                        System.out.printf("Congrats! You have found matching elements - %s!%n", first);
                    } else {
                        System.out.println("Try again!");
                    }
                    if (sequenceList.size() == 0) {
                        System.out.printf("You have won in %d turns!%n", counter);
                        wonTheGame = false;
                    }
                }
            }
            counter++;
            input = scanner.nextLine();
        }
        if (wonTheGame) {
            System.out.println("Sorry you lose :(");
            for (String result : sequenceList) {
                System.out.print(result + " ");
            }
        }
    }
}
