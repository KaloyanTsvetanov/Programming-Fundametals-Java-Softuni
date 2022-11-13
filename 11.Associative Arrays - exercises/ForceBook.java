import java.util.*;

public class ForceBook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> forceMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Lumpawaroo")) {

            if (input.contains("->")) {
                String nameTo = input.split(" -> ")[0];
                String sideTo = input.split(" -> ")[1];
                boolean thereIsSuchPlayer = false;
                boolean thereIsSuchTeam = false;
                for (List<String> names : forceMap.values()) {
                    if (names.contains(nameTo)) {
                        thereIsSuchPlayer = true;
                        forceMap.entrySet().forEach(e -> e.getValue().remove(nameTo));
                    }
                }
                for (String side : forceMap.keySet()) {
                    if (side.contains(sideTo)) {
                        thereIsSuchTeam = true;
                    }
                }
                if (thereIsSuchPlayer && thereIsSuchTeam) {
                    forceMap.get(sideTo).add(nameTo);
                    System.out.printf("%s joins the %s side!%n", nameTo, sideTo);
                } else if (!thereIsSuchPlayer && thereIsSuchTeam) {
                    forceMap.get(sideTo).add(nameTo);
                    System.out.printf("%s joins the %s side!%n", nameTo, sideTo);
                } else if (!thereIsSuchPlayer) {
                    forceMap.put(sideTo, new ArrayList<>());
                    forceMap.get(sideTo).add(nameTo);
                    System.out.printf("%s joins the %s side!%n", nameTo, sideTo);
                } else {
                    forceMap.put(sideTo, new ArrayList<>());
                    forceMap.get(sideTo).add(nameTo);
                    System.out.printf("%s joins the %s side!%n", nameTo, sideTo);
                }

            } else {
                String sideOf = input.split(" \\| ")[0];
                String nameOf = input.split(" \\| ")[1];
                boolean thereIsSuchPlayer = false;
                boolean thereIsSuchTeam = false;
                for (List<String> names : forceMap.values()) {
                    if (names.contains(nameOf)) {
                        thereIsSuchPlayer = true;
                    }
                }
                for (String side : forceMap.keySet()) {
                    if (side.contains(sideOf)) {
                        thereIsSuchTeam = true;
                    }
                }
                if (!thereIsSuchTeam && !thereIsSuchPlayer) {
                    forceMap.put(sideOf, new ArrayList<>());
                    forceMap.get(sideOf).add(nameOf);
                } else if (thereIsSuchTeam && !thereIsSuchPlayer) {
                    forceMap.get(sideOf).add(nameOf);
                }

            }


            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : forceMap.entrySet()) {
            int size = entry.getValue().size();
            String side = entry.getKey();
            if (size > 0) {
                System.out.printf("Side: %s, Members: %d%n", side, size);
                for (int i = 0; i < size; i++) {
                    String name = entry.getValue().get(i);
                    System.out.println("! " + name);
                }
            }
        }


    }
}
