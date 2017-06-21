package interfaces;

import exceptions.DuplicateElementException;
import exceptions.EmptyListException;

/**
 * Created by REA on 6/12/2017.
 */
public interface OrderedList<E> {
    /**Throws an exception when duplicate elements are found.
     * Otherwise, adds passed element to the correct place given the order
     * of the list.
     *
     * @param element
     */
    void add (E element) throws DuplicateElementException;

    /**Removes the first occurrence of the specified element from the list.
     * Returns true if an element was removes.  Otherwise, returns false.
     * @param element
     */
    boolean remove (E element) throws EmptyListException;

    /**Searches the list to see whether or not an occurrence of the given element
     * already exists.
     *
     * @param element
     * @return  True if the list contains the given element.
     */
    boolean contains (E element) throws EmptyListException;

    /**Passed an argument, it returns an equivalent object if one exists on the list.
     * If not, returns null.
     *
     * @return  matching element, if found
     */
    E get(E element) throws EmptyListException;


    /**Returns the next element in the list and then updates the current position.
     *
     * @return  The next element in the list
     */
    E getNext();

    /**Sets the current position (the position of the next element to be processed)
     * to the first element on the list.
     *
     */
    void reset();

    /**Returns the size of our list.
     *
     * @return  size of our list
     */
    int size();

    /**Returns true if the list is empty.  Otherwise, returns false.
     *
     * @return true if the list is empty
     */
    boolean isEmpty();

    /** Returns a string representation of our list.
     *
     * @return
     */
    String toString();





}
