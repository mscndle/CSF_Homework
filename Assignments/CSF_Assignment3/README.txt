Mandeep Condle
mandeepcondle@gmail.com

Date of submission: Jan 05 2014

----------------------------
FILES SUBMITTED

Reservation.java
InternetReservation.java
PhoneReservation.java
Manager.java
User.java (contains the main class)
README.txt


----------------------------
ASSUMPTIONS

1. All reservations last for an hour
2. Time format is 24hr, user enters only integers
3. These input types are validated -- "time", "numOfPeople" and "timeReserved"
4. From the user's perspective, reservations are identified based on name/time combinations
5. The user will enter only integers for the reservation main menu choices
6. Reservation list is not sorted separately, instead each reservation is placed at a sorted
position based on the time


----------------------------
BONUS

1. Next Closest Recommendation
    -The system will print out the next closest possible reservation for rejected reservations
    -The system will scan available time both before and after the requested time
    -If a reservation at 0000hrs gets rejected, the system only looks for reservations ahead of
    the requested time

2. 10 seats for In person reservations
    -Users cannot create an Internet or Phone reservation with > 40 people at any time
    -This logic is also used when recommending the next closest reservation


----------------------------
KNOWN ISSUES

1. Incorrect inputs are not handled correctly on the main menu - the program terminates
   Other incorrect user inputs are handled well with exceptions


----------------------------
TESTS (These scenarios have been tested)

1. Create a reservation of each type
2. List all reservations
3. Delete a reservation that exists
4. Delete a reservation that does not exist
5. Create a duplicate reservation
6. Create multiple reservations of all types
7. Add a reservation that exceeds the capacity for that time
8. Test if the next closest recommendation is correct
9. Add an Internet reservation with > 40 people
10. Repeat above test for Phone reservation
11. Next closest recommendation taking into account the #of seats allocated for in-person res
12. Add multiple reservations in random order of time - list reservations should be sorted
13. Delete all existing reservations and add them in again
