package structures;

import exceptions.StackOverflowException;
import exceptions.StackUnderflowException;
import org.junit.Test;

/**
 * Created by REA on 6/12/2017.
 *
 * This class implements the Stack interface to make an array based bounded stack.
 *
 * There are two constructors.  The default constructor initializes the array to 100 elements.
 * The second constructor allows you to specify the number of elements you would like to have in your array.
 */
public class BoundedStack<E> implements interfaces.Stack<E> {

    private static final int CAPACITY = 100;

    private E[] elements;
    private int topOfStack = -1;

    // Our default constructor just sets the array size to 100
    public BoundedStack(){
        elements = (E[]) new Object[CAPACITY];
    }

    // Our other constructor allows the array size to be set.
    public BoundedStack(int givenMaxSize){
        elements = (E[]) new Object[givenMaxSize];
    }


    @Override
    public void push(E element) throws StackOverflowException {
        // Throw StackOverflowException if full.  Else, place element on top of stack.
        if(isFull()){
            throw new StackOverflowException("Tried to push on a full stack.");
        }
        else{
            // We update our top index FIRST to place the element on top of the stack
            topOfStack++;
            elements[topOfStack] = element;
        }
    }

    @Override
    public void pop() throws StackUnderflowException{
        // Throw StackUnderflowException if empty.  Else, remove element on top of stack.
        if(isEmpty()){
            throw new StackUnderflowException("Tried to pop on an empty stack.");
        }
        else{
            // We have to pop first, and then reduce our topOfStack, or we'll remove the wrong element.
            elements[topOfStack] = null;
            topOfStack--;
        }
    }

    @Override
    public E top() throws StackUnderflowException{
        // Throw StackUnderflowException if empty.  Else, return element at top of stack.
        if(isEmpty()){
            throw new StackUnderflowException("Tried to use top on an empty stack.");
        }
        else{
            return elements[topOfStack];
        }
    }

    @Override
    public boolean isFull() {
        // If our index above our top index is equal to the size of our array, then we're full.
        // Adding any more elements would throw an out of bounds exception.
        // Remember that the last array index available is (elements.length - 1)
        return topOfStack + 1 == elements.length;
    }

    @Override
    public boolean isEmpty() {
        // We know the stack is empty if topOfStack is -1
        return topOfStack == -1;
    }

    @Override
    public int size() {
        // Return the number of elements in the stack.
        return topOfStack + 1;
    }

    @Override
    public String toString(){
        String fullString = "";
        if (topOfStack == -1){
            fullString = "Tried to print an empty stack.";
        }
        else{
            for(int i = topOfStack; i >= 0; i--){
                fullString += elements[i].toString();
            }
        }
        return fullString;
    }
}
