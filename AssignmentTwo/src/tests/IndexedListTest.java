package tests;

import exceptions.DuplicateElementException;
import exceptions.EmptyListException;
import model.User;
import org.junit.Test;
import structures.IndexedList;

import static org.junit.Assert.*;

/**
 * Created by REA on 6/20/2017.
 */
public class IndexedListTest {
    IndexedList<User> userList = new IndexedList<>();

    User user1 = new User("Bob", "Becker", "male", "123456789", "01/14/1990",
            "bob1", "bob1@gmail.com", "1@Bob", "7031236789", "fakepath1");
    User user2 = new User("Sue", "Burgen", "female", "123456789", "02/14/1995",
            "sue2", "sue2@gmail.com", "2@Sue", "7031236789", "fakepath2");
    User user3 = new User("George", "Donly", "male", "123456789", "03/14/1990",
            "geo3", "geo1@gmail.com", "3@Geo", "7031238900", "fakepath3");
    User user4 = new User("Bob", "Tart", "male", "987654321", "03/14/2000",
            "Bob1", "bob1@gmail.com", "1@Bob", "7031236789", "fakepath4");


    @Test
    public void add() throws Exception {
        userList.add(user4);
        try{
            userList.add(user4);
        }
        catch(DuplicateElementException e){
            System.out.println(e.getMessage());
        }

        System.out.println("New List: \n" + userList.toString());

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        System.out.println("New List: \n" + userList.toString());
    }

    @Test
    public void add1() throws Exception {
        try{
            userList.add(4, user4); // should not work
        }
        catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        System.out.println("New List: \n" + userList.toString());

        try{
            userList.add(0, user4); // should work
        }
        catch(DuplicateElementException e){
            System.out.println(e.getMessage());
        }

        System.out.println("New List: \n" + userList.toString());

        userList.add(1, user1);
        userList.add(2, user2);

        System.out.println("New List: \n" + userList.toString());

        // George should go to the front, and push everything else to the right
        //userList.add(0, user3);

        // George should go to the middle, and push everything else to the right
        userList.add(3, user3);


        System.out.println("New List: \n" + userList.toString());
    }

    @Test
    public void set() throws Exception {
        userList.set(0,user1);
        userList.add(user2);
        try{
            userList.set(234, user1);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        userList.add(user1);
        try{
            userList.set(0,user1);
        }
        catch (DuplicateElementException e){
            System.out.println(e.getMessage());
        }

        try{
            userList.set(3,user3);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        System.out.println("New List: \n" + userList.toString());
    }

    @Test
    public void remove() throws Exception {

        try{
            userList.remove(2);
        }
        catch (EmptyListException e){
            System.out.println(e.getMessage());
        }

        userList.add(user1);

        try{
            userList.remove(2);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        userList.remove(0);

        System.out.println("New List: \n" + userList.toString());

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        System.out.println("New List: \n" + userList.toString());

        userList.remove(1);

        System.out.println("New List: \n" + userList.toString());

        userList.remove(1);

        System.out.println("New List: \n" + userList.toString());

    }

    @Test
    public void contains() throws Exception {
        userList.add(user1);

        System.out.println(userList.toString());

        assertTrue(userList.contains(user1));
        assertFalse(userList.contains(user2));

    }

    @Test
    public void get() throws Exception {
        //EmptyListException, IndexOutOfBoundsException
        try{
            userList.get(0);
        }
        catch(EmptyListException e) {
            System.out.println(e.getMessage());
        }

        userList.add(user1);
        try{
            userList.get(4); // should not work
        }
        catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        System.out.println("New List: \n" + userList.toString());

        userList.add(user2);
        userList.add(user3);

        System.out.println("New List: \n" + userList.get(1).toString());
    }

    @Test
    public void getNext() throws Exception {

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        System.out.println(userList.toString());

        userList.reset(); // Must be used before getNext, or it won't know where to start

        System.out.println("getNext call: " + userList.getNext().toString());
        System.out.println("getNext call: " + userList.getNext().toString());
        System.out.println("getNext call: " + userList.getNext().toString());
    }

    @Test
    public void reset() throws Exception {
        // Reset initializes our list, so it just sets the current node to the first node in our list
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        userList.reset();
        System.out.println(userList.getNext().toString());
        userList.reset();
        System.out.println(userList.getNext().toString());
    }

    @Test
    public void indexOf() throws Exception {
        userList.add(user1);
        assertTrue(userList.indexOf(user1) == 0);
        userList.add(user2);
        assertTrue(userList.indexOf(user2) == 1);

        // Should throw -1 when an item is not on the list.
        assertTrue(userList.indexOf(user3) == -1);

    }

    @Test
    public void size() throws Exception {
        assertTrue(userList.size() == 0);
        userList.add(user1);
        assertTrue(userList.size() == 1);
        userList.add(user2);
        assertTrue(userList.size() == 2);



    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(userList.isEmpty() == true);

        userList.add(user1);
        assertTrue(userList.isEmpty() == false);

        userList.remove(0);
        assertTrue(userList.isEmpty() == true);

    }
/*
    @Test
    public void toString() throws Exception {
    }
*/
}