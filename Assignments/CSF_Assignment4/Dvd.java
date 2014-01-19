/**
 * Name:    Mandeep Condle
 * Date:    1/10/14
 * Project: CSF_Assignment4
 */

/**
 * This class represents a dvd object that extends an Item class
 */
public class Dvd extends Item {
    String director;

    public Dvd(String title, String director, int loanPeriod) {
        this.title = title;
        this.director = director;
        this.loanable = true;
        this.loanPeriod = loanPeriod;
    }

    public String getDirector() {
        return this.director;
    }

    /**
     * Item description                                            I
     * @return  String description of the dvd
     */
    public String getDescription() {
        String desc = this.getTitle() + " directed by " + this.getDirector();
        return desc;
    }
}
