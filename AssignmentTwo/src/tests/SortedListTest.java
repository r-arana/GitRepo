package tests;

import exceptions.DuplicateElementException;
import exceptions.EmptyListException;
import model.User;
import org.junit.Test;
import structures.SortedList;

import static org.junit.Assert.*;

/**
 * Created by REA on 6/18/2017.
 */
public class SortedListTest {
    User user1 = new User("Bob", "Becker", "male", "123456789", "01/14/1990",
            "bob1", "bob1@gmail.com", "1@Bob", "7031236789", "fakepath1");
    User user2 = new User("Sue", "Burgen", "female", "123456789", "02/14/1995",
            "sue2", "sue2@gmail.com", "2@Sue", "7031236789", "fakepath2");
    User user3 = new User("George", "Donly", "male", "123456789", "03/14/1990",
            "geo3", "geo1@gmail.com", "3@Geo", "7031238900", "fakepath3");
    User user4 = new User("Bob", "Tart", "male", "987654321", "03/14/2000",
            "Bob1", "bob1@gmail.com", "1@Bob", "7031236789", "fakepath4");

    SortedList<User> listUser = new SortedList<>();


    @Test
    public void add() throws Exception {
        listUser.add(user4);
        try{
            listUser.add(user4);
        }
        catch(DuplicateElementException e){
            System.out.println(e.getMessage());
        }

        listUser.add(user2);
        listUser.add(user3);
        listUser.add(user1);

        System.out.print(listUser.toString());
    }

    @Test
    public void remove() throws Exception {
        try{
            listUser.remove(user1);
        }
        catch (EmptyListException e){
            System.out.println(e.getMessage());
        }

        listUser.add(user2);
        assertFalse(listUser.remove(user3));
        assertTrue(listUser.remove(user2));

        System.out.println(listUser.toString());

        listUser.add(user1);
        listUser.add(user2);
        listUser.add(user3);

        listUser.remove(user3); // should be in the middle of the list

        System.out.println(listUser.toString());
    }

    @Test
    public void contains() throws Exception {
        listUser.add(user1);

        assertTrue(listUser.contains(user1));

        listUser.remove(user1);

        assertFalse(listUser.contains(user1));

    }

    @Test
    public void get() throws Exception {
        try{
            listUser.get(user1);
        }
        catch (EmptyListException e){
            System.out.println(e.getMessage());
        }


        listUser.add(user1);
        listUser.add(user2);
        listUser.add(user3);
        listUser.add(user4);

        System.out.println(listUser.get(user2).toString());
    }

    @Test
    public void getNext() throws Exception {
        listUser.add(user1);
        listUser.add(user2);
        listUser.add(user3);
        listUser.add(user4);

        System.out.println(listUser.toString());

        listUser.reset(); // Must be used before getNext, or it won't know where to start

        System.out.println(listUser.getNext().toString());
        System.out.println(listUser.getNext().toString());

    }

    @Test
    public void reset() throws Exception {
        // Reset initializes our list, so it just sets the current node to the first node in our list
        listUser.add(user1);
        listUser.add(user2);
        listUser.add(user3);
        listUser.add(user4);

        listUser.reset();
        System.out.println(listUser.getNext().toString());
        System.out.println(listUser.getNext().toString());

    }

    @Test
    public void size() throws Exception {
        assertTrue(listUser.size() == 0);

        listUser.add(user1);

        assertTrue(listUser.size() == 1);

        listUser.add(user2);
        listUser.add(user3);
        listUser.add(user4);

        assertTrue(listUser.size() == 4);

    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(listUser.isEmpty());

        listUser.add(user1);

        assertFalse(listUser.isEmpty());

        listUser.remove(user1);

        assertTrue(listUser.isEmpty());
    }
/*
    @Test
    public void toString() throws Exception {
    }
*/
}