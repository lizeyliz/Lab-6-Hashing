//class for comparator
import java.util.Comparator;
public class CompareBooks implements Comparator<Book> {
    //compares books by their dewey decimal number
    @Override
    public int compare(Book a, Book b) {
        if (a.getDewey() < b.getDewey()) return -1; // The first book has a smaller dewey
        if (a.getDewey() > b.getDewey()) return 1;  // The first book has a larger dewey
        return 0; // Both books have the same dewey
    }//end compare
}//end compareBooks class
