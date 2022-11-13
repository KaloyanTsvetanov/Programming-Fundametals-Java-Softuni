import java.util.*;

public class CompanyUsers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courseMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String companyName = input.split("->")[0];
            String iD = input.split("->")[1];
            if (courseMap.containsKey(companyName)) {
                if (!courseMap.get(companyName).contains(iD)) {
                    courseMap.get(companyName).add(iD);
                }

            } else {
                List<String> currentName = new ArrayList<>();
                currentName.add(iD);
                courseMap.put(companyName, currentName);
            }


            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : courseMap.entrySet()) {
            int size = entry.getValue().size();
            String result = entry.getKey();
            result = result.replaceAll(" ", "");
            System.out.println(result);
            for (int i = 0; i < size; i++) {
                System.out.println("--" + entry.getValue().get(i));
            }
        }


    }
}
