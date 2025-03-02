//object class: template for book object
class Book {
    //instance variables
    private String title;
    private String author;
    //take number off of internet (easier) OR create method to determine
    private double dewey; //dewey decimal number of book;

    //dewey number
    // 1)first 3 digits are subject area (shelved in numerical order)
    // 2) after 3 digits decimal, show the sub-section of the subject area (shelved in numerical order)

    //constructor
    public Book(String title, String author, double dewey) {
        this.title = title;
        this.author = author;
        this.dewey = dewey;
    }

    //getters and setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public double getDewey() {
        return dewey;
    }
    public void setDewey(double dewey) {
        this.dewey = dewey;
    }
    //end getters and setters
}//end class Book
