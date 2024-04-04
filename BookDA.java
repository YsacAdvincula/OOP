import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class BookDA {
    
    private HashMap <String, Book> bookMap;
    
    public BookDA () throws FileNotFoundException {
        
            Scanner scanner = new Scanner(new FileReader("Book.csv"));
            bookMap = new HashMap<>();

                while (scanner.hasNext()) {
                String[] bookData = scanner.nextLine().split(",");
                Book book = new Book();
                book.setIsbn(bookData[0].trim());
                book.setTitle(bookData[1].trim());
                book.setAuthorName(bookData[2].trim());
                AuthorDA authorDA = new AuthorDA(book.getAuthorName());
                book.setAuthorMap(authorDA.getauthorMap());
                bookMap.put(book.getIsbn(), book);   
            }
                for (Map.Entry<String, Book> entryMap : bookMap.entrySet()) {
                System.out.println(entryMap.getValue().getIsbn() + " " + entryMap.getValue().getTitle());
                for (Map.Entry<String, Author> entryMapAuthor : entryMap.getValue().getAuthorMap().entrySet()) {
                System.out.println("\t" + entryMapAuthor.getValue().getName() + " - " + entryMapAuthor.getValue().getBio());
                }
                System.out.println(); 
        }
    }
}