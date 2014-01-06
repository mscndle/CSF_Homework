/**
 * Name:    Mandeep Condle
 * Date:    12/22/13
 * Project: CSF_Assignment3
 */

//TODO: Add package
import java.awt.datatransfer.SystemFlavorMap;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class manages all reservations
 * Lets you add, delete, list all reservations
 */
public class Manager {
    /*  constants for capacity and reservation codes    */
    public static int MAX_CAPACITY = 50;
    public static int IN_PERSON_RES = 1;
    public static int INTERNET_RES = 2;
    public static int PHONE_RES = 3;
    public static int RESERVED = 10;    //10 seats always reserved for in person reservations

    /*  Hold all reservations in an arrayList   */
    private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
    //private int reservationCount = 0;
    private int peopleCount = 0;

    /**
     * setters & getters
     */
    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount += peopleCount;
    }

    public int getReservationCount() {
        return reservationList.size();
    }

    /**
     * Adds the new reservation to the reservationList
     * (USED ONLY IF listReservations() IMPLEMENTS SORTING)
     * @param res   new reservation request
     */
    public void addToReservationList(Reservation res) {
        reservationList.add(res);
    }

    /**
     * Adds a new reservation to the reservationList in a sorted position
     * (NO NEED TO SEPARATELY SORT IF THIS IS USED)
     * @param res   new reservation
     * @return      True/False if reservation was successfully added
     */
    public boolean sortedAddToReservationList(Reservation res) {
        int init_len = reservationList.size();

        if (reservationList.size() == 0) {
            reservationList.add(res);
        } else {
            int i=0;    //stores the current index of the arrayList
            for (Reservation temp: reservationList) {
                if (res.getTime() <= temp.getTime()) {
                    reservationList.add(i, res);
                    return true;
                } else {
                    i++;
                }
            }
            reservationList.add(i, res);
        }
        setPeopleCount(res.getNumOfPeople());
        if (init_len == reservationList.size()) {   //no reservation added
            return false;
        } else return true;
    }

    /**
     * CREATES A NEW IN PERSON RESERVATION
     */
    public boolean createInPersonReservation(int time, String name,
                                       int numOfPeople) {
        if (!isInputCorrect(time, numOfPeople, 1)) {
            return false;
        } else {
             if (!isDuplicateReservation(time, name)) {
                if (!willExceedMaxCapacity(time, numOfPeople, IN_PERSON_RES)) {
                    Reservation newInPersonRes = new Reservation(time, name,
                            numOfPeople, IN_PERSON_RES);

                    if (sortedAddToReservationList(newInPersonRes)) {
                        return true;
                    } else return false;
                } else {
                    System.out.println("EXCEEDS MAX CAPACITY");
                    System.out.println("NEXT AVAILABLE RESERVATION: " + nextClosestRes(time,
                            numOfPeople, IN_PERSON_RES));
                    return false;
                }
            } else {
                System.out.println("Error: Duplicate reservation");
                return false;
            }
        }
    }

    /**
     * CREATES A NEW INTERNET RESERVATION
     */
    public boolean createInternetReservation(int time, String name,
                                         int numOfPeople,
                                       String url, String phoneNumber, int timeReserved) {
        if (!isInputCorrect(time, numOfPeople, timeReserved)) {
            return false;
        } else {
            if (!isDuplicateReservation(time, name)) {
                if (!willExceedMaxCapacity(time, numOfPeople, INTERNET_RES)) {
                    InternetReservation newInternetRes = new InternetReservation(time, name,
                        numOfPeople, url, phoneNumber, timeReserved, INTERNET_RES);

                    if (sortedAddToReservationList(newInternetRes)) {
                        return true;
                    } else return false;
                } else {
                    System.out.println("EXCEEDS MAX CAPACITY");
                    System.out.println("NEXT AVAILABLE RESERVATION: " + nextClosestRes(time,
                            numOfPeople, INTERNET_RES));
                    return false;
                }
            } else {
                System.out.println("Error: Duplicate reservation");
                return false;
            }
        }
    }

    /**
     * CREATES A NEW PHONE RESERVATION
     */
    public boolean createPhoneReservation(int time, String name,
                                         int numOfPeople,
                                    int timeReserved) {
        if (!isInputCorrect(time, numOfPeople, timeReserved)) {
            return false;
        } else {
            if (!isDuplicateReservation(time, name)) {
                if (!willExceedMaxCapacity(time, numOfPeople, PHONE_RES)) {
                    PhoneReservation newPhoneRes = new PhoneReservation(time, name, numOfPeople,
                            timeReserved, PHONE_RES);

                    if (sortedAddToReservationList(newPhoneRes)) {
                        return true;
                    } else return false;
                } else {
                    System.out.println("EXCEEDS MAX CAPACITY");
                    System.out.println("NEXT AVAILABLE RESERVATION: " + nextClosestRes(time,
                            numOfPeople, PHONE_RES));
                    return false;
                }
            } else {
                System.out.println("Error: Duplicate reservation");
                return false;
            }
        }
    }

    /**
     * Deletes a reservation based on a specific name/time combination
     * @param name  Reservation holder's name
     * @param time  Time of reservation
     */
    public boolean deleteReservation(String name, int time) {
        //iterate over the list to find the reservation
        for (Reservation res: reservationList) {
            if (res.getTime() == time && res.getName().equals(name)) {
                peopleCount -= res.getNumOfPeople();
                reservationList.remove(res);
                return true;
            }
        }
        return false;
    }

    /**
     * Lists all the reservations
     * Since reservations are added using time as index, it should be sorted
     */
    public void listReservations() {
        System.out.println("*** RESERVATIONS LIST ***\n" + "Number of Reservations: "
                + this.getReservationCount() + "\n");
        for (Reservation res: reservationList) {
            System.out.println(res.getDescription());
        }
        System.out.println("*** END OF LIST ***\n");
    }

    /**
     * Checks if maximum capacity has reached for that time period
     * @param time          Requested reservation time
     * @param numOfPeople   Number of people in reservation request
     * @return              True/False depending on max capacity
     */
    private boolean willExceedMaxCapacity(int time, int numOfPeople, int resType) {
        int existingCapacity = 0;   //records #people already reserved for the current time

        //calculate existing reservations at the requested time
        for (Reservation r: reservationList) {
            if (r.getTime() == time) {
                existingCapacity += r.getNumOfPeople();
            }
        }

        if (resType == IN_PERSON_RES) {
            return (existingCapacity+numOfPeople > MAX_CAPACITY);
        } else {
            return (existingCapacity+numOfPeople > MAX_CAPACITY-RESERVED);
        }
    }

    /**
     * Checks if the new reservation is a duplicate (based on time/name)
     * @param time  Time of the new reservation
     * @param name  Reservation holder's name
     * @return
     */
    private boolean isDuplicateReservation(int time, String name) {
        for (Reservation r: reservationList) {
            if (r.getTime() == time && r.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Validates user input
     * @param time  requested reservation time
     * @param numOfPeople   number of people in the reservation
     * @param timeReserved  time when reservation was made
     * @return  true/false based on the correctness of the input
     */
    private boolean isInputCorrect(int time, int numOfPeople, int timeReserved) {
        if (time >= 24 || time < 0) {
            System.out.println("Error: Time format incorrect. Use 24hr format");
            return false;
        } else if (numOfPeople <= 0) {
            System.out.println("Error: Number of people should be a positive integer");
            return false;
        } else if (timeReserved >= 24 || timeReserved < 0) {
            System.out.println("Error: Reservation time format incorrect. Use 24hr format");
            return false;
        }
        return true;
    }

    /**
     * Returns the time of the next available recommendation
     * @param time  time of requested reservation
     * @param numOfPeople   number of people in the reservation
     * @return  string formatted time of the next available reservation
     */
    private String nextClosestRes(int time, int numOfPeople, int resType) {
        //Test reservation object created since printTime(time) is only available on reservations
        //probably not a good idea to create additional objects for such tasks
        //a better idea would be to implement a utility class
        Reservation r = new Reservation(1, "test", 1, 1);

        for (int i=1; i<(24-time); i++) {
            if (time+i <= 23 && !willExceedMaxCapacity(time+i, numOfPeople, resType)) {
                return r.printTime(time+i);
            }

            if (time-i >= 0 && !willExceedMaxCapacity(time-i, numOfPeople, resType)) {
                return r.printTime(time-i);
            }
        }
        return "No reservations available for your request";
    }


}
