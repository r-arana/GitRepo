package structures;

import exceptions.DuplicateElementException;
import exceptions.EmptyListException;
import interfaces.OrderedList;
import org.junit.Test;

import java.io.Serializable;

/**
 * Created by REA on 6/18/2017.
 *
 * This class implement an unbounded ordered list using linked lists as the underlying structure.
 *
 */
public class SortedList<E extends Comparable<E>> implements OrderedList<E>, Serializable{

    Node<E> linkedListUser; // Head of our sorted list
    Node<E> currentNode = new Node<>();
    int numberOfElements = 0;


    /**
     * Throws an exception when duplicate elements are found.
     * Otherwise, adds passed element to the correct place given the order
     * of the list.
     *
     * @param element
     */
    @Override
    public void add(E element) {
        Node<E> pointer = linkedListUser; // Start at the front of our list
        Node<E> previousNode = null;
        Node<E> container;
        boolean elementNotAdded = true;
        // This will use contains and compareTo in order to work correctly.
        if (contains(element)){
            throw new DuplicateElementException("Duplicate elements are not allowed on this list.");
        }
        // Dealing with the first node added to the list.  No need to check anything.
        else if (numberOfElements == 0){
            linkedListUser = new Node<>(element, null);
            numberOfElements++;
        }
        else{
            /* Three situations need to be handled.  Placing an element at the front, placing an element
               in the middle of our linked list, and placing an element at the end of the list.
             */
            while ((pointer != null) && elementNotAdded ){
                // If our passed element is less than the current element, it will throw a negative number
                if (element.compareTo(pointer.getElement()) < 0){
                    // Place element at the front
                    if (previousNode == null){
                        container = new Node<>(element, pointer);
                        linkedListUser = container;
                        numberOfElements++;
                        elementNotAdded = false;
                    }
                    // Place node between two other nodes
                    else{
                        // Makes our new node point to the current node
                        container = new Node<>(element, previousNode.getLink());
                        // Changes the previous node so that it points at our container
                        previousNode.setLink(container);
                        numberOfElements++;
                        elementNotAdded = false;
                    }
                }
                // Handling a situation where we reach the end of our list, and our element needs to be placed
                // at the end.
                else if (pointer.getLink() == null){
                    container = new Node<>(element, null);
                    pointer.setLink(container);
                    numberOfElements++;
                    elementNotAdded = false;

                }

                // Move our previous node up by one
                previousNode = pointer;
                // Move our pointer node up by one
                pointer = pointer.getLink();
            }
        }
    }

    /**
     * Removes the first occurrence of the specified element from the list.
     * Returns true if an element was removes.  Otherwise, returns false.
     * @param element
     */
    @Override
    public boolean remove(E element) {
        Node<E> pointer = linkedListUser;
        Node<E> previousNode = null;

        if (isEmpty()){
            throw new EmptyListException("Tried to use remove on an empty list.");
        }

        while (pointer != null){

            if (pointer.getElement().equals(element) == true){
                // If we're dealing with the head node.
                if (previousNode == null){
                    linkedListUser = pointer.getLink();
                    numberOfElements--;
                }
                else{
                    // We're recreating the links so that we don't lose our list
                    previousNode.setLink(pointer.getLink());
                    numberOfElements--;
                }
                return true;
            }
            else{
                previousNode = pointer;
                pointer = pointer.getLink();
            }
        }
        return false;
    }

    /**Throws an exception if our list is empty.
     * Searches the list to see whether or not an occurrence of the given element
     * already exists.
     *
     * @param element
     * @return True if the list contains the given element.
     */
    @Override
    public boolean contains(E element) throws EmptyListException {
        // We can just iterate through the entire list until we find the element specified, or we reach the end.
        Node<E> pointer = linkedListUser;
        /*
        if (isEmpty()){
            throw new EmptyListException("Tried to use contains on an empty list.");
        }
        */
        while (pointer != null){

            if (pointer.getElement().equals(element) == true){
                return true;
            }
            else{
                pointer = pointer.getLink();
            }
        }
        return false;
    }

    /**Passed an argument, it returns an equivalent object if one exists on the list.
     * If not, returns null.
     *  Throws EmptyListException if the list is empty.
     *
     * @return matching element, if found
     */
    @Override
    public E get(E element) throws EmptyListException {
        /* This is basically the same exact thing as contains, but it returns an equivalent object if it finds one.
           I need to look into this more.  Why would you need to return a copy of something you can already pass as
           an argument?  What benefit is there to get() over contains() in a sorted list?
        */
        Node<E> pointer = linkedListUser;

        if (isEmpty()){
            throw new EmptyListException("Tried to use get on an empty list.");
        }

        while (pointer != null){

            if (pointer.getElement().equals(element) == true){
                return pointer.getElement();
            }
            else{
                pointer = pointer.getLink();
            }
        }

        return null;
    }

    /**
     * Returns the next element in the list and then updates the current position.
     *
     * @return The next element in the list
     */
    @Override
    public E getNext() {
        if (isEmpty()){
            System.out.println("The list is empty.");
            return null;
        }
        else if (currentNode == null){
            System.out.println("You're at the end of the list.");
            return null;
        }
        else{
            // Store the location of our current node before we update it, so we can return it.
            Node<E> pointer = currentNode;
            // Update the current node
            currentNode = currentNode.getLink();

            return pointer.getElement();
        }
    }

    /**Used to initialize the list, so this must be used before getNext() is used for the first time.
     * Sets the current position (the position of the next element to be processed)
     * to the first element on the list.
     */
    @Override
    public void reset() {
        currentNode = linkedListUser;
    }

    /**
     * Returns the size of our list.
     *
     * @return size of our list
     */
    @Override
    public int size() {
        return numberOfElements;
    }

    /**
     * Returns true if the list is empty.  Otherwise, returns false.
     *
     * @return true if the list is empty
     */
    @Override
    public boolean isEmpty() {
        return (numberOfElements == 0);
    }

    public String toString(){
        Node<E> pointer = linkedListUser;
        String fullString = "";

        if (isEmpty()){
            fullString = "Tried to print an empty list.";
        }
        else{
            while (pointer != null){
                fullString += pointer.getElement().toString();
                pointer = pointer.getLink();
            }
        }
        return fullString;
    }
}
