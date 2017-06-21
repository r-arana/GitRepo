package tests;

import model.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by REA on 6/18/2017.
 */
public class UserTest {
    User user1 = new User("Bob", "Becker", "male", "123456789", "01/14/1990",
            "bob1", "bob1@gmail.com", "1@Bob", "7031236789", "fakepath1");
    User user2 = new User("Sue", "Burgen", "female", "123456789", "02/14/1995",
            "sue2", "sue2@gmail.com", "2@Sue", "7031236789", "fakepath2");
    User user3 = new User("George", "Donly", "male", "123456789", "03/14/1990",
            "geo3", "geo1@gmail.com", "3@Geo", "7031238900", "fakepath3");
    User user4 = new User("Bob", "Becker", "male", "123456789", "01/14/1990",
            "Bob1", "bob1@gmail.com", "1@Bob", "7031236789", "fakepath1");


    @Test
    public void equals() throws Exception {
        assertFalse(user1.equals(user2));
        System.out.println(user1.equals(user2));

        assertTrue(user1.equals(user1));
        System.out.println(user1.equals(user1));

    }

    @Test
    public void compareTo() throws Exception {
        // bob1 should come before sue2, so it should return a negative number
        int i = user1.compareTo(user2);
        assertTrue(i < 0);
        System.out.println(user1.compareTo(user2));

        // sue2 should come after bob1, so it should return a positive number
        i = user2.compareTo(user1);
        assertTrue(i > 0);
        System.out.println(user2.compareTo(user1));

        // Should be equal, so it should return 0.
        i = user1.compareTo(user1);
        assertTrue(i == 0);
        System.out.println(user1.compareTo(user1));

        // Bob1 and bob1 should now be considered equivalent
        // This means this edge case will have to be handles elsewhere.
        i = user1.compareTo(user4);
        assertTrue(i == 0);
        System.out.println(user1.compareTo(user4));
    }

}