import java.util.*;

public class OpinionPoll {
    static class Person {
        String name;
        Integer age;

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name+" - "+age;
        }

        public String getName() {
            return name;
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

        List<Person> allPersons = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n > 0) {

            Person person = new Person();

            String input = scanner.nextLine();
            String name = input.split(" ")[0];
            int age = Integer.parseInt(input.split(" ")[1]);
            person.setName(name);
            person.setAge(age);

            allPersons.add(person);

            n--;
        }
        for(Person a : allPersons) {
            int age = a.getAge();
            if(age>30) {
                System.out.println(a);
            }
        }
    }
}
