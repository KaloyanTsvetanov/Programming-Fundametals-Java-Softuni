import java.util.*;

public class LegendaryFarming {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] legendaryItems = {"Shadowmourne", "Valanyr", "Dragonwrath"};
        Map<String, Integer> itemsMap = new LinkedHashMap<>();
        itemsMap.put("shards", 0);
        itemsMap.put("fragments", 0);
        itemsMap.put("motes", 0);
        boolean all = false;
        boolean thereIsShard = false;
        boolean thereIsFragments = false;

        while (!all) {
            String input = scanner.nextLine();
            String[] inputData = input.toLowerCase().split(" ");
            for (int j = 0; j < inputData.length - 1; j += 2) {
                int quantity = Integer.parseInt(inputData[j]);
                String item = inputData[j + 1];
                if (itemsMap.containsKey(item)) {
                    Integer currentQuantity = itemsMap.get(item);
                    itemsMap.put(item, currentQuantity + quantity);
                } else {
                    itemsMap.put(item, quantity);
                }
                int currentSumShard = itemsMap.get("shards");
                int currentSumFragment = itemsMap.get("fragments");
                int currentSumMotes = itemsMap.get("motes");

                if (currentSumShard >= 250) {
                    itemsMap.put("shards", currentSumShard - 250);
                    all = true;
                    thereIsShard = true;
                } else if (currentSumFragment >= 250) {
                    itemsMap.put("fragments", currentSumFragment - 250);
                    all = true;
                    thereIsFragments = true;
                } else if (currentSumMotes >= 250) {
                    itemsMap.put("motes", currentSumMotes - 250);
                    all = true;

                }
                if (all) {
                    break;
                }
            }
        }

        if (thereIsShard) {
            System.out.println(legendaryItems[0] + " obtained!");
        } else if (thereIsFragments) {
            System.out.println(legendaryItems[1] + " obtained!");
        } else {
            System.out.println(legendaryItems[2] + " obtained!");
        }
        itemsMap.
                forEach((key, value) -> System.out.println(key + ": " + value));

    }
}
