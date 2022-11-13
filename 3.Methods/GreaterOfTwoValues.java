import java.util.*;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input){
            case "int":
                int a = Integer.parseInt(scanner.nextLine());
                int b = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(a,b));
                break;
            case "char":
                char a1=  scanner.nextLine().charAt(0);
                char a2=  scanner.nextLine().charAt(0);
                System.out.println(getMax(a1,a2));
                break;
            case "string":
                String s1 = scanner.nextLine();
                String s2 = scanner.nextLine();
                System.out.println(getMax(s1,s2));
                break;
        }

    }

    public static int getMax(int num, int index) {
        if (num > index) {
            return num;
        } else if (num < index) {
            return index;
        } else return num;


    }

    public static char getMax(char num, char index) {
        if (num > index) {
            return num;
        } else if (num < index) {
            return index;
        } else return num;

    }

    public static String getMax(String num, String index) {
        String result = "";
        if (num.compareTo(index)>0) {
            result=num;
        } else if (num.compareTo(index)<0) {
            result = index;
        }
        return result;
    }
}
