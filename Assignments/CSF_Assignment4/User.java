/**
 * Name:    Mandeep Condle
 * Date:    1/9/14
 * Project: CSF_Assignment4
 */

import java.util.ArrayList;

/**
 * The user class will be used as the main class
 * that calls all of the Library class's methods
 */
public class User {
    private String userName;
    private ArrayList<Item> itemList;

    public User(String userName) {
        this.userName = userName;
        this.itemList = new ArrayList<Item>();
    }

    public String getUserName() {
        return this.userName;
    }

    /**
     * Adds an item to the user's collection
     * @param item  item object to be inserted
     */
    public void addItem(Item item) {
        itemList.add(item);
    }

    /**
     * Returns an item from the user's collection
     * @param item object
     * @return  boolean depending on the result
     */
    public boolean removeItem(Item item) {
        for (Item temp: this.itemList) {
            if (temp.getTitle().equals(item.getTitle())) {
                this.itemList.remove(temp);
                return true;
            }
        }
        return false;
    }

    /**
     * Prints out the user's collection details
     */
    public void getCollection() {
        System.out.println("\nCollection details for " + this.getUserName());

        for (Item temp: this.itemList) {
            System.out.println(temp.getDescription() + " due on " + temp.getDueDate());
        }
    }

}
