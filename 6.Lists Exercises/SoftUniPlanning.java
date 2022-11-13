import java.util.*;
import java.util.stream.Collectors;

public class SoftUniPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> objectivesList = Arrays
                .stream(input.split(", "))
                .collect(Collectors.toList());
        input = scanner.nextLine();
        while (!input.equals("course start")) {
            List<String> commandList = Arrays
                    .stream(input.split(":"))
                    .collect(Collectors.toList());
            if (commandList.contains("Add")) {
                if (!objectivesList.contains(commandList.get(1))) {
                    objectivesList.add(commandList.get(1));
                }
            } else if (commandList.contains("Remove")) {
                String checkExercise = commandList.get(1) + "-Exercise";
                if (objectivesList.contains(commandList.get(1))) {
                    objectivesList.remove(commandList.get(1));
                }
                if (objectivesList.contains(checkExercise)) {
                    objectivesList.remove(checkExercise);
                }
            } else if (commandList.contains("Insert")) {
                if (!objectivesList.contains(commandList.get(1))) {
                    int index = Integer.parseInt(commandList.get(2));
                    objectivesList.add(index, commandList.get(1));
                }
            } else if (commandList.contains("Swap")) {
                String checkExercise = commandList.get(1) + "-Exercise";
                String checkSecondExercise = commandList.get(2) + "-Exercise";
                if (objectivesList.contains(commandList.get(1)) && objectivesList.contains(commandList.get(2))) {
                    int firstIndex = 0;
                    int secondIndex = 0;
                    for (int i = 0; i < objectivesList.size(); i++) {
                        if (objectivesList.get(i).equals(commandList.get(1))) {
                            firstIndex = i;
                        } else if (objectivesList.get(i).equals(commandList.get(2))) {
                            secondIndex = i;
                        }
                    }
                    Collections.swap(objectivesList, firstIndex, secondIndex);
                    if (objectivesList.contains(checkExercise)) {
                        objectivesList.remove(checkExercise);
                        objectivesList.add(secondIndex + 1, checkExercise);
                    }
                    if (objectivesList.contains(checkSecondExercise)) {
                        objectivesList.remove(checkSecondExercise);
                        objectivesList.add(firstIndex + 1, checkSecondExercise);
                    }
                }
            } else if (commandList.contains("Exercise")) {
                String addExercise = commandList.get(1) + "-Exercise";
                if (!objectivesList.contains(commandList.get(1))) {
                    objectivesList.add(commandList.get(1));
                    objectivesList.add(addExercise);
                } else if (objectivesList.contains(commandList.get(1)) && !objectivesList.contains(addExercise)) {
                    for (int i = 0; i < objectivesList.size(); i++) {
                        if (objectivesList.get(i).equals(commandList.get(1))) {
                            objectivesList.add(i + 1, addExercise);
                        }
                    }
                }
            }
//            System.out.println(objectivesList);
            input = scanner.nextLine();
        }
        for (int i = 0; i < objectivesList.size(); i++) {
            System.out.println((i + 1) + "." + objectivesList.get(i));
        }
    }
}
