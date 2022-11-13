import java.util.*;
import java.util.stream.Collectors;

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> firstDeckList = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        input = scanner.nextLine();
        List<Integer> secondDeckList = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        boolean first = false;
        int sum = 0;
        while (firstDeckList.size() != 0 && secondDeckList.size() != 0) {
            int i = 0;
            int cardSecondDeck = secondDeckList.get(i);
            int cardFirstDeck = firstDeckList.get(i);
            if (cardFirstDeck == cardSecondDeck) {
                firstDeckList.remove(i);
                secondDeckList.remove(i);
            } else if (cardFirstDeck > cardSecondDeck) {
                firstDeckList.add(cardFirstDeck);
                firstDeckList.add(cardSecondDeck);
                firstDeckList.remove(i);
                secondDeckList.remove(i);
            } else  {
                secondDeckList.add(cardSecondDeck);
                secondDeckList.add(cardFirstDeck);
                secondDeckList.remove(i);
                firstDeckList.remove(i);
            }

            if(firstDeckList.size()==0){
                first = true;
            } else if(secondDeckList.size()==0){
                first = false;
            }

        }
        if(first){
            for(int n : secondDeckList){
                sum+=n;
            }
            System.out.printf("Second player wins! Sum: %d",sum);
        } else {
            for(int n : firstDeckList){
                sum+=n;
            }
            System.out.printf("First player wins! Sum: %d",sum);
        }

    }
}
