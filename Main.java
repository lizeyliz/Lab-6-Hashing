//test class

import java.util.Comparator;

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

        System.out.println("Print Library:");
        System.out.println(library.bookMap);
    }//end main method
}//end class Main

