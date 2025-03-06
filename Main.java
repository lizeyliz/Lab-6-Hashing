//test class
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book5 = new Book("The Odyssey", "Homer", 883.01 );
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 813.52);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 813.54);
        Book book3 = new Book("1984", "George Orwell", 823.912);
        Book book4 = new Book("The C Programming Language", " Brian W. Kernighan", 005);
        

        library.addBook(book3);
        library.addBook(book1);
        library.addBook(book5);
        library.addBook(book2);
        library.addBook(book4);

        Scanner input = new Scanner(System.in);
       //System.out.println("hi");
        //library.writeToFile();
        library.ReadFromFile();
        //library.removeBook(book1);
        //library.userRemoveBook(input);823.
        //remove book
        //Book userBook = library.getUserBook(input);
        //library.removeBook(userBook);
        //library.displayLibrary();
        //
        //library.menu();

        //library.displayShelf();
        //methods.lookupBook();
        input.close();
    }//end main method
}//end class Main

