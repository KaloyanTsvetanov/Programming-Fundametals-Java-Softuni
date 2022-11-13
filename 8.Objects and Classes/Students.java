import java.util.*;

public class Students {
    static class Student {
        String firstName;
        String lastName;
        Integer age;
        String homeTown;

        public Student(String firstName, String lastName, Integer age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getHomeTown() {
            return homeTown;
        }

        public void setHomeTown(String homeTown) {
            this.homeTown = homeTown;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            boolean equals = false;
            String[] student = input.split(" ");
            String name = student[0];
            String lastName = student[1];
            int age = Integer.parseInt(student[2]);
            String town = student[3];

            Student currentStudent = new Student(name, lastName, age, town);
            if (studentList.size() != 0) {
                for (int i = 0; i < studentList.size(); i++) {
                    String checkName = studentList.get(i).getFirstName();
                    String checkLastName = studentList.get(i).getLastName();
                    if (checkName.equals(name) && checkLastName.equals(lastName)) {
                        equals = true;
                        studentList.get(i).setAge(age);
                        studentList.get(i).setHomeTown(town);
                    }
                }
                if(!equals){
                    studentList.add(currentStudent);
                }
            } else {
                studentList.add(currentStudent);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        for (Student townName : studentList) {
            String city = townName.getHomeTown();
            if (input.equals(city)) {
                System.out.printf("%s %s is %d years old%n", townName.getFirstName(), townName.getLastName(), townName.getAge());
            }
        }

    }
}
