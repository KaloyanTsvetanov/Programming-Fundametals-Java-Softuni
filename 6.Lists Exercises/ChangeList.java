import java.util.*;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> numberList = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        input = scanner.nextLine();
        while (!input.equals("end")){
            List<String> actionList = Arrays
                    .stream(input.split(" "))
                    .collect(Collectors.toList());
            switch (actionList.get(0)){
                case "Delete":
                    int deleteNumber = Integer.parseInt(actionList.get(1));
                    for (int i = 0; i < numberList.size(); i++) {
                        if(deleteNumber==numberList.get(i)){
                            numberList.remove(i);
                            i-=1;
                        }
                    }
                    break;
                case"Insert":
                    int element = Integer.parseInt(actionList.get(1));
                    int index = Integer.parseInt(actionList.get(2));
                    numberList.add(index,element);
                    break;
            }
            input = scanner.nextLine();
        }
        for(int n : numberList) {
            System.out.print(n+" ");
        }
    }
}
