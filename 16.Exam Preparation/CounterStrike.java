import java.util.*;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        int counter = 0;

        boolean noEnergy = false;

        while (!input.equals("End of battle")){
            int distance = Integer.parseInt(input);
            if(initialEnergy>0 && distance<=initialEnergy) {
                initialEnergy -= distance;
                counter++;
                if(counter%3==0){
                    initialEnergy+=counter;
                }
            }else {
                noEnergy =true;
                break;
            }

            input=scanner.nextLine();
        }
        if(noEnergy){
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy",counter,initialEnergy);
        }else{
            System.out.printf("Won battles: %d. Energy left: %d",counter,initialEnergy);
        }
    }
}
