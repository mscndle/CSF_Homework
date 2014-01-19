/**
 * Name:    Mandeep Condle
 * Date:    1/9/14
 * Project: CSF_Assignment4
 */

/**
 * This class represents a book object that extends an Item class
 */
public class Book extends Item {
    String author;

    public Book(String title, String author, int loanPeriod) {
        this.title = title;
        this.author = author;
        this.loanable = true;
        this.loanPeriod = loanPeriod;
    }

    public String getAuthor() {
        return this.author;
    }

    /**
     * Item description                                            I
     * @return  String description of the book
     */
    public String getDescription() {
        String desc = this.getTitle() + " written by " + this.getAuthor();
        return desc;
    }
}
