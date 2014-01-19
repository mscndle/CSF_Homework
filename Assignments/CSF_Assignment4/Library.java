/**
 * Name:    Mandeep Condle
 * Date:    1/9/14
 * Project: CSF_Assignment4
 */

/**
 * This class manages loan of items to users
 * Library maintains no state
 * Only methods that allow a user to loan and return items
 */
public class Library {

    /**
     * Loans items to users
     * @param userName  user object requesting a loan
     * @param item  item to be loaned
     * @return  boolean depending on the result
     */
    public boolean loanItem(User userName, Item item) {
        if (!item.getLoanable()) {
            System.out.println("Item loan for " + item.getDescription() + " declined to "
                    + userName.getUserName());
            return false;
        } else {
            item.setDueDate();
            item.setLoanable(false);
            item.setLoanedTo(userName.getUserName());
            userName.addItem(item);
            System.out.println("Item loan for " + item.getDescription() + " granted to "
                    + userName.getUserName());
            return true;
        }
    }

    /**
     * Method to handle return by a user
     * @param userName  user object returning the item
     * @param item  item object to be returned
     * @return  boolean depending on the result
     */
    public boolean acceptItem(User userName, Item item) {
        if (item.getLoanedTo().equals(userName.getUserName())) {
            item.setLoanable(true);
            item.setLoanedTo(null);
            userName.removeItem(item);
            System.out.println("Item " + item.getDescription() + " successfully returned by "
                    + userName.getUserName());
            return true;
        }
        System.out.println("user " + userName.getUserName() + " unable to return item "
                + item.getDescription());
        return false;
    }

}