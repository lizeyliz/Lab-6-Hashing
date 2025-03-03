//test class
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Main {
    // Create a HashMap object called library
    // The key is the first digit of book's dewey #
    // and the value is the book toString method
    public static void main(String[] args) {

        //INITIALIZE HASH MAP (empty)
        //hashmaps where each spot is list
        HashMap<Integer, List<Book>> library = new HashMap<>();
        //END INITIALIZE HASHMAP



        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 813.52);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 813.54);
        Book book3 = new Book("1984", "George Orwell", 823.912);
        Book book4 = new Book("Test book", "me", 732.12);

        addBook(book1, library);
        addBook(book2, library);
        addBook(book3, library);
        addBook(book4, library);

        //addBook(book1, library);
        System.out.println("Print Library:");
        System.out.println(library);
    }//end main method

    //ADD BOOK: adds a book to a linked list in the hashmap
    public static void addBook(Book book, HashMap<Integer, List<Book>> library){
        int key = book.getKey();
        //check if library contains key
        if(library.containsKey(key)){
            // Get the ArrayList associated with the key 
            List<Book> list = library.get(key); 
            // Add the book's string value to the ArrayList 
            list.add(book); 
        } else { //if the book's key doesn't have an ArrayList in the map
            // If the key does not exist, create a new ArrayList, add the element, and put it in the library(map) 
            List<Book> newList = new ArrayList<>(); 
            newList.add(book); 
            library.put(key, newList); 
        } //end if/else
    }//END ADD BOOK
}//end class Main

