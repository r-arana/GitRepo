package tests;

import exceptions.QueueUnderflowException;
import model.User;
import structures.BoundedQueue;

import static org.junit.Assert.*;

/**
 * Created by REA on 6/17/2017.
 */
public class BoundedQueueTest {
    BoundedQueue<User> user = new BoundedQueue<>();
    User user1 = new User("Bob", "Becker", "male", "123456789", "01/14/1990",
                            "bob1", "bob1@gmail.com", "1@Bob", "7031236789", "fakepath1");
    User user2 = new User("Sue", "Burgen", "female", "123456789", "02/14/1995",
            "sue2", "sue2@gmail.com", "2@Sue", "7031236789", "fakepath2");
    User user3 = new User("George", "Donly", "male", "123456789", "03/14/1990",
            "geo3", "geo1@gmail.com", "3@Geo", "7031238900", "fakepath3");



    @org.junit.Test
    public void enqueue() throws Exception {
        user.enqueue(user1);
        user.enqueue(user2);
        user.enqueue(user3);
        System.out.println(user.toString());

    }

    @org.junit.Test
    public void dequeue() throws Exception {

        try{
            user.dequeue();
        }
        catch(QueueUnderflowException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nBefore dequeue:");
        System.out.println("----------------");
        user.enqueue(user1);
        user.enqueue(user2);
        user.enqueue(user3);
        System.out.println(user.toString());


        user.dequeue();
        System.out.println("After dequeue:");
        System.out.println("----------------");
        System.out.println(user.toString());

    }

    @org.junit.Test
    public void isEmpty() throws Exception {
        assertTrue(user.isEmpty() == true);

        user.enqueue(user1);

        assertTrue(user.isEmpty() == false);

        user.dequeue();

        assertTrue(user.isEmpty() == true);


    }

    @org.junit.Test
    public void isFull() throws Exception {
        BoundedQueue<User> testUser = new BoundedQueue<>(3);

        assertTrue(testUser.isFull() == false);

        testUser.enqueue(user1);
        testUser.enqueue(user2);
        testUser.enqueue(user3);

        assertTrue(testUser.isFull() == true);

    }

    @org.junit.Test
    public void size() throws Exception {
        assertTrue(user.size() == 0);

        user.enqueue(user1);
        user.enqueue(user2);
        user.enqueue(user3);

        assertTrue(user.size() == 3);

        user.dequeue();

        assertTrue(user.size() == 2);
    }

/*
    @org.junit.Test
    public void toString(){
        System.out.println(user.toString());
    }
*/
}