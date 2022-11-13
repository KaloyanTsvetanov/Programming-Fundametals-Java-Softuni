import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input= scanner.nextLine();
        List<Double> arrList = Arrays
                .stream(input.split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        Map<Double,Integer> myMap = new TreeMap<>();

        for (Double currentNum : arrList){
            if(!myMap.containsKey(currentNum)){
                myMap.put(currentNum,1);
            }
        }
        for (Map.Entry<Double, Integer> entry : myMap.entrySet()) {
            Double currentValue = entry.getKey();
            int counter = 0;
            for (int i = 0; i < arrList.size(); i++) {
                if(arrList.get(i).equals(currentValue)){
                    counter++;
                }
            }
            entry.setValue(counter);
        }
        DecimalFormat df = new DecimalFormat("#.#######");
        for (Map.Entry<Double, Integer> doubleIntegerEntry : myMap.entrySet()) {
            System.out.printf("%s -> %d%n",df.format(doubleIntegerEntry.getKey()),doubleIntegerEntry.getValue());
        }
    }
}
