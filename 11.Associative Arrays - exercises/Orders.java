import java.util.*;

public class Orders {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,List<Double>> productMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("buy")){

            String name = input.split(" ")[0];
            double price = Double.parseDouble(input.split(" ")[1]);
            double quantity = Double.parseDouble(input.split(" ")[2]);
            List<Double> currentSums = new ArrayList<>();
            currentSums.add(price);
            currentSums.add(quantity);

            if(productMap.containsKey(name)){
                double currentQuantity = productMap.get(name).get(1);
                productMap.get(name).set(1,quantity+currentQuantity);
                productMap.get(name).set(0,price);

            } else {
                productMap.put(name,currentSums);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, List<Double>> entry : productMap.entrySet()) {
            double sum = entry.getValue().get(0)*entry.getValue().get(1);
            System.out.printf("%s -> %.2f%n",entry.getKey(),sum);
        }

    }
}
