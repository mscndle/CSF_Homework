/**
 * Name:    Mandeep Condle
 * Date:    12/22/13
 * Project: CSF_Assignment3
 */

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Contains the main class that uses the Reservation framework
 */
public class User {
    //TODO: Fix error with duplicate reservation
    //TODO: Implement bonus requirement for 10 seats for in person reservation
    //TODO: Write Junit tests

    public static void main(String[] args) {
        int selection = 0;

        System.out.println("*** RESTAURANT RESERVATION SYSTEM ***");
        System.out.println("Select from any of the options below:\n" +
                "1 -- Add new In Person Reservation\n" +
                "2 -- Add new Internet Reservation\n" +
                "3 -- Add new Phone Reservation\n" +
                "4 -- Delete existing reservation\n" +
                "5 -- View all reservations\n" +
                "6 -- Generate sample data from file\n" +
                "0 -- Leave");


        Manager manager = new Manager();    //mastermind object
        Scanner scanner = new Scanner(System.in);
        selection = scanner.nextInt();

        while (selection != 0) {
            try {
                if (selection == 1) {
                    System.out.println("In Person Reservation selected\n" + "Enter Time (24hr), " +
                            "Name, #People (space delimited)");
                    Scanner scan = new Scanner(System.in);
                    try {
                        if (manager.createInPersonReservation(
                                scan.nextInt(),
                                scan.next(),
                                scan.nextInt())) {
                            System.out.println("In Person Reservation added successfully!");
                        } else {
                            System.out.println("Reservation not added");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect input. Follow the rules");
                    }
                } else if (selection == 2) {
                    System.out.println("Internet Reservation selected\n" +
                               "Enter Time, Name, #People, URL, Phone, CurrentTime");
                    Scanner scan = new Scanner(System.in);
                    try {
                        if (manager.createInternetReservation(
                                scan.nextInt(),
                                scan.next(),
                                scan.nextInt(),
                                scan.next(),
                                scan.next(),
                                scan.nextInt())) {
                            System.out.println("Internet Reservation added successfully!");
                        } else {
                            System.out.println("Reservation not added");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect input. Follow the rules");
                    }
                } else if (selection == 3) {
                    System.out.println("Phone Reservation selected\n" +
                        "Enter Time, Name, #People, CurrentTime (space delimited)");
                    Scanner scan = new Scanner(System.in);
                    try {
                        if (manager.createPhoneReservation(
                                scan.nextInt(),
                                scan.next(),
                                scan.nextInt(),
                                scan.nextInt())) {
                            System.out.println("Phone Reservation added successfully!");
                        } else {
                            System.out.println("Reservation not added");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect input. Follow the rules");
                    }
                } else if (selection == 4) {
                    System.out.println("Delete reservation selected");
                    System.out.println("Enter name and time of reservation");
                    try {
                        if (manager.deleteReservation(
                                scanner.next(),
                                scanner.nextInt())) {
                            System.out.println("Reservation deleted successfully!");
                        } else {
                            System.out.println("Incorrect data. Nothing deleted");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect input. Follow the rules");
                    }
                } else if (selection == 5) {
                    manager.listReservations();
                } else {
                    System.out.println("invalid option");
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input format. Use space to separate inputs");
            }
            System.out.println("\nEnter another option or 0 to leave!");
            selection = scanner.nextInt();
        }
        System.out.println("Goodbye!!!");
    }


}
