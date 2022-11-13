import java.text.DecimalFormat;
import java.util.*;

public class CompanyRoster {
    static class Employee {
        String name;
        Double salary;
        String position;
        String department;
        String email;
        Integer age;

        @Override
        public String toString() {
            DecimalFormat df = new DecimalFormat("0.00");

            return name+" "+df.format(salary)+" "+email+" "+age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public Double getSalary() {
            return salary;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getDepartment() {
            return department;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Employee> allEmployees = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        List<String> departmentList = new ArrayList<>();

        while (n>0){

            String input = scanner.nextLine();


            String name = input.split(" ")[0];
            Double salary = Double.parseDouble(input.split(" ")[1]);
            String position = input.split(" ")[2];
            String department = input.split(" ")[3];
            String email = "n/a";
            Integer age = -1;
            if(input.split(" ").length==5 || input.split(" ").length==6) {
                if(!input.contains("@")){
                    age = Integer.parseInt(input.split(" ")[4]);
                }
                else {
                    email = input.split(" ")[4];
                }
            }
            if(input.split(" ").length==6) {
                age = Integer.parseInt(input.split(" ")[5]);
            }

            Employee currentEmployee = new Employee();
            currentEmployee.setName(name);
            currentEmployee.setSalary(salary);
            currentEmployee.setPosition(position);
            currentEmployee.setDepartment(department);
            currentEmployee.setEmail(email);
            currentEmployee.setAge(age);

            departmentList.add(department);

            allEmployees.add(currentEmployee);



            n--;
        }

        double maxSalary = Double.MIN_VALUE;
        String bestDepartment = "";
        for (int i = 0; i < departmentList.size(); i++) {
            double salary = 0;
            int counter=0;

            for(int j = 0 ; j <allEmployees.size(); j++){
                if(allEmployees.get(j).getDepartment().equals(departmentList.get(i))){
                    counter++;
                    salary+=allEmployees.get(j).getSalary();
                }
            }
            double currentAverage = salary/counter;
            if(currentAverage>=maxSalary){
                maxSalary =currentAverage;
                bestDepartment=departmentList.get(i);
            }

        }
        allEmployees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        System.out.printf("Highest Average Salary: %s%n",bestDepartment);
        for(Employee best : allEmployees){
            if(best.getDepartment().equals(bestDepartment)){
                System.out.println(best);
            }
        }

    }
}
