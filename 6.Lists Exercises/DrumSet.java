import java.util.*;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        List<Integer> firstList = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> initialValue =new ArrayList<>();
        for (int i = 0; i < firstList.size(); i++) {
            int size = firstList.get(i);
            initialValue.add(i, size);
        }
        input = scanner.nextLine();
        while (!input.equals("Hit it again, Gabsy!")){
            int hitPower = Integer.parseInt(input);
            for (int i = 0; i < firstList.size(); i++) {
                int drum = firstList.get(i);
                firstList.set(i,(drum-hitPower));
                if(firstList.get(i)<=0){
                    if(money-(initialValue.get(i)*3)>0){
                        int value = initialValue.get(i);
                        firstList.set(i,value);
                        money-=(value*3);
                    }else {
                        firstList.remove(i);
                        initialValue.remove(i);
                        i--;
                    }
                }
            }

            input=scanner.nextLine();
        }
        for(int n : firstList){
            System.out.print(n+" ");
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.",money);
    }
}
