/**
 * Name:    Mandeep Condle
 * Date:    1/10/14
 * Project: CSF_Assignment4
 */

/**
 * This class represents a magazine object that extends an Item class
 */
public class Magazine extends Item {
    int issueNum;

    public Magazine(String title, int issueNum, int loanPeriod) {
        this.title = title;
        this.issueNum = issueNum;
        this.loanable = true;
        this.loanPeriod = loanPeriod;
    }

    public int getIssueNum() {
        return this.issueNum;
    }

    /**
     * Item description
     * @return  String representation of the magazine
     */
    public String getDescription() {
        String desc = this.getTitle() + " issue# " + String.valueOf(this.getIssueNum());
        return desc;
    }


}
