/**
 * Name:    Mandeep Condle
 * Date:    1/9/14
 * Project: CSF_Assignment4
 */

import org.joda.time.DateTime;

/**
 * This abstract class defines the state and behavior for all library items
 * Specific item classes should extend this class and implement additional
 * behaviors if necessary
 */
public abstract class Item {
    String title;
    boolean loanable;
    int loanPeriod; //indicated by number of days
    String loanedTo;
    DateTime dueDate;

    public String getTitle() {
        return this.title;
    }

    public boolean getLoanable() {

        return this.loanable;
    }

    public void setLoanable(boolean loanable) {
        this.loanable = loanable;
    }

    public String getLoanedTo() {
        return this.loanedTo;
    }

    public void setLoanedTo(String userName) {
        this.loanedTo = userName;
    }

    public DateTime getDueDate() {
        return this.dueDate;
    }

    public void setDueDate() {
        dueDate = DateTime.now().plusDays(this.loanPeriod);
    }

    abstract String getDescription();

}
