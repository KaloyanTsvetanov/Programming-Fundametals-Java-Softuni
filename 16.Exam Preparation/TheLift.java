import java.util.*;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int[] wagons = Arrays
                .stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int i = 0;
        while (wagons[i]==4){
            i++;
        }
        while (wagons[i] < 4 && people > 0) {
            wagons[i]++;
            people--;
            if (wagons[i] == 4 && i < wagons.length - 1) {
                i++;
            }
        }
        if (people == 0 && wagons[wagons.length - 1] == 4) {
            for (i = 0; i < wagons.length; i++) {
                System.out.print(wagons[i] + " ");
            }
        } else if (people == 0 && wagons[wagons.length - 1] < 4) {
            System.out.println("The lift has empty spots!");
            for (i = 0; i < wagons.length; i++) {
                System.out.print(wagons[i] + " ");
            }
        } else if (people > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
            for (i = 0; i < wagons.length; i++) {
                System.out.print(wagons[i] + " ");
            }

        }
    }
}
