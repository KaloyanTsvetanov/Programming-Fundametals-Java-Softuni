import java.util.*;
import java.util.stream.Collectors;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> guest = new ArrayList<>();
        while (n > 0) {
            String input = scanner.nextLine();
            List<String> actionList = Arrays
                    .stream(input.split(" "))
                    .collect(Collectors.toList());
            switch (actionList.get(2)) {
                case "going!":
                    String name = actionList.get(0);
                    if (guest.size() == 0) {
                        guest.add(name);
                    } else {
                        boolean isThere = false;
                        for (int i = 0; i < guest.size(); i++) {
                            if(guest.get(i).equals(name)){
                                System.out.printf("%s is already in the list!",name);
                                System.out.println();
                                isThere =true;
                            }
                        } if(!isThere){
                            guest.add(name);
                        }
                    }
                    break;
                case "not":
                    String name1 = actionList.get(0);
                    if (guest.size() == 0) {
                        System.out.printf("%s is not in the list!",name1);
                        System.out.println();
                    } else {
                        boolean isNotThere = false;
                        for (int i = 0; i < guest.size(); i++) {
                            if(guest.get(i).equals(name1)){
                                guest.remove(name1);
                                i-=1;
                                isNotThere =true;
                            }
                        } if(!isNotThere){
                            System.out.printf("%s is not in the list!",name1);
                            System.out.println();
                        }
                    }
                    break;
            }
            n--;
        }
        for(String guests :guest){
            System.out.println(guests);
        }
    }
}
