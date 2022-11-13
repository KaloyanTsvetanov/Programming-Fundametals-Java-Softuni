import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        String[] array = new String[n];
        int bestSum = 0;
        int theBestSum = 0;
        int currentIndex = n;
        int thBestIndex = n;
        int bestCounter = 0;
        int startCounter = 0;
        int sum = 0;
        int index = 0;
        int whileCounter = 0;
        int bestWhileCounter = 0;
        int[] bestArray = new int[n];
        while (!input.equals("Clone them!")) {
            String noChars = input.replaceAll("!+", "");
            whileCounter++;
            sum = 0;
            index = 0;
            array = noChars.split("");
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(array[i]);
            }
            for (int i = 0; i < n; i++) {
                int j = i;
                int counter = 1;
                sum += numbers[i];
                while (j + 1 < n && numbers[i] == numbers[j + 1] && numbers[i] != 0 && numbers[j] != 0) {
                    counter++;
                    j++;
                }
                if (counter > startCounter) {
                    startCounter = counter;
                    index = i;
                    thBestIndex = index;
                } else if (counter == startCounter) {
                    if (thBestIndex > index) {
                        index = i;
                    }
                }
            }
            if (startCounter > bestCounter) {
                bestWhileCounter = whileCounter;
                bestSum = 0;
                bestCounter = startCounter;
                index = thBestIndex;
                for (int i = 0; i < n; i++) {
                    bestArray[i] = numbers[i];
                    bestSum += bestArray[i];
                }
            } else if (startCounter == bestCounter) {
                if (index < thBestIndex) {
                    bestWhileCounter = whileCounter;
                    thBestIndex = index;
                    bestSum = 0;
                    for (int i = 0; i < n; i++) {
                        bestArray[i] = numbers[i];
                        bestSum += bestArray[i];
                    }
                }
            } else if (index == thBestIndex) {
                if (sum > theBestSum) {
                    theBestSum = sum;
                    bestSum = 0;
                    bestWhileCounter = whileCounter;
                    for (int i = 0; i < n; i++) {
                        bestArray[i] = numbers[i];
                        bestSum += bestArray[i];
                    }
                }
            }
            input = scanner.nextLine();
        }
        if (bestSum == 0) {
            System.out.print("Best DNA sample 1 with sum: 0.");
            System.out.println();
        } else {
            System.out.printf("Best DNA sample %d with sum: %d.%n", bestWhileCounter, bestSum);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(bestArray[i] + " ");
        }
    }
}
