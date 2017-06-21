package interfaces;

import exceptions.DuplicateElementException;
import exceptions.EmptyListException;

/**
 * Created by REA on 6/12/2017.
 */
public interface IndexedList<E>  {
    /**
     * Throws a DuplicateElementException when the passed object matches an object
     * already in the list.
     * Otherwise, place element at the end of the list.
     *
     * @param element
     */
    void add(E element) throws DuplicateElementException, IndexOutOfBoundsException;

    /**
     * Throws a DuplicateElementException when the passed object matches an object
     * already in the list.
     * Throws an IndexOutOfBoundsException when an invalid index is given.
     * Otherwise, place element at the given index, and shift everything
     * to the right of the given index.
     *
     * @param element
     */
    void add(int index, E element) throws DuplicateElementException, IndexOutOfBoundsException;

    /**
     * Throws a DuplicateElementException when the passed object matches an object
     * already in the list.
     * Throws an IndexOutOfBoundsException when an invalid index is given.
     *
     * Replaces the element at the passed index with the passed element.
     * Returns true if an element was removes.  Otherwise, returns false.
     *
     * @param element
     * @return element that was replaced
     */
    E set(int index, E element) throws EmptyListException, IndexOutOfBoundsException;

    /**Throws an EmptyListException if our list is empty.
     * Throws an IndexOutOfBoundsException when an invalid index is given.
     * Removes the element at the passed index.
     * Returns the element removed.
     *
     * @param index
     */
    E remove(int index) throws EmptyListException, IndexOutOfBoundsException;


    /**
     * Searches the list to see whether or not an occurrence of the given element
     * already exists.
     * Returns true if the list contains the given element. False, otherwise.
     *
     * @param element
     * @return True if the list contains the given element. False, otherwise.
     */
    boolean contains(E element);

    /**
     * Throws an EmptyListException if the list is empty.
     * Throws an IndexOutOfBoundsException if passed an invalid index.
     * Passed an integer index, it returns the object at the specified index.
     *
     * @param index
     * @return matching element, if found
     */
    E get(int index) throws EmptyListException, IndexOutOfBoundsException;

    /**
     * Returns the next element in the list and then updates the current position.
     *
     * @return The next element in the list.  Null otherwise
     */
    E getNext();

    /**
     * Sets the current position (the position of the next element to be processed)
     * to the first element on the list.
     */
    void reset();

    /**
     * Returns the index of the first occurrence of the passed element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param element
     * @return index of the first occurrence of the passed element
     */
    int indexOf(E element);

    /**
     * Returns the size of our list.
     *
     * @return size of our list
     */
    int size();

    /**
     * Returns true if the list is empty.  Otherwise, returns false.
     *
     * @return true if the list is empty
     */
    boolean isEmpty();

    /**
     * Returns a string representation of our list.
     *
     * @return
     */
    @Override
    String toString();
}
