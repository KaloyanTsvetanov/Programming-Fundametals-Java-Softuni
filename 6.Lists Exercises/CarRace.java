import java.util.*;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> numbersList = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int middle = numbersList.size()/2;
        double leftRacer = 0;
        double rightRacer = 0;
        for (int i = 0; i < middle; i++) {
            leftRacer+=numbersList.get(i);
            if(numbersList.get(i)==0){
                leftRacer*=0.8;
            }
        }
        for (int i = numbersList.size()-1; i >middle; i--) {
            rightRacer+=numbersList.get(i);
            if(numbersList.get(i)==0){
                rightRacer*=0.8;
            }
        }
        if(leftRacer<rightRacer) {
            System.out.printf("The winner is left with total time: %.1f", leftRacer);
        } else System.out.printf("The winner is right with total time: %.1f", rightRacer);
    }
}
