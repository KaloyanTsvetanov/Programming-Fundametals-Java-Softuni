import java.util.*;

public class Judge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> studentMap = new LinkedHashMap<>();
        Map<String, LinkedHashMap<String, Integer>> examMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("no more time")) {

            boolean thereIsSuchContest = false;
            boolean thereIsStudentInThisContest = false;
            LinkedHashMap<String, Integer> helpMap = new LinkedHashMap<>();

            String username = input.split(" \\-\\> ")[0];
            String contest = input.split(" \\-\\> ")[1];
            Integer points = Integer.parseInt(input.split(" \\-\\> ")[2]);
            helpMap.put(username, points);


            for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : examMap.entrySet()) {
                String existContests = entry.getKey();
                if (existContests.equals(contest)) {
                    thereIsSuchContest = true;
                }
                if (thereIsSuchContest) {
                    for (Map.Entry<String, Integer> entry1 : examMap.get(contest).entrySet()) {
                        String nameOfStudent = entry1.getKey();
                        if (nameOfStudent.equals(username)) {
                            thereIsStudentInThisContest = true;
                        }
                    }

                }
            }
            if (!thereIsSuchContest) {
                examMap.put(contest, helpMap);
                Integer currentPoints = studentMap.get(username);
                studentMap.put(username, currentPoints + points);
            } else if (!thereIsStudentInThisContest) {
                examMap.get(contest).put(username, points);
                Integer currentPoints = studentMap.get(username);
                studentMap.put(username, currentPoints + points);
            } else {
                int currentPoint = examMap.get(contest).get(username);
                if (points > currentPoint) {
                    examMap.get(contest).put(username, points);
                    studentMap.put(username,points);
                }
            }


            input = scanner.nextLine();
        }
        LinkedHashMap<String, LinkedHashMap<String, Integer>> resultMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> helpResult = new LinkedHashMap<>();

        int maxSize = 0;
        String bestWord = "";
        while (examMap.size() != 0) {
            maxSize = 0;
            for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : examMap.entrySet()) {
                int n = entry.getValue().size();
                if (n > maxSize) {
                    maxSize = n;
                    bestWord = entry.getKey();
                    helpResult = entry.getValue();

                }
            }
            resultMap.put(bestWord, helpResult);
            examMap.remove(bestWord);
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : resultMap.entrySet()) {
            String name = entry.getKey();
            List<Integer> intList = new ArrayList<>();

            for (Map.Entry<String, Integer> entry1 : resultMap.get(name).entrySet()) {
                intList.add(entry1.getValue());
            }
            Collections.sort(intList);
            Collections.reverse(intList);

            LinkedHashMap<String, Integer> helpResult1 = new LinkedHashMap<>();
            for (int num : intList) {
                for (Map.Entry<String, Integer> mapEntry : resultMap.get(name).entrySet()) {
                    int n = mapEntry.getValue();
                    if (num == n) {
                        helpResult1.put(mapEntry.getKey(), n);
                    }
                }

            }
            resultMap.put(entry.getKey(), helpResult1);
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : resultMap.entrySet()) {
            String name = entry.getKey();
            int size = entry.getValue().size();
            System.out.printf("%s: %d participant%n", name, size);
            int counter = 1;
            for (Map.Entry<String, Integer> mapEntry : resultMap.get(name).entrySet()) {
                int points = mapEntry.getValue();
                String names = mapEntry.getKey();
                System.out.printf("%d. %s <::> %d%n", counter, names, points);
                counter++;
            }

        }
        System.out.println("Individual standing:");
        List<Integer> num = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : studentMap.entrySet()) {
            int n = entry.getValue();
            num.add(n);
        }
        Collections.sort(num);
        Collections.reverse(num);
        int cc = 1;
        for (int p : num) {
            for (Map.Entry<String, Integer> entry : studentMap.entrySet()) {
                int n = entry.getValue();
                if (n==p){
                    System.out.printf("%d. %s -> %d%n",cc,entry.getKey(),n);
                }
            }
            cc ++;
        }
    }
}
