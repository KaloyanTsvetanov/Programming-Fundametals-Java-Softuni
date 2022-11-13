import java.util.*;

public class OrderByAge {
    static class Persons {
        String name;
        String iD;
        Integer age;

        @Override
        public String toString() {
            return name+" with ID: "+iD+" is "+age+" years old.";
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setiD(String iD) {
            this.iD = iD;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Persons> allPersons = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String name = input.split(" ")[0];
            String iD = input.split(" ")[1];
            int age = Integer.parseInt(input.split(" ")[2]);

            Persons currentPerson = new Persons();
            currentPerson.setName(name);
            currentPerson.setiD(iD);
            currentPerson.setAge(age);

            allPersons.add(currentPerson);
            input= scanner.nextLine();

        }
        allPersons.sort(Comparator.comparingInt(Persons::getAge));
        for(Persons word:allPersons){
            System.out.println(word);
        }
    }
}
