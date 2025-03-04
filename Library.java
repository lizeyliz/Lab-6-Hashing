import java.io.*;
import java.util.*;
//library of books and all related methods
public class Library {
    //INITIALIZE HASH MAP: each spot is a list (subject area shelf)
    HashMap<Integer, List<Book>> bookMap = new HashMap<>();
    //create comparator object
    Comparator myComparator = new CompareBooks();
    
    //puts all contact nodes from the tree into the txt file
    public void writeToFile(){
        //put contact nodes from tree into array (inorder)
        try { //FIXXXXX
            FileWriter myWriter = new FileWriter("Library.txt");
            //write all contacts into file
            for (HashMap.Entry<Integer, List<Book>> entry : bookMap.entrySet()) {  
                myWriter.write("Title: " + entry.getValue()+ "\n" + 
                "Author: " + entry.getValue() + "\n" + 
                "Dewey #: " + entry.getValue());
            }
            
            myWriter.close();
            System.out.println("Succesfully written into the file.");
        } catch (IOException e) {
            System.out.println("An error has occured.");
            e.printStackTrace();
        }//end try/catch
    }//end writeToFile method
    
    //reads contact nodes from the files and adds to tree
    public void addFromFile() {
        try {
            File libraryFile = new File("Library.txt");
            Scanner reader = new Scanner(libraryFile);
            String beforeString = null;
            String line = null;

            //initialize variables to store contact info
            String bookTitle = null;
            String bookAuthor = null;
            String dewey = null;

            //read until end of file and get contact info
            while(reader.hasNextLine()) {
                
                //read book title
                beforeString = "Title: ";
                line = reader.nextLine();
                if (line.contains(beforeString)) {
                    String data = line.substring(line.indexOf(beforeString) + beforeString.length());
                    bookTitle = data;
                }//end if statement

                //read book author
                beforeString = "Author: ";
                line = reader.nextLine();
                if (line.contains(beforeString)) {
                    String data = line.substring(line.indexOf(beforeString) + beforeString.length());
                    bookAuthor = data;
                }//end if statement

                //read dewey number
                beforeString = "Dewey #: ";
                line = reader.nextLine();
                if (line.contains(beforeString)) {
                    String data = line.substring(line.indexOf(beforeString) + beforeString.length());
                    dewey = data;
                }//end if statement

                //read empty line
                if (reader.hasNextLine()) {
                    line = reader.nextLine();
                }//end if statement
                System.out.println();

                //create node to add to tree
                Book newBook = new Book(bookTitle, bookAuthor, Double.parseDouble(dewey));
            }//end while loop
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occured.");
            e.printStackTrace();
        }//end try/catch
    } //end addFromFile method

    //ADD BOOK: adds a book to a linked list in the hashmap
    public void addBook(Book book){
        int key = book.getKey();//first digit of book's dewey decimal number
        //check if library contains key
        if(bookMap.containsKey(key)){
            // Get the ArrayList associated with the key 
            List<Book> list = bookMap.get(key); 
            list.add(book); //add the book to the list at that index
            Collections.sort(list, myComparator);//sort the list
        } else { //if the book's key doesn't have an ArrayList in the map
            // If the key does not exist, create a new ArrayList, add the element, and put it in the library(map) 
            List<Book> newList = new ArrayList<>(); 
            newList.add(book); 
            bookMap.put(key, newList); 
        } //end if/else
    }//END ADD BOOK

    //adds a book to the library using 
    public Book createBook(Scanner input) {
        //ask user for book info
        System.out.println("Enter Book Ttile: ");
        String title = input.nextLine();
        System.out.println("Enter Book Author: ");
        String author = input.nextLine();
        System.out.println("Enter Dewey #: ");
        int dewey = input.nextInt();
        input.nextLine(); // Consume newline left-over

        return new Book(title, author, dewey);
    }//end createBook

    //adds book to library from user input
    public void addUserBook(Scanner input) {
        Book newBook = createBook(input); //get user input to create a new book
        addBook(newBook);
    }//end addUserBook

    //user menu
    public void menu() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            System.out.println("1) Add a book to the library");
            System.out.println("2) Remove a book from the library");
            System.out.println("3) Look up a book ");
            System.out.println("4) Display all books in the library");
            System.out.println("5) Display books in a subject area");
            System.out.println("6) Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    //add book
                    addUserBook(input);
                    break;
                case 2:
                    //remove book
                    break;
                case 3:
                    //look up book
                    break;
                case 4:
                    //display all books
                    break;
                case 5:
                    //display books in a subject
                    //ask for subject area (list of all subject areas)
                    //shelf subsections?
                    //display all books in that shelf
                    break;
                case 6:
                    //exit
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }//end switch statement
        }//end while loop
        input.close();
    }//end menu method
    
}//end class Library
