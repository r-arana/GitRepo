package interfaces;

import exceptions.QueueOverflowException;
import exceptions.QueueUnderflowException;

/**
 * Created by REA on 6/12/2017.
 */
public interface Queue<E> {

    /** Throws QueueOverflowException if the queue is full.
        Else, we place the element at the end of the queue.
     */
    void enqueue(E element) throws QueueOverflowException;


    /** Throws QueueUnderflowException if the queue is empty.
        Else, we remove the element at the front of the queue and return it.
     */
    E dequeue() throws QueueUnderflowException;


    /** Returns true if the queue is empty.  Otherwise, returns false. */
    boolean isEmpty();

    /** Returns true if the queue is full.  Otherwise, returns false. */
    boolean isFull();

    /** Returns the number of elements in the queue. */
    int size();
}
