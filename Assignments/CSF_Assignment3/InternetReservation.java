/**
 * Name:    Mandeep Condle
 * Date:    12/22/13
 * Project: CSF_Assignment3
 */

/**
 * Internet Reservation class extends the Resevation class
 * adding support for source website, phone number and time reserved
 */
public class InternetReservation extends Reservation {
    /*  additional variables for internet reservations  */
    private String url;
    private String phoneNumber;
    private int timeReserved;

    /**
     * Constructor to handle Internet specific reservations
     * @param time
     * @param name
     * @param numOfPeople
     * @param url   URL where reservation was made, stored as a String
     * @param phoneNumber   Reserver's phone number
     * @param timeReserved  Time when reservation was made
     */
    public InternetReservation(int time, String name, int numOfPeople,
                               String url, String phoneNumber, int timeReserved,
                               int reservationType) {
        //TODO: check if this method [calling super for some parameters] is recommended
        super(time, name, numOfPeople, reservationType);
        this.url = url;
        this.phoneNumber = phoneNumber;
        this.timeReserved = timeReserved;
    }

    /**
     * Getters and setters for the extra information
     */
    public String getUrl() {
        return this.url;
    }

    protected void setWebsite(String website) {
        this.url = website;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    protected void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getTimeReserved() {
        return this.timeReserved;
    }

    protected void setTimeReserved(int timeReserved) {
        this.timeReserved = timeReserved;
    }

    /**
     * Gets the basic description from the base class and adds
     * reservation type-specific data
     * @return  Formatted description of each reservation
     */
    public String getDescription() {
        String desc = super.getDescription();
        desc += "URL..........." + this.getUrl()
              + "\nPhone#......." + this.getPhoneNumber()
              + "\nReserved at.." + this.printTime(this.getTimeReserved()) + "00 HRS"
              + "\n";
        return desc;
    }

}
