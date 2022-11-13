import java.util.*;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double food = Double.parseDouble(scanner.nextLine());
        double hay = Double.parseDouble(scanner.nextLine());
        double cover = Double.parseDouble(scanner.nextLine());
        double weight = Double.parseDouble(scanner.nextLine());
        int counter = 0;
        int days = 30;
        boolean noFood = false;
        while (days > 0 ) {
            counter++;
            food -= 0.3;
            if(counter%2==0){
                hay-=food*0.05;
            }
            if(counter%3==0){
                cover=cover-(weight*1/3);
            }
            if(food <= 0.000002 || hay<=0.000002 || cover<=0.000002){
                noFood=true;
                break;
            }
            days--;
        }
        if(noFood){
            System.out.println("Merry must go to the pet store!");
        }if(food > 0.0000002 && hay>0.0000002 && cover>0.00000002){
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",food,hay,cover);
        }
    }
}
