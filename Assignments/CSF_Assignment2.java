/**
 * User: mscndle
 * Date: 12/13/13
 * Time: 12:35 AM
 */

//
//  ALGORITHM:
//  1. Assign an ArrayList containing all the names
//  2. while the ArrayList is NOT empty: generate a random number (index) and assign the val to a string
//  3. remove the member at that random index  (first member of the group)
//  4. generate another random number using the new size of the ArrayList
//  5. If there are only 2 members left after step3, then assign 3 to a group
//  6. Remove all group members from the ArrayList and repeat (back to step2)
//


import java.util.ArrayList;
import java.util.Random;

public class CSF_Assignment2 {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<String>();
        names.add(0, "Kevin");
        names.add(1, "Ernie");
        names.add(2, "Marine");
        names.add(3, "Granger");
        names.add(4, "Shirley");
        names.add(5, "Fred");
        names.add(6, "Rachel");
        names.add(7, "Mandeep");
        names.add(8, "Hunter");
        names.add(9, "TJ");
        names.add(10, "subzero"); //to test odd# of students
        //names.add(11, "scorpion");

        Random rand1 = new Random();

        int group = 1;
        while (names.size() > 0) {

            //generate group's first member
            int i = rand1.nextInt(Integer.MAX_VALUE) % names.size();
            String first = names.get(i);
            names.remove(first);

            if (names.size() == 2) {    //last group will have 3 members
                String second = names.get(0);
                String third = names.get(1);
                System.out.println("Group " + group + ": " + first + " " + second + " " + third);
                names.remove(second);
                names.remove(third);
            } else {    //generate group's 2nd member
                int j = rand1.nextInt(Integer.MAX_VALUE) % names.size();
                String second = names.get(j);
                names.remove(second);
                System.out.println("Group " + group + ": " + first + " " + second);
            }
            group++;

        }
    }
}
