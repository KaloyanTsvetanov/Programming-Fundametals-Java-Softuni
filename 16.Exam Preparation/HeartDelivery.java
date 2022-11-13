import java.util.*;
import java.util.stream.Collectors;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> house = Arrays
                .stream(input.split("@"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int lastPosition = 0;
        input = scanner.nextLine();
        while (!input.equals("Love!")) {
            String[] jumps = input.split(" ");

            int length = Integer.parseInt(jumps[1]);
            lastPosition+=length;
            if (lastPosition >= house.size()) {
                lastPosition = 0;
            }
            if (house.get(lastPosition) != 0) {
                int minus = house.get(lastPosition)-2;
                house.set(lastPosition, minus);
                if (house.get(lastPosition) == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", lastPosition);
                }
            } else {
                System.out.printf("Place %d already had Valentine's day.%n", lastPosition);
            }

            input = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", lastPosition);
        int vD = 0;
        int noVd = 0;
        for (int i = 0; i < house.size(); i++) {
            if (house.get(i) == 0) {
                vD++;
            } else {
                noVd++;
            }
        }
        if (vD == house.size()) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", noVd);
        }
    }
}
