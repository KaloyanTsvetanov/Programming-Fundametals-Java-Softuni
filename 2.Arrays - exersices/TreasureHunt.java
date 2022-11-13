import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> initialLoot = Arrays
                .stream(input.split("\\|"))
                .collect(Collectors.toList());
        input = scanner.nextLine();
        while (!input.equals("Yohoho!")) {
            String[] commands = input.split(" ");
            if (commands[0].equals("Loot")) {
                for (int i = 1; i < commands.length; i++) {
                    if (!initialLoot.contains(commands[i])) {
                        initialLoot.add(0, commands[i]);
                    }
                }
            }
            if (commands[0].equals("Drop")) {
                int index = Integer.parseInt(commands[1]);
                if (index >= 0 && index < initialLoot.size()) {
                    String saveLoot = initialLoot.get(index);
                    initialLoot.remove(index);
                    initialLoot.add(saveLoot);
                }
            }
            if (commands[0].equals("Steal")) {
                int count = Integer.parseInt(commands[1]);
                if (count > initialLoot.size()) {
                    count = initialLoot.size();
                }
                List<String> stolenItems = new ArrayList<>(initialLoot.subList(initialLoot.size() - count, initialLoot.size()));

                for (int i = 0; i < stolenItems.size(); i++) {
                    initialLoot.remove(stolenItems.get(i));
                    if (i == stolenItems.size() - 1) {
                        System.out.print(stolenItems.get(i));
                    } else {
                        System.out.print(stolenItems.get(i) + ", ");
                    }
                }
                System.out.println();
            }
            input = scanner.nextLine();
        }
        if (initialLoot.size() > 0) {
            String treasureGain = initialLoot.toString();
            treasureGain = treasureGain.replaceAll("[\\[\\]\\,\\ ]", "");
            int i = treasureGain.length();
            double p = i;
            double averageGain = p / initialLoot.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);
        } else System.out.println("Failed treasure hunt.");
    }
}
