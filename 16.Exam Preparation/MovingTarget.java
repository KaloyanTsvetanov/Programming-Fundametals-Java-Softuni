import java.util.*;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> movingTargets = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        input = scanner.nextLine();
        while (!input.equals("End")) {
            List<String> commands = Arrays
                    .stream(input.split(" "))
                    .collect(Collectors.toList());
            int index = Integer.parseInt(commands.get(1));
            if (index >= 0 && index < movingTargets.size()) {
                switch (commands.get(0)) {
                    case "Shoot":
                        int power = Integer.parseInt(commands.get(2));
                        int currentValue = movingTargets.get(index);
                        movingTargets.set(index, currentValue - power);
                        if (movingTargets.get(index) <= 0) {
                            movingTargets.remove(index);
                        }
                        break;
                    case "Add":
                        int value = Integer.parseInt(commands.get(2));
                        movingTargets.add(index, value);
                        break;
                    case "Strike":
                        int radius = Integer.parseInt(commands.get(2));
                        if (index - radius >= 0 && index + radius < movingTargets.size()) {
                            int fromTo = index+radius;
                            for (int i = (index - radius); i <= fromTo;) {
                                movingTargets.remove(i);
                                fromTo--;
                            }
                        } else {
                            System.out.println("Strike missed!");
                        }
                        break;

                }
            } else {
                if (commands.get(0).equals("Add")) {
                    System.out.println("Invalid placement!");
                }
            }

            input = scanner.nextLine();
        }
        for (int i = 0; i < movingTargets.size(); i++) {
            int n =movingTargets.get(i);
            if(i==movingTargets.size()-1){
                System.out.print(n);
            }else {
                System.out.print(n+"|");
            }
        }
    }
}
