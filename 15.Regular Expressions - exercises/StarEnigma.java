import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countMessage = Integer.parseInt(scanner.nextLine());
        String regex = "@(?<planetName>[A-Za-z]+)[^@!:>-]*:(?<population>[0-9]+)[^@!:>-]*!(?<attackType>[AD])![^@!:>-]*->(?<soldersCount>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        List<String> attackersPlanet = new ArrayList<>();
        List<String> destroyedPlanet = new ArrayList<>();

        for (int i = 1; i <= countMessage; i++) {

            String message = scanner.nextLine();
            String readableMessage = getReaMe(message);
            Matcher matcher = pattern.matcher(readableMessage);
            if (matcher.find()) {
                String planetName = matcher.group("planetName");
                int population = Integer.parseInt(matcher.group("population"));
                String attackType=matcher.group("attackType");
                int soldersCount = Integer.parseInt(matcher.group("soldersCount"));

                if(attackType.equals("A")){
                    attackersPlanet.add(planetName);
                }else if(attackType.equals("D")){
                    destroyedPlanet.add(planetName);
                }

            }


        }
        System.out.println("Attacked planets: "+ attackersPlanet.size());
        Collections.sort(attackersPlanet);
        attackersPlanet.forEach(planet-> System.out.println("-> "+planet));

        System.out.println("Destroyed planets: "+ destroyedPlanet.size());
        Collections.sort(destroyedPlanet);
        destroyedPlanet.forEach(planet-> System.out.println("-> "+planet));
    }

    public static String getReaMe(String crypto) {
        int countLetters = lettersCount(crypto);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < crypto.length(); i++) {
            char newChar = (char) ((int) crypto.charAt(i) - countLetters);
            sb.append(newChar);
        }
        return sb.toString();

    }

    private static int lettersCount(String message) {
        int count = 0;
        for (char symbol : message.toCharArray()) {
            switch (symbol) {
                case 's':
                case 't':
                case 'a':
                case 'r':
                case 'S':
                case 'T':
                case 'A':
                case 'R':
                    count++;
                    break;
            }
        }
        return count;
    }
}
