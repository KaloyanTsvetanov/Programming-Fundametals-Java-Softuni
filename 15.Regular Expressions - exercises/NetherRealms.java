import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> inputList = Arrays
                .stream(input.split(",\\s*"))
                .collect(Collectors.toList());
        for(String command:inputList){
            command.replaceAll(" ", "");
            int health = getHealth(command);
            double dmg = getDamage(command);
            System.out.printf("%s - %d health, %.2f damage%n", command, health, dmg);
        }

    }
    public static int getHealth(String code){
        String regex = "[^0-9*/+\\-.]";
        int health = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(code);
        while (matcher.find()){
            String word = matcher.group();
            char ch = word.charAt(0);
            health+=ch;
        }
        return health;
    }

    public static Double getDamage(String code){
        String regex = "[+-]?\\d+\\.?\\d*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(code);
        double dmg = 0;
        while (matcher.find()){
            String isNegative= matcher.group();
            if(isNegative.contains("-")){
                isNegative = isNegative.replace("-","");
                dmg-=Double.parseDouble(isNegative);
            }else {
                double x = Double.parseDouble(matcher.group());
                dmg += x;
            }
        }
        for (char ch : code.toCharArray()){
            if(ch =='*'){
                dmg*=2;
            }else if(ch=='/'){
                dmg/=2;
            }
        }
        return dmg;
    }
}
