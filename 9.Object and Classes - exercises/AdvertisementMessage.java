import java.util.*;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] phrase = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can't live without this product."};
        String[] event = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
        Random rnd = new Random();

        while (n>0){

            int indexP = rnd.nextInt(phrase.length);
            int indexE = rnd.nextInt(event.length);
            int indexA = rnd.nextInt(authors.length);
            int indexC = rnd.nextInt(cities.length);
            System.out.println(phrase[indexP]+" "+event[indexE]+" "+authors[indexA]+" - "+cities[indexC]);


            n--;
        }

    }
}
