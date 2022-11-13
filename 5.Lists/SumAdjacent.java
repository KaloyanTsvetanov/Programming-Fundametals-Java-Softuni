import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class SumAdjacent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Double> numsList = Arrays
                .stream(input.split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        DecimalFormat df = new DecimalFormat("0.####");
        for (int i = 0; i < numsList.size()-1; i++) {
            if(numsList.get(i).equals(numsList.get(i+1))){
                double sum = numsList.get(i)+numsList.get(i+1);
                numsList.set(i,sum);
                numsList.remove(i+1);
                i = -1;
            }
        }
        for(double num : numsList) {
            System.out.print(df.format(num)+" ");
        }
    }
}
