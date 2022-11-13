import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[] arrayOfString = scanner.nextLine().split(" ");
        while (!arrayOfString[0].equals("end")) {
            boolean isSwapped = false;
            boolean isMultiply = false;
            for (int i = 0; i < array.length; i++) {

                if(arrayOfString[0].equals("swap") &&!isSwapped){
                    int num1 = Integer.parseInt(arrayOfString[1]);
                    int num2 = Integer.parseInt(arrayOfString[2]);
                    int save = array[num1];
                    array[num1] = array[num2];
                    array[num2] = save;
                    isSwapped=true;

                } else if(arrayOfString[0].equals("multiply") && !isMultiply){
                    int num1 = Integer.parseInt(arrayOfString[1]);
                    int num2 = Integer.parseInt(arrayOfString[2]);
                    array[num1]*=array[num2];
                    isMultiply=true;

                } else if(arrayOfString[0].equals("decrease")){
                    array[i]-=1;
                }
            }
            arrayOfString = scanner.nextLine().split(" ");
        }
        for (int i = 0; i < array.length; i++) {
            if(i+1!=array.length){
                System.out.print(array[i]+", ");
            }else {
                System.out.print(array[i]);
            }
        }
    }
}
