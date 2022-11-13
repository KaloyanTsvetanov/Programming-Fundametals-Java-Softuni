import java.util.*;

public class ExamResult {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> resulMap = new LinkedHashMap<>();
        Map<String,List<String>> submissionMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("exam finished")) {

            int sizeOfInput = input.split("-").length;

            if (sizeOfInput == 2) {
                String userToBan = input.split("-")[0];
                String command = input.split("-")[1];
                resulMap.remove(userToBan);

            } else {
                String userName = input.split("-")[0];
                String language = input.split("-")[1];
                int points = Integer.parseInt(input.split("-")[2]);
                if(resulMap.containsKey(userName)) {
                    if(points>resulMap.get(userName)) {
                        resulMap.put(userName,points);
                    }
                }else {
                    resulMap.put(userName,points);
                }
                if (!submissionMap.containsKey(language)) {
                    submissionMap.put(language, new ArrayList<>());
                    submissionMap.get(language).add(userName);
                } else {
                    submissionMap.get(language).add(userName);
                }

            }

            input = scanner.nextLine();
        }
        System.out.println("Results:");
        for (Map.Entry<String, Integer> entry : resulMap.entrySet()) {
            String name = entry.getKey();
            int result = entry.getValue();
            System.out.printf("%s | %d%n",name,result);
        }
        System.out.println("Submissions:");
        for (Map.Entry<String, List<String>> entry : submissionMap.entrySet()) {
            String name = entry.getKey();
            int submissions = entry.getValue().size();
            System.out.printf("%s - %d%n",name,submissions);
        }


    }
}
