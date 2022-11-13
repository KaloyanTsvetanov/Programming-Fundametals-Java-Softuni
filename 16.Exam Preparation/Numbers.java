import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> numbersList = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        double sum = 0;
        int minFromTheBest = 1000000000;
        for (int i = 0; i < numbersList.size(); i++) {
            sum+=numbersList.get(i);
        }
        sum=sum/ numbersList.size();
        List<Integer> subList = new ArrayList<>();
        for (int i = 0; i < numbersList.size(); i++) {
            if(numbersList.get(i)>sum){
                subList.add(numbersList.get(i));
            }
            if(subList.size()>5){
                minFromTheBest = 1000000000;
                int saveIndex = 0;
                for (int j = 0; j < subList.size(); j++) {
                    if(subList.get(j)<minFromTheBest){
                        minFromTheBest = subList.get(j);
                        saveIndex =j;
                    }
                }

                subList.remove(saveIndex);
            }
        }
        Collections.sort(subList);
        Collections.reverse(subList);
        for(int n : subList){
            System.out.print(n+" ");
        }
        if(subList.size()==0){
            System.out.println("No");
        }
    }
}
