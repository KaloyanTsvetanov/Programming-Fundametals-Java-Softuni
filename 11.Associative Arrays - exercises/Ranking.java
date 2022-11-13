import java.util.*;

public class Ranking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> contestMap = new LinkedHashMap<>();
        Map<String,Map<String,Integer>> usersMap = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end of contests")) {

            String contest = input.split(":")[0];
            String passwordForTheContest = input.split(":")[1];
            contestMap.put(contest,passwordForTheContest);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("end of submissions")){

            Map<String,Integer> helpMap = new TreeMap<>(Comparator.reverseOrder());

            boolean thereIsSuchContest = false;
            boolean thePasswordIsCorrect = false;

            String contest = input.split("=>")[0];
            String password = input.split("=>")[1];
            String username = input.split("=>")[2];
            int points = Integer.parseInt(input.split("=>")[3]);

            for (Map.Entry<String, String> entry : contestMap.entrySet()) {
                if(entry.getKey().contains(contest)){
                    String checkedPassword = entry.getValue();
                    thereIsSuchContest = true;
                    if(checkedPassword.equals(password)){
                        thePasswordIsCorrect = true;
                    }

                }
            }
            if(thereIsSuchContest && thePasswordIsCorrect){
                if(!usersMap.containsKey(username)){
                    helpMap.put(contest,points);
                    usersMap.put(username,helpMap);
                }else {
                    boolean passContest = false;
                    for ( Map.Entry<String, Integer> entry : usersMap.get(username).entrySet()) {
                        if(entry.getKey().contains(contest)){
                            passContest = true;
                        }
                    }
                    if(passContest) {
                        int currentPoints = usersMap.get(username).get(contest);
                        if(points>currentPoints){
                            usersMap.get(username).put(contest,points);
                        }
                    }else {
                        usersMap.get(username).put(contest,points);
                    }

                }

            }


            input = scanner.nextLine();
        }



        int bestScore = Integer.MIN_VALUE;
        String bestUser = "";
        for (Map.Entry<String, Map<String, Integer>> entry : usersMap.entrySet()) {
            String currentUser = entry.getKey();
            int currentScore = 0;
            for ( Map.Entry<String, Integer> entry1 : usersMap.get(currentUser).entrySet()) {
                int points = entry1.getValue();
                currentScore+=points;
            }
            if (currentScore>bestScore){
                bestScore=currentScore;
                bestUser = currentUser;
            }

        }
        System.out.printf("Best candidate is %s with total %d points.%n",bestUser,bestScore);
        System.out.println("Ranking:");
        for (Map.Entry<String, Map<String, Integer>> entry : usersMap.entrySet()) {
            String currentUser = entry.getKey();
            System.out.println(currentUser);
            List<Integer> sortedList = new ArrayList<>();
            Map<String,Integer> sortedMap = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry1 : usersMap.get(currentUser).entrySet()) {
                int points = entry1.getValue();
                sortedList.add(points);
            }
            Collections.sort(sortedList);
            Collections.reverse(sortedList);
            for(int n :sortedList){
                for(Map.Entry<String,Integer> entry1 : usersMap.get(currentUser).entrySet()){
                    if(entry1.getValue().equals(n)){
                        sortedMap.put(entry1.getKey(),n);
                    }
                }
            }
            for (Map.Entry<String, Integer> integerEntry : sortedMap.entrySet()) {
                String name = integerEntry.getKey();
                int point = integerEntry.getValue();
                System.out.printf("#  %s -> %d%n",name,point);
            }


        }

    }
}
