import java.util.*;

public class SoftUniParking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> carMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n > 0) {
            String input = scanner.nextLine();
            String action = input.split(" ")[0];
            if (action.equals("register")) {

                String userName = input.split(" ")[1];
                String carLicense = input.split(" ")[2];
                if (carMap.containsKey(userName)) {
                    System.out.println("ERROR: already registered with plate number " + carMap.get(userName));
                } else {
                    carMap.put(userName, carLicense);
                    System.out.println(userName + " registered " + carLicense + " successfully");
                }
            }
            if (action.equals("unregister")) {
                String userName = input.split(" ")[1];
                if (carMap.containsKey(userName)) {
                    System.out.println(userName + " unregistered successfully");
                    carMap.remove(userName);
                } else {
                    System.out.println("ERROR: user " + userName + " not found");
                }
            }
            n--;
        }

        carMap
                .forEach((key, value) -> System.out.println(key + " => " + value));
    }
}
