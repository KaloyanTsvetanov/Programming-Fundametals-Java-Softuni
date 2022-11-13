import java.text.DecimalFormat;
import java.util.*;

public class MinerTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Double> resourceMap = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            String resource = input;
            double quantity = Double.parseDouble(scanner.nextLine());
            if (!resourceMap.containsKey(resource)) {
                resourceMap.put(resource, quantity);
            } else {
                double currentQuantity = resourceMap.get(resource);
                resourceMap.put(resource, currentQuantity + quantity);
            }

            input = scanner.nextLine();
        }
        DecimalFormat df = new DecimalFormat("#.##########");
        resourceMap.
                forEach((key, value) -> System.out.println(key + " -> " + df.format(value)));

    }
}
