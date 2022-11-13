import java.util.*;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> numbersList = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        input = scanner.nextLine();
        while (!input.equals("end")){
            String[] commands = input.split(" ");
            if(commands[0].equals("swap")){
                int index1 = Integer.parseInt(commands[1]);
                int index2 = Integer.parseInt(commands[2]);
                Collections.swap(numbersList,index1,index2);
            }
            if(commands[0].equals("multiply")){
                int index1 = Integer.parseInt(commands[1]);
                int index2 = Integer.parseInt(commands[2]);
                numbersList.set(index1,(numbersList.get(index1)*numbersList.get(index2)));
            }
            if(commands[0].equals("decrease")){
                for (int i = 0; i < numbersList.size(); i++) {
                    numbersList.set(i,numbersList.get(i)-1);
                }
            }


            input = scanner.nextLine();
        }
        for (int i = 0; i < numbersList.size(); i++) {
            if(i==numbersList.size()-1){
                System.out.println(numbersList.get(i));
            }else {
                System.out.print(numbersList.get(i)+", ");
            }
        }
    }
}
