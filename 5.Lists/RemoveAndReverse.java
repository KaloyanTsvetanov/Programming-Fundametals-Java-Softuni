import java.util.*;
import java.util.stream.Collectors;

public class RemoveAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> numberList = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int counter = 0;
        for (int i = 0; i < numberList.size(); i++) {
            if(numberList.get(i)<0){
                numberList.remove(i);
                i-=1;
            } else counter++;
        }
        if (counter>0){
            for (int i = numberList.size()-1; i >= 0; i--) {
                System.out.print(numberList.get(i)+" ");

            }
        }else System.out.println("empty");
    }
}
