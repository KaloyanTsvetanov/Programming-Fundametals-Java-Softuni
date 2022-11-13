import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] bugPositions = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] field = new int[fieldSize];
        for (int i = 0; i < bugPositions.length; i++) {
            int index = bugPositions[i];
            if (index >= 0 && index < field.length) {
                field[index] = 1;
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] data = input.split(" ");
            int index = Integer.parseInt(data[0]);
            String direction = data[1];
            int flyLength = Integer.parseInt(data[2]);
            if (index < 0 || index >= field.length || field[index] != 1) {
                input = scanner.nextLine();
                continue;
            }
            field[index] = 0;
            switch (direction) {
                case "right":
                    index += flyLength;
                    while (index < fieldSize && field[index] == 1) {
                        index += flyLength;
                    }
                    if (index < fieldSize) {
                        field[index] = 1;
                    }
                    break;
                case "left":
                    index -= flyLength;
                    while (index >= 0 && field[index] == 1) {
                        index -= flyLength;
                    }
                    if (index >= 0) {
                        field[index] = 1;
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        Arrays.stream(field).forEach(value -> System.out.print(value + " "));
    }
}
