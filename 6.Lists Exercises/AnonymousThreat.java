import java.util.*;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> array = Arrays
                .stream(input.split(" "))
                .collect(Collectors.toList());
        input = scanner.nextLine();
        while (!input.equals("3:1")) {
            List<String> commandList = Arrays
                    .stream(input.split(" "))
                    .collect(Collectors.toList());
            if (commandList.get(0).equals("merge")) {
                int startIndex = Integer.parseInt(commandList.get(1));
                int endIndex = Integer.parseInt(commandList.get(2));
                if (startIndex < array.size()) {
                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    if (endIndex > array.size()-1) {
                        endIndex = array.size() - 1;
                    }
                    String mergedWord = "";
                    for (int i = startIndex; i <= endIndex; i++) {
                        mergedWord += array.get(i);
                        array.remove(i);
                        endIndex--;
                        i--;
                    }
                    array.add(startIndex, mergedWord);
                }
            } else if (commandList.get(0).equals("divide")) {
                int index = Integer.parseInt(commandList.get(1));
                int parts = Integer.parseInt(commandList.get(2));
                String wordToDivide = array.get(index);
                array.remove(index);
                if(parts>wordToDivide.length()){
                    parts=wordToDivide.length();
                }
                int partLengths = wordToDivide.length() / parts;
                int lastPartLength = wordToDivide.length() - partLengths * (parts - 1);
                wordToDivide = wordToDivide.replaceAll("", " ");
                wordToDivide = wordToDivide.replaceFirst(" ", "");
                List<String> wordList = Arrays
                        .stream(wordToDivide.split(" "))
                        .collect(Collectors.toList());
                List<String> resultList = new ArrayList<>();
                while (parts > 1) {
                    int p = partLengths;
                    String mergePart = "";
                    for (int i = 0; i < p; i++) {
                        mergePart += wordList.get(i);
                        wordList.remove(i);
                        i--;
                        p--;
                    }
                    resultList.add(mergePart);
                    parts--;
                }
                if (parts == 1) {
                    String mergePart = "";
                    for (int i = 0; i < lastPartLength; i++) {
                        mergePart += wordList.get(i);
                        wordList.remove(i);
                        i--;
                        lastPartLength--;
                    }
                    resultList.add(mergePart);
                }
                Collections.reverse(resultList);
                for (int i = 0; i < resultList.size(); i++) {
                    array.add(index, resultList.get(i));
                }
            }
            input = scanner.nextLine();
        }
        for(String word : array){
            System.out.print(word+" ");
        }
    }
}
