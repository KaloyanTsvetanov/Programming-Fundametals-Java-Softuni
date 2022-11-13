import java.util.*;

public class TeamworkProjects {
    static class Team {

        String creator;

        String nameOfTeam;

        List<String> membersOfTeam;

        public int membersCount(){
            return membersOfTeam.size();
        }

        @Override
        public String toString() {
            return nameOfTeam + "\n" + "- " + creator + "\n" + members();
        }

        public String members() {
            membersOfTeam.remove(creator);
            List<String> sorted = new ArrayList<>();
            String result = "";
            for (int i = 0; i < membersOfTeam.size(); i++) {
                sorted.add(membersOfTeam.get(i));
            }
            Collections.sort(sorted);
            for (int i = 0; i < sorted.size(); i++) {
                String member = sorted.get(i);
                if (i == sorted.size() - 1) {
                    result += "-- " + member;
                } else {
                    result += "-- " + member + "\n";
                }
            }

            return result;
        }

        public void setMembersOfTeam(List<String> membersOfTeam) {
            this.membersOfTeam = membersOfTeam;
        }

        public List<String> getMembersOfTeam() {
            return membersOfTeam;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getCreator() {
            return creator;
        }

        public void setNameOfTeam(String nameOfTeam) {
            this.nameOfTeam = nameOfTeam;
        }

        public String getNameOfTeam() {
            return nameOfTeam;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Team> teamList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n > 0) {
            String input = scanner.nextLine();

            Team currentTeam = new Team();

            List<String> membersToAdd = new ArrayList<>();

            boolean thereIsName = false;
            boolean thereIsCreator = false;

            String creator = input.split("-")[0];
            String nameOfTeam = input.split("-")[1];

            membersToAdd.add(creator);

            currentTeam.setCreator(creator);
            currentTeam.setNameOfTeam(nameOfTeam);
            currentTeam.setMembersOfTeam(membersToAdd);

            for (Team name : teamList) {
                if (name.getNameOfTeam().equals(nameOfTeam)) {
                    thereIsName = true;
                }
                if (name.getCreator().equals(creator)) {
                    thereIsCreator = true;
                }
            }
            if (!thereIsCreator && !thereIsName) {
                teamList.add(currentTeam);
                System.out.printf("Team %s has been created by %s!%n", nameOfTeam, creator);
            } else if (thereIsName) {
                System.out.printf("Team %s was already created!%n", nameOfTeam);
            } else {
                System.out.printf("%s cannot create another team!%n", creator);
            }


            n--;
        }
        String input = scanner.nextLine();
        while (!input.equals("end of assignment")) {

            List<String> membersToAdd = new ArrayList<>();

            boolean doesExist = false;
            boolean betrayTeam = false;

            String user = input.split("\\-\\>")[0];
            String team = input.split("\\-\\>")[1];

            for (Team name : teamList) {
                if (name.getNameOfTeam().contains(team)) {
                    doesExist = true;
                }
                if (name.membersOfTeam.contains(user)) {
                    betrayTeam = true;
                }
            }
            if (!doesExist) {
                System.out.printf("Team %s does not exist!%n", team);
            } else if (betrayTeam) {
                System.out.printf("Member %s cannot join team %s!%n", user, team);
            } else {
                membersToAdd.add(user);
                for (Team team1 : teamList) {
                    if (team1.nameOfTeam.equals(team)) {
                        team1.membersOfTeam.add(user);
                    }
                }
            }

            input = scanner.nextLine();
        }
        teamList.sort(Comparator.comparing(Team::getNameOfTeam));
        teamList.sort(Comparator.comparingInt(Team::membersCount).reversed());
        for(Team team:teamList){
            int size = team.membersOfTeam.size();
            if(size>1) {
                System.out.println(team);
            }
        }
        System.out.println("Teams to disband:");
        for (Team team : teamList) {
            int size = team.membersOfTeam.size();
            if (size == 1 && team.membersOfTeam.contains(team.creator)) {
                System.out.println(team.getNameOfTeam());
            }
        }

    }
}
