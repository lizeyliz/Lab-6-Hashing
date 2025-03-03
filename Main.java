//test class
import java.util.HashMap;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        //INITIALIZE HASH MAP: each spot is a list
        HashMap<Integer, List<Book>> subjectMap = new HashMap<>();

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 813.52);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 813.54);
        Book book3 = new Book("1984", "George Orwell", 823.912);
        Book book4 = new Book("Test book", "me", 732.12);

        library.addBook(book1, subjectMap);
        library.addBook(book2, subjectMap);
        library.addBook(book3, subjectMap);
        library.addBook(book4, subjectMap);

        System.out.println("Print Library:");
        System.out.println(subjectMap);
    }//end main method
}//end class Main

