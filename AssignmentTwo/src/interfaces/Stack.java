package interfaces;

import exceptions.StackOverflowException;
import exceptions.StackUnderflowException;

/**
 * Created by REA on 6/12/2017.
 */
public interface Stack<E> {

    /** Throw StackOverflowException if full.  Else, place element at top of stack. */
    void push(E element) throws StackOverflowException;

    /** Throw StackUnderflowException if empty.  Else, remove element at top of stack. */
    void pop() throws StackUnderflowException;

    /** Throw StackUnderflowException if empty.  Else, return element at top of stack. */
    E top() throws StackUnderflowException;

    /** Return true if the stack is full.  Else, return false.*/
    boolean isFull();

    /** Return true if stack is empty.  Else, return false.*/
    boolean isEmpty();

    /** Return the number of elements in the stack.*/
    int size();
}
