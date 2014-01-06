/**
 * Name:    Mandeep Condle
 * Date:    12/22/13
 * Project: CSF_Assignment3
 */

/**
 * Base class for In-Person reservations
 * Other reservation-type class extend this class
 *
 */
public class Reservation {
    /*  Instance variables that store basic reservation information */
    private int time;
    private String name;
    private int numOfPeople;
    private int reservationCode;

    /**
     * Constructor to handle reservation parameters
     * @param time  Time of Reservation
     * @param name  Name of Reserver
     * @param numOfPeople   Number of people in the reservation
     * @param reservationCode   1/2/3 depending on the reservation
     */
    public Reservation(int time, String name, int numOfPeople, int reservationCode) {
        this.time = time;
        this.name = name;
        this.numOfPeople = numOfPeople;
        this.reservationCode = reservationCode;
    }
    //TODO: Create a package to encapsulate all these classes
    //Error: package name <name> does not correspond to the file path

    /**
     * Setters and getters
     */
    public int getTime() {
        return this.time;
    }

    public String printTime(int time) {
        if (String.valueOf(time).length() == 2) {
            return String.valueOf(time);
        } else {
            return String.valueOf("0" + time) + "00 HRS";
        }
    }

    protected void setTime(int time) {
        this.time = time;
    }

    public String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getNumOfPeople() {
        return this.numOfPeople;
    }

    protected void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    /**
     * @return  Reservation code (int)
     */
    public int getReservationCode() {
        return this.reservationCode;
    }

    /**
     * Gets the String formatted reservation type, uses reservation code
     * @return Reservation type (String)
     */
    public String getReservationType() {
        int num = this.getReservationCode();

        if (num == 1) { return "In Person"; }
        else if (num == 2) {    return "Internet";  }
        else if (num == 3) {    return "Phone"; }
        else {  return "Error: incorrect reservation code"; }
    }

    /**
     * Gets the description of each reservation as specified
     * @return  Formatted description of each reservation
     */
    public String getDescription() {
        String desc = "Type........." + this.getReservationType()
                    + "\nName........." + this.getName()
                    + "\nTime........." + this.printTime(this.getTime())
                    + "\n#People......" + this.getNumOfPeople()
                    + "\n";
        return desc;
    }

}
