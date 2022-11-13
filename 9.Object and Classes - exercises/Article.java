import java.util.*;
import java.util.stream.Collectors;

public class Article {
    static class Articles {
        private String title;
        private String content;
        private String author;

        public Articles(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }
        @Override
        public String toString() {
            return this.title + " - " + this.content+": "+ this.author;
        }

        public void edit(String newContent) {
            this.content = newContent;
        }

        public void changeAuthor(String newAuthor) {
            this.author = newAuthor;
        }

        public void rename(String newTitle) {
            this.title = newTitle;
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Articles> articlesList = new ArrayList<>();

        String input = scanner.nextLine();
        List<String> currentList = Arrays
                .stream(input.split(", "))
                .collect(Collectors.toList());
        Articles currentArticle = new Articles(currentList.get(0), currentList.get(1), currentList.get(2));
        int n = Integer.parseInt(scanner.nextLine());
        while (n > 0) {

            String[] commands = scanner.nextLine().split(": ");

            if (commands[0].equals("Edit")) {
                currentArticle.edit(commands[1]);
            }

            if (commands[0].equals("ChangeAuthor")) {
                currentArticle.changeAuthor(commands[1]);
            }

            if (commands[0].equals("Rename")) {
                currentArticle.rename(commands[1]);
            }
            n--;
        }
        System.out.println(currentArticle);
    }
}
