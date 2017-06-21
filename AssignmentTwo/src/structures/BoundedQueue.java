package structures;

import exceptions.QueueOverflowException;
import exceptions.QueueUnderflowException;
import interfaces.Queue;

/**
 * Created by REA on 6/12/2017.
 *
 *  This class implements a bounded queue using a circular array.
 *
 *  There are two constructors.  Our default constructor initializes the array's size to 100 elements.
 *  The second constructor accepts an integer to set the size of the array.
 */

public class BoundedQueue<E> implements Queue<E> {

    // Going to try to make a circular array.  You use modulo to make it loop around
    // as long as the array is not full.

    private final static int CAPACITY = 100;

    private E[] elements;

    private int numberOfElements = 0;
    private int front = 0;
    private int back = -1; // The book uses the last element of the array, but this does the same thing.

    public BoundedQueue(){
        elements = (E[]) new Object[CAPACITY];
    }

    public BoundedQueue(int givenMaxSize){
        elements = (E[]) new Object[givenMaxSize];
    }

    /**
     * Throws QueueOverflowException if the queue is full.
     * Else, we place the element at the end of the queue.
     *
     * @param element
     */
    @Override
    public void enqueue(E element) throws QueueOverflowException {
        if(isFull()){
            throw new QueueOverflowException("Tried to enqueue a full queue.");
        }
        else{
            back = (back + 1) % elements.length;
            elements[back] = element;
            numberOfElements++;
        }
    }

    /**
     * Throws QueueUnderflowException if the queue is empty.
     * Else, we remove the element at the front of the queue and return it.
     *
     */
    @Override
    public E dequeue() throws QueueUnderflowException{

        if(isEmpty()){
            throw new QueueUnderflowException("Tried to dequeue an empty queue.");
        }
        else {
            /* When we dequeue we need to store the element at the front so we can return it at the end.
               Then we need to make the element at the front null and increment our front variable once.
               We use modulo to make sure we're incrementing front correctly, or it'll mess up when we
               reach the end of the array.
            */
            E container = elements[front];
            elements[front] = null;
            /* If we have an array of length 10, and front is starting at 9, we get
            (front + 1) = 10 and elements.length = 10, or 10 % 10 = 0.That's exactly how we want it to work.
            */
            front = (front + 1) % elements.length;
            numberOfElements--;

            return container;
        }
    }

    /**
     * Returns true if the queue is empty.  Otherwise, returns false.
     */
    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    /**
     * Returns true if the queue is full.  Otherwise, returns false.
     */
    @Override
    public boolean isFull() {
        return numberOfElements == elements.length;
    }

    /**
     * Returns the number of elements in the queue.
     */
    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public String toString(){
        String fullString = "";

        if (numberOfElements == 0){
            return "You tried to print an empty queue.";
        }
        // Front and rear will be pointing to the same element if we only have one element.
        else if(numberOfElements == 1){
            fullString = elements[front].toString();
        }
        else{
            if (front < back){
                for(int i = front; i <= back; i++){
                    fullString += elements[i].toString();
                }
            }
            else{
                //if rear < front
                for(int i = front; i < elements.length; i++){
                    fullString += elements[i].toString();
                }
                for(int i = 0; i <= back; i++){
                    fullString += elements[i].toString();
                }
            }
        }
        return fullString;
    }
}
