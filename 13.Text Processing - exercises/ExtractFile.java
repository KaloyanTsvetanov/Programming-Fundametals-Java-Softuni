import java.util.*;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        String folder = path.split("\\\\")[path.split("\\\\").length-1];


        System.out.println("File name: "+folder.split("\\.")[0]);
        System.out.println("File extension: "+folder.split("\\.")[1]);

    }
}
