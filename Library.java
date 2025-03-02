//library of books and all related methods

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Library {

    //puts all contact nodes from the tree into the txt file
    public void writeToFile(){
        //put contact nodes from tree into array (inorder)
        Book[] bookList = inorderArray(root); //CHANGE
        try {
            FileWriter myWriter = new FileWriter("Library.txt");
            //write all contacts into file
            for (int i = 0; i < bookList.length; i++) {
                myWriter.write("Title: " + bookList[i].getTitle() + "\n" + 
                "Author: " + bookList[i].getAuthor() + "\n" + 
                "Dewey #: " + bookList[i].getDewey());
            }//end for loop
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
            String bookTtitle = null;
            String bookAuthor = null;
            String dewey = null;

            //read until end of file and get contact info
            while(reader.hasNextLine()) {
                
                //read book title
                beforeString = "Title: ";
                line = reader.nextLine();
                if (line.contains(beforeString)) {
                    String data = line.substring(line.indexOf(beforeString) + beforeString.length());
                    bookTtitle = data;
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
                Book newBook = new Book(bookTtitle, bookAuthor, Double.parseDouble(dewey));
                //DatabaseNode newNode = new DatabaseNode(idNum, firstName, lastName, address, city, state, zip, email, phNum);
                //add it to tree
                //root = addNode(root, newNode);
            }//end while loop
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occured.");
            e.printStackTrace();
        }//end try/catch
    } //end addFromFile method

    //user menu
    public void menu() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            System.out.println("1) Add a book to the library");
            System.out.println("2) Remove a book from the library");
            System.out.println("3) Display all books in the library");
            System.out.println("4) Display books in a subject area");
            System.out.println("5) Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    //add book
                    break;
                case 2:
                    //remove book
                    break;
                case 3:
                    //display all books
                    break;
                case 4:
                    //display books in a subject
                    //ask for subject area (list of all subject areas)
                    //shelf subsections?
                    //display all books in that shelf
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }//end switch statement
        }//end while loop
    }//end menu method
    
}//end class Library
