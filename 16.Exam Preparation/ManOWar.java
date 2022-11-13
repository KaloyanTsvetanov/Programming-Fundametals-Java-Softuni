import java.util.*;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> pirateShip = Arrays
                .stream(input.split("\\>"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        input = scanner.nextLine();
        List<Integer> warShip = Arrays
                .stream(input.split("\\>"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int maxHealthCapacity = Integer.parseInt(scanner.nextLine());
        boolean warShipHasSunk = false;
        boolean pirateShipHasSunk = false;
        boolean staleMate = true;
        input = scanner.nextLine();
        while (!input.equals("Retire")) {

            String[] commands = input.split(" ");

            if (commands[0].equals("Fire")) {
                int index = Integer.parseInt(commands[1]);
                int damage = Integer.parseInt(commands[2]);
                if (index >= 0 && index < warShip.size()){
                    int health = warShip.get(index);
                    health-=damage;
                    if(health<=0){
                        warShipHasSunk= true;
                        staleMate = false;
                        break;
                    }else {
                        warShip.set(index,health);
                    }
                }
            }


            if (commands[0].equals("Defend")) {
                int startIndex = Integer.parseInt(commands[1]);
                int endIndex = Integer.parseInt(commands[2]);
                int damage = Integer.parseInt(commands[3]);
                if ((startIndex >= 0 && startIndex < pirateShip.size()) && (endIndex >= 0 && endIndex < pirateShip.size())){
                    for (int i = startIndex; i <= endIndex; i++) {
                        int health = pirateShip.get(i);
                        health-=damage;
                        if(health<=0){
                            pirateShipHasSunk=true;
                            staleMate = false;
                            break;
                        }else {
                            pirateShip.set(i,health);
                        }
                    }
                }
            }


            if (commands[0].equals("Repair")) {
                int index = Integer.parseInt(commands[1]);
                int healthRepair = Integer.parseInt(commands[2]);
                if (index >= 0 && index < pirateShip.size()){
                    int health = pirateShip.get(index);
                    health+=healthRepair;
                    if(health>maxHealthCapacity){
                        health=maxHealthCapacity;
                    }
                    pirateShip.set(index,health);
                }
            }


            if (commands[0].equals("Status")) {
                int counter = 0;
                for (int i = 0; i < pirateShip.size(); i++) {
                    int currentSection = pirateShip.get(i);
                    if(currentSection<maxHealthCapacity*0.2){
                        counter++;
                    }
                }
                System.out.printf("%d sections need repair.%n",counter);

            }
            input = scanner.nextLine();
        }
        if(warShipHasSunk){
            System.out.println("You won! The enemy ship has sunken.");
        }
        if(pirateShipHasSunk){
            System.out.println("You lost! The pirate ship has sunken.");
        }
        if(staleMate){
            int pirateStatus = 0;
            int warStatus = 0;
            for (int n :pirateShip){
                pirateStatus+=n;
            }
            for (int n :warShip){
                warStatus+=n;
            }
            System.out.printf("Pirate ship status: %d%n",pirateStatus);
            System.out.printf("Warship status: %d",warStatus);
        }

    }
}
