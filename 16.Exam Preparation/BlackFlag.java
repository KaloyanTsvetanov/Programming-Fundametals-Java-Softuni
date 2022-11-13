import java.util.*;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());
        double sumOfDaily = 0;
        int countDays = 0;
        while (days > 0) {
            countDays++;
            sumOfDaily += dailyPlunder;
            if (countDays%3==0){
                sumOfDaily+=(dailyPlunder*0.5);
            }
            if(countDays%5==0){
                sumOfDaily-=(sumOfDaily*0.3);
            }
            days--;
        }
        if(sumOfDaily>=expectedPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.",sumOfDaily);
        }else{
            System.out.printf("Collected only %.2f%% of the plunder.",(sumOfDaily/expectedPlunder)*100);
        }
    }
}
