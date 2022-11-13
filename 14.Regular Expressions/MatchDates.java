import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("(\\d{2})([-.\\/])([A-Z][a-z]{2})(?:\\2)([0-9]{4})");

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            String date = matcher.group(1);
            String month = matcher.group(3);
            String year = matcher.group(4);
            System.out.printf("Day: %s, Month: %s, Year: %s%n",date,month,year);
        }

    }
}
