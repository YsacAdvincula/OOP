import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class AuthorDA {

    private HashMap <String, Author> authorMap;

    public HashMap <String, Author> getauthorMap() {
        return authorMap;
    }
        public AuthorDA(String authorName) throws FileNotFoundException {
            Scanner scanner = new Scanner(new FileReader ("Author.csv"));
            authorMap = new HashMap<>();

                while(scanner.hasNext()){
                String [] authorData = scanner.nextLine().split(",");

                    if(authorName.equals(authorData[0].trim())) {
                    Author author = new Author();
                    author.setName(authorData[0].trim());
                    author.setBio(authorData[1].trim());
                    authorMap.put(author.getName(), author);
            } 
        }
    } 
}
