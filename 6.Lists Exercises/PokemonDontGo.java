import java.util.*;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> distanceList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sum = 0;
        while (distanceList.size() > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            if (n >= 0 && n < distanceList.size()) {
                int compareIndex = distanceList.get(n);
                sum+=distanceList.get(n);
                distanceList.remove(n);
                for (int i = 0; i < distanceList.size(); i++) {
                    if (distanceList.get(i) <= compareIndex) {
                        distanceList.set(i, compareIndex + distanceList.get(i));
                    } else distanceList.set(i, distanceList.get(i) - compareIndex);
                }
            }else if (n<0){
                int lastElement = distanceList.get(distanceList.size()-1);
                int removedElement = distanceList.get(0);
                sum+=distanceList.get(0);
                distanceList.remove(0);
                distanceList.add(0,lastElement);
                for (int i = 0; i < distanceList.size(); i++) {
                    if (distanceList.get(i) <= removedElement) {
                        distanceList.set(i, removedElement + distanceList.get(i));
                    } else distanceList.set(i, distanceList.get(i) - removedElement);
                }
            }else {
                int firstElement = distanceList.get(0);
                int removedElement = distanceList.get(distanceList.size()-1);
                sum+=distanceList.get(distanceList.size()-1);
                distanceList.remove(distanceList.size()-1);
                distanceList.add(firstElement);
                for (int i = 0; i < distanceList.size(); i++) {
                    if (distanceList.get(i) <= removedElement) {
                        distanceList.set(i, removedElement + distanceList.get(i));
                    } else distanceList.set(i, distanceList.get(i) - removedElement);
                }
            }
        }
        System.out.println(sum);
    }
}
