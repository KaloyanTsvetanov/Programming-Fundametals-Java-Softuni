import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> furniture = new ArrayList<>();
        double totalSum = 0;
        String input = scanner.nextLine();
        while (!input.equals("Purchase")){

            Pattern pattern = Pattern.compile(">>([A-Za-z]+)<<([0.0-9]+)!([0-9]+)");
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                furniture.add(matcher.group(1));
                double price = Double.parseDouble(matcher.group(2));
                int quantity = Integer.parseInt(matcher.group(3));
                totalSum+=(price*quantity);
            }

            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for(String word : furniture){
            System.out.println(word);
        }
        System.out.printf("Total money spend: %.2f",totalSum);

    }
}
