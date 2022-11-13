import java.util.*;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> groceriesList = Arrays
                .stream(input.split("!"))
                .collect(Collectors.toList());
        input = scanner.nextLine();
        while (!input.equals("Go Shopping!")){
            String[] commands = input.split(" ");
            switch (commands[0]){
                case "Urgent":
                    String item = commands[1];
                    if(!groceriesList.contains(item)){
                        groceriesList.add(0,item);
                    }
                    break;
                case "Unnecessary":
                    String itemUnnecessary = commands[1];
                    groceriesList.remove(itemUnnecessary);
                    break;
                case "Correct":
                    String oldItem = commands[1];
                    String newItem = commands[2];
                    if(groceriesList.contains(oldItem)){
                        int index = 0;
                        for (int i = 0; i < groceriesList.size(); i++) {
                            if(groceriesList.get(i).equals(oldItem)){
                                index=i;
                            }
                        }
                        groceriesList.set(index,newItem);
                    }
                    break;
                case "Rearrange":
                    String reArrItem = commands[1];
                    if(groceriesList.contains(reArrItem)){
                        groceriesList.remove(reArrItem);
                        groceriesList.add(reArrItem);
                    }
                    break;


            }

            input = scanner.nextLine();
        }
        String result = groceriesList.toString();
        result=result.replaceAll("!",", ");
        result=result.replaceAll("[]\\[]","");
        System.out.println(result);
    }
}
