import java.util.*;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> numberList = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        input = scanner.nextLine();
        while (!input.equals("end")){
            List<String> actionList = Arrays
                    .stream(input.split(" "))
                    .collect(Collectors.toList());
            switch (actionList.get(0)){
                case "Add":
                    int numberToAdd = Integer.parseInt(actionList.get(1));
                    numberList.add(numberToAdd);
                    break;
                default:
                    int people = Integer.parseInt(actionList.get(0));
                    for (int i = 0; i < numberList.size(); i++) {
                        if(people+numberList.get(i)<=maxCapacity){
                            int sum = numberList.get(i)+people;
                            numberList.set(i,sum);
                            break;
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for(int n : numberList) {
            System.out.print(n+" ");
        }
    }
}
