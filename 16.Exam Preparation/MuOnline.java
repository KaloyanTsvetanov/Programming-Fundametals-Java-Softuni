import java.util.*;
import java.util.stream.Collectors;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialHealth = 100;
        int initialBitcoins = 0;
        String input = scanner.nextLine();
        List<String> room = Arrays
                .stream(input.split("\\|"))
                .collect(Collectors.toList());
        int counter = 0;
        for (int i = 0; i < room.size(); i++) {
            counter++;
            String[] tokens = room.get(i).split(" ");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);
            switch (command) {
                case "potion":
                    initialHealth+=number;
                    if(initialHealth>100){
                        int p = initialHealth-100;
                        number-=p;
                        initialHealth=100;

                    }
                    System.out.printf("You healed for %d hp.%n",number);
                    System.out.printf("Current health: %d hp.%n",initialHealth);
                    break;
                case "chest":
                    initialBitcoins+=number;
                    System.out.printf("You found %d bitcoins.%n",number);
                    break;
                default:
                    initialHealth-=number;
                    if(initialHealth>0){
                        System.out.printf("You slayed %s.%n",command);
                    }else {
                        System.out.printf("You died! Killed by %s.%n",command);
                        System.out.printf("Best room: %d",counter);
                        return;
                    }
                    break;
            }
        }
        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d%n",initialBitcoins);
        System.out.printf("Health: %d",initialHealth);
    }
}
