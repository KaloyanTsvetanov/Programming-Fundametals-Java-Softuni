import java.text.DecimalFormat;
import java.util.*;

public class Students {
    static class Student {
        String firstName;
        String secondName;
        Double grade;


        @Override
        public String toString() {
            DecimalFormat df = new DecimalFormat("0.00");
            return firstName+" "+ secondName+": "+df.format(grade);
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setSecondName(String secondName) {
            this.secondName = secondName;
        }

        public String getSecondName() {
            return secondName;
        }

        public void setGrade(Double grade) {
            this.grade = grade;
        }

        public Double getGrade() {
            return grade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> allStudents = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());


        while (n > 0) {

            String input = scanner.nextLine();

            String firstName = input.split(" ")[0];
            String secondName = input.split(" ")[1];
            Double grade = Double.parseDouble(input.split(" ")[2]);

            Student currentStudent = new Student();

            currentStudent.setFirstName(firstName);
            currentStudent.setSecondName(secondName);
            currentStudent.setGrade(grade);

            allStudents.add(currentStudent);

            n--;
        }

        allStudents.sort(Comparator.comparingDouble(Student::getGrade));
        for (int i = allStudents.size()-1; i >=0 ; i--) {
            System.out.println(allStudents.get(i));
        }
    }
}
