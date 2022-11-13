import java.util.*;
import java.util.stream.Collectors;

public class RandomizeWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> newList = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        while (newList.size()>0){
            Random rnd = new Random();
            int index = rnd.nextInt(newList.size());
            System.out.println(newList.get(index));
            newList.remove(index);

        }

    }
}
