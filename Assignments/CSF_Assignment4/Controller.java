/**
 * Name:    Mandeep Condle
 * Date:    1/18/14
 * Project: CSF_Assignment4
 */

/**
 * This is the main class that handles all
 * communication between users and libraries
 */
public class Controller {

    public static void main(String[] args) {
        //Item test data
        Book book = new Book("War and Peace", "Leo Tolstoy", 5);
        Magazine mag = new Magazine("Make", 4, 7);
        Dvd dvd = new Dvd("Pulp Fiction", "Quentin Tarantino", 2);

        //Users test data
        User user1 = new User("mandy");
        User user2 = new User("ranga");

        //the library object
        Library library = new Library();


        System.out.println("\n\n***** TESTING *****");
        library.loanItem(user1, book);
        library.loanItem(user2, mag);
        library.loanItem(user2, dvd);
        library.loanItem(user1, dvd);
        library.acceptItem(user2, dvd);
        library.loanItem(user1, dvd);
        library.loanItem(user1, mag);
        library.acceptItem(user2, mag);
        library.loanItem(user1, mag);
        library.acceptItem(user1, book);
        library.loanItem(user2, book);
        user1.getCollection();
        user2.getCollection();
        System.out.println("*****   END  *****\n\n");


    }

}
