/**
 * Name:    Mandeep Condle
 * Date:    12/22/13
 * Project: CSF_Assignment3
 */

/**
 * Phone reservation class that extends Reservation
 * and adds a phone number field
 */
public class PhoneReservation extends Reservation {
    /*  additional variables for Phone Reservations  */
    private int timeReserved;

    /**
     * Constructor to handle Phone Reservations
     * @param time
     * @param name
     * @param numOfPeople
     * @param timeReserved  Time when the reservation was made
     */
    public PhoneReservation(int time, String name, int numOfPeople, int timeReserved,
                            int reservationType) {
        super(time, name, numOfPeople, reservationType);
        this.timeReserved = timeReserved;
    }

    /**
     * getters and setters for extra information
     */
    public int getTimeReserved() {
        return this.timeReserved;
    }

    protected void setTimeReserved(int timeReserved) {
        this.timeReserved = timeReserved;
    }

    /**
     * Gets the basic description from the base class and adds
     * reservation type-specific data
     * @return Formatted description of each reservation
     */
    public String getDescription() {
        String desc = super.getDescription();
        desc += "Reserved at.." + this.printTime(this.getTimeReserved()) + "00 HRS"
              + "\n";
        return desc;
    }


}

