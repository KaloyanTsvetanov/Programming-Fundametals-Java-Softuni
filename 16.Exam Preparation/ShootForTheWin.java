import java.util.*;
import java.util.stream.Collectors;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> sequenceList = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        input = scanner.nextLine();
        int counter = 0;
        while (!input.equals("End")){
            int index = Integer.parseInt(input);
            if(index>=0 && index< sequenceList.size() && sequenceList.get(index)!=-1) {
                counter++;
                int valueOfTarget = sequenceList.get(index);
                sequenceList.set(index,-1);
                for (int i = 0; i < sequenceList.size(); i++) {
                    int valueOfOthers = sequenceList.get(i);
                    if (valueOfOthers != -1) {
                        if (valueOfOthers > valueOfTarget) {
                            sequenceList.set(i, valueOfOthers - valueOfTarget);
                        } else {
                            sequenceList.set(i, valueOfOthers + valueOfTarget);
                        }
                    }
                }
            }
            input= scanner.nextLine();
        }
        System.out.printf("Shot targets: %d ->",counter);
        for(int n:sequenceList){
            System.out.print(" "+n);
        }
    }
}
