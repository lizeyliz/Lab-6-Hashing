import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SarahMethods {

    HashMap<Integer, List<Book>> bookMap = new HashMap<>();
    Scanner input = new Scanner(System.in);
    
    public void lookupBook() {
        //prompt user for dewey decimal number
        System.out.print("Enter the dewey decimal number of the book you want to look up: ");
        //get user input
        double dewey = input.nextInt();

        if (bookMap.containsKey(dewey)) {
            List<Book> list = bookMap.get(dewey);

            if(list.contains(dewey)) {
                System.out.println("Book found: " + list.get(dewey));
            } else {
                System.out.println("Book not found.");
            }
        }//end if
    }

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
}
