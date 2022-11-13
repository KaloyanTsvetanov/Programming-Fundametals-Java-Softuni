import java.util.*;

public class Courses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,List<String>> courseMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String courseName = input.split("\\:")[0];
            String studentName = input.split("\\:")[1];
            if(courseMap.containsKey(courseName)){
                courseMap.get(courseName).add(studentName);
            }else {
                List<String> currentName = new ArrayList<>();
                currentName.add(studentName);
                courseMap.put(courseName,currentName);
            }


            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : courseMap.entrySet()) {
            int size = entry.getValue().size();
            String result = entry.getKey()+" :";
            result = result.replaceAll("  ","");
            System.out.println(result+" "+size);
            for (int i = 0; i < size; i++) {
                System.out.println("--"+entry.getValue().get(i));
            }
        }


    }
}
