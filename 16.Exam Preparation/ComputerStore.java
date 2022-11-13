import java.util.*;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double taxesSum = 0;
        double noTaxesSum = 0;
        double fullSum = 0;
        String input = scanner.nextLine();
        while (!input.equals("special") && !input.equals("regular")){
            double price = Double.parseDouble(input);
            if(price>0) {
                taxesSum += (price * 0.2);
                noTaxesSum += price;
                fullSum = (taxesSum + noTaxesSum);
            }else System.out.println("Invalid price!");

            input=scanner.nextLine();
        }
        if(input.equals("special")){
            fullSum=0.9*fullSum;
        }
        if(fullSum==0){
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n",noTaxesSum);
            System.out.printf("Taxes: %.2f$",taxesSum);
            System.out.println();
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$",fullSum);
        }
    }
}
