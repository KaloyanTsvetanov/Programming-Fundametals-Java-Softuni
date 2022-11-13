import java.util.*;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> inventory = Arrays
                .stream(input.split(", "))
                .collect(Collectors.toList());
        input = scanner.nextLine();
        while (!input.equals("Craft!")) {
            String[] command = input.split(" - ");
            if (command[0].equals("Collect")) {
                String item = command[1];
                if (!inventory.contains(item)) {
                    inventory.add(item);
                }
            }
            if (command[0].equals("Drop")) {
                String item = command[1];
                if (inventory.contains(item)) {
                    inventory.remove(item);
                }
            }
            if (command[0].equals("Renew")) {
                String item = command[1];
                if (inventory.contains(item)) {
                    inventory.remove(item);
                    inventory.add(item);
                }
            }
            if (command[0].equals("Combine Items")) {
                String [] items = command[1].split(":");
                String oldItem = items[0];
                String newItem = items[1];
                if (inventory.contains(oldItem)) {
                    for (int i = 0; i < inventory.size(); i++) {
                        if (inventory.get(i).equals(oldItem)){
                            inventory.add(i+1,newItem);
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < inventory.size(); i++) {
            if(i== inventory.size()-1){
                System.out.print(inventory.get(i));
            }else {
                System.out.print(inventory.get(i) + ", ");
            }
        }
    }
}
