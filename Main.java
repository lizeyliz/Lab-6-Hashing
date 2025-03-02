//test class
import java.util.HashMap;
public class Main {
    // Create a HashMap object called library
    // The key is the first digit of book's dewey #
    // and the value is the book toString method
    public static void main(String[] args) {
        HashMap<Integer, String> library = new HashMap<>();
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 813.52);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 813.54);
        Book book3 = new Book("1984", "George Orwell", 813.54);

        library.put(book1.getKey(), book1.toString());
        library.put(book2.getKey(), book2.toString());
        library.put(book3.getKey(), book3.toString());

        System.out.println(library);
    }
}
