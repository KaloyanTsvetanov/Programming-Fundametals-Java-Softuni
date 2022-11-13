import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Double> numList = Arrays
                .stream(input.split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        DecimalFormat df = new DecimalFormat("0.####"+" ");
        for (int i = 0; i < numList.size()-1; i++) {
            numList.set(i,numList.get(i)+numList.get(numList.size()-1));
            numList.remove(numList.size()-1);
        }
        for(double num : numList){
            System.out.print(df.format(num));
        }
    }
}
