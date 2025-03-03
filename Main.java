//test class
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Main {
    // Create a HashMap object called library
    // The key is the first digit of book's dewey #
    // and the value is the book toString method
    public static void main(String[] args) {

        //INITIALIZE HASH MAP (empty)
        //hashmaps where each spot is list
        HashMap<Integer, List<Book>> library = new HashMap<>();
        
        //add empty arraylists to each spot in library
        for (int i = 0; i < 10; i++) {
            library.put(i, new ArrayList<Book>());
        }
        //END INITIALIZE HASHMAP


        //ADD BOOK
        //traverse hashmap and place based on key
        for (Map.Entry<Integer,List<Book>> mapElement : library.entrySet()) {
            int key = mapElement.getKey();
            System.out.println(key);
        }
        //END ADD BOOK



        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 813.52);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 813.54);
        Book book3 = new Book("1984", "George Orwell", 813.54);

        //library.put(book1.getKey(), book1.toString());
        //library.put(book2.getKey(), book2.toString());
        //library.put(book3.getKey(), book3.toString());

        //addBook(book1, library);

        System.out.println(library);
    }//end main method

    //ADD BOOK: adds a book to a linked list in the hashmap
    /*public void addBook(Book book, HashMap<Integer, List<Book>> library){
        //traverse hashmap and place based on key
        for (Map.Entry<Integer,List<Book>> mapElement : library.entrySet()) {
            //int key = mapElement.getKey();
            //System.out.println(key);
            if (mapElement.getKey() == 2|| mapElement.getKey() == 7){
                System.out.println("Howdy");
            }
        }//end for loop
    }//END ADD BOOK*/
}//end class Main

