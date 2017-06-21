package tests;

import exceptions.StackUnderflowException;
import model.User;
import org.junit.Test;
import structures.BoundedStack;

import static org.junit.Assert.*;

/**
 * Created by REA on 6/17/2017.
 */
public class BoundedStackTest {

    BoundedStack<User> user = new BoundedStack<>(3);
    User user1 = new User("Bob", "Becker", "male", "123456789", "01/14/1990",
            "bob1", "bob1@gmail.com", "1@Bob", "7031236789", "fakepath1");
    User user2 = new User("Sue", "Burgen", "female", "123456789", "02/14/1995",
            "sue2", "sue2@gmail.com", "2@Sue", "7031236789", "fakepath2");
    User user3 = new User("George", "Donly", "male", "123456789", "03/14/1990",
            "geo3", "geo1@gmail.com", "3@Geo", "7031238900", "fakepath3");

    @Test
    public void push() throws Exception {
        user.push(user1);
        user.push(user2);
        user.push(user3);
        System.out.println(user.toString());
    }

    @Test
    public void pop() throws Exception {
        try{
            user.pop();
        }
        catch(StackUnderflowException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nBefore pop:");
        System.out.println("----------------");
        user.push(user1);
        user.push(user2);
        user.push(user3);
        System.out.println(user.toString());


        user.pop();
        System.out.println("After pop:");
        System.out.println("----------------");
        System.out.println(user.toString());
    }

    @Test
    public void top() throws Exception {
        try{
            user.top();
        }
        catch(StackUnderflowException e){
            System.out.println(e.getMessage());
        }

        user.push(user1);

        assertNotNull(user.top());

    }

    @Test
    public void isFull() throws Exception {
        assertTrue(user.isFull() == false);

        user.push(user1);
        user.push(user2);
        user.push(user3);

        assertTrue(user.isFull() == true);

    }

    @Test
    public void isEmpty() throws Exception {

        assertTrue(user.isEmpty() == true);

        user.push(user1);

        assertTrue(user.isEmpty() == false);

        user.pop();

        assertTrue(user.isEmpty() == true);
    }

    @Test
    public void size() throws Exception {
        assertTrue(user.size() == 0);

        user.push(user1);
        user.push(user2);
        user.push(user3);

        assertTrue(user.size() == 3);

        user.pop();

        assertTrue(user.size() == 2);

    }

    /*
    @Test
    public void toString() throws Exception {
    }
    */
}