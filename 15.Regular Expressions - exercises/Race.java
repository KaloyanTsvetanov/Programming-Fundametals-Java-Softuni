import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> participantsMap = new LinkedHashMap<>();
        String input = scanner.nextLine();
        int size = input.split(", ").length;
        for (int i = 0; i < size; i++) {
            String name = input.split(", ")[i];
            participantsMap.put(name, 0);
        }
        input = scanner.nextLine();

        while (!input.equals("end of race")) {

            StringBuilder currentPerson = new StringBuilder();

            int currentSum = 0;

            Pattern pattern = Pattern.compile("[A-Za-z]");
            Pattern pattern1 = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(input);
            Matcher matcher1 = pattern1.matcher(input);
            while (matcher.find()) {
                currentPerson.append(matcher.group());

            }
            while (matcher1.find()) {
                int a = Integer.parseInt(matcher1.group());
                currentSum += a;

            }
            String result = currentPerson.toString();
            if (participantsMap.containsKey(result)) {
                int currentPoints = participantsMap.get(result);
                participantsMap.put(result, currentPoints + currentSum);
            }


            input = scanner.nextLine();
        }

        List<String> firstParticipants = participantsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        System.out.println("1st place: "+firstParticipants.get(0));
        System.out.println("2nd place: "+firstParticipants.get(1));
        System.out.println("3rd place: "+firstParticipants.get(2));

    }
}
