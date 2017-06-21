package structures;

import exceptions.DuplicateElementException;
import exceptions.EmptyListException;

/**
 * Created by REA on 6/20/2017.
 *
 * This class implements an array based indexed list.
 */
public class IndexedList<E> implements interfaces.IndexedList<E> {

    int defaultSize = 3;
    E[] elements = (E[]) new Object[defaultSize];


    int numberOfElements = 0;
    int currentIndex = 0;

    /**
     * Throws a DuplicateElementException when the passed object matches an object
     * already in the list.
     * Otherwise, place element at the end of the list.
     *
     * @param element
     */
    @Override
    public void add(E element) throws DuplicateElementException{
        if (contains(element)){
            throw new DuplicateElementException("Tried to add a duplicate element.");
        }
        else{
            if (size() == elements.length){
                enlarge();
            }
            elements[size()] = element;
            numberOfElements++;
        }
    }

    /**
     * Throws a DuplicateElementException when the passed object matches an object
     * already in the list.
     * Throws an IndexOutOfBoundsException when an invalid index is given.
     * Otherwise, place element at the given index, and shift everything
     * to the right of the given index.
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) throws DuplicateElementException, IndexOutOfBoundsException {
        if (indexIsOutOfBounds(index)){
            throw new IndexOutOfBoundsException("Invalid index entered into add.");
        }
        else if (contains(element)){
            throw new DuplicateElementException("Tried to add a duplicate element.");
        }
        else{
            // If we've reached our limit
            if (size() == elements.length){
                enlarge();
            }
            if (index == size()){
                elements[index] = element;
                numberOfElements++;
            }
            else{
                // Shift everything to the right.
                for (int i = (size() - 1); i >= index; i--){
                    elements[i + 1] = elements[i];
                }
                elements[index] = element;
                numberOfElements++;
            }

        }

    }

    /**
     * Throws a DuplicateElementException when the passed object matches an object
     * already in the list.
     * Throws an IndexOutOfBoundsException when an invalid index is given.
     *
     * Replaces the element at the passed index with the passed element.
     * Returns true if an element was removes.  Otherwise, returns false.
     *
     * @param index
     * @param element
     * @return element that was replaced
     */
    @Override
    public E set(int index, E element) throws DuplicateElementException, IndexOutOfBoundsException {
        // I'm going to say that set can only replace existing elements.
        // This means we can't use the indexIsOutOfBounds method in this special case

        if (isEmpty()){
            System.out.println("You can't use set on an empty list.  There is nothing to replace.");
            return null;
        }
        else if ((index < 0) || (index >= size())){
            throw new IndexOutOfBoundsException("Invalid index used in set.");
        }
        else if (contains(element)){
            throw new DuplicateElementException("Tried to set a duplicate element in the list.");
        }
        else{
            E container = elements[index];
            elements[index] = element;
            return container;
        }
    }

    /**
     * Throws an EmptyListException if our list is empty.
     * Throws an IndexOutOfBoundsException when an invalid index is given.
     * Removes the element at the passed index.
     * Returns the element removed.
     *
     * @param index
     */
    @Override
    public E remove(int index) throws EmptyListException, IndexOutOfBoundsException {
        if (isEmpty()){
            throw new EmptyListException("Tried to remove from an empty list");
        }
        else if ((index < 0) || (index >= size())){
            throw new IndexOutOfBoundsException("Invalid index passed to remove.");
        }
        else{
            E container = elements[index];
            // If they choose the last element
            if (index == (size() - 1)){
                elements[index] = null;
            }
            else{
                // Pull everything to the left
                for (int i = index; i < (size() - 1); i++){
                    elements[i] = elements[i + 1];
                }
            }

            numberOfElements--;
            return container;
        }
    }

    /**
     * Searches the list to see whether or not an occurrence of the given element
     * already exists.
     * Returns true if the list contains the given element. False, otherwise.
     *
     * @param element
     * @return True if the list contains the given element. False, otherwise.
     */
    @Override
    public boolean contains(E element) {
        if (isEmpty()){
            return false;
        }
        else{
            for (int i = 0; i < size(); i++){
                if (element.equals(elements[i])){
                    currentIndex = i;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Throws an EmptyListException if the list is empty.
     * Throws an IndexOutOfBoundsException if passed an invalid index.
     * Passed an integer index, it returns the object at the specified index.
     *
     * @param index
     * @return matching element, if found
     */
    @Override
    public E get(int index) throws EmptyListException, IndexOutOfBoundsException {
        if (isEmpty()){
            throw new EmptyListException("Tried to use get on an empty list.");
        }
        else if ((index < 0) || (index >= size())){
            throw new IndexOutOfBoundsException("Invalid index passed to get.");
        }
        else{
            return elements[index];
        }
    }

    /**
     * Returns the next element in the list and then updates the current position.
     *
     * @return The next element in the list.  Null otherwise
     */
    @Override
    public E getNext() {
        E container = null;

        if (isEmpty()){
            System.out.println("Tried to getNext on an empty list.");
            return  null;
        }
        else{
            if(currentIndex < size()){
                container = elements[currentIndex];
                currentIndex++;
            }
            else{
                System.out.println("You're at the end of the list.");
            }
        }
        return container;
    }

    /**
     * Sets the current position (the position of the next element to be processed)
     * to the first element on the list.
     */
    @Override
    public void reset() {
        currentIndex = 0;
    }

    /**
     * Returns the index of the first occurrence of the passed element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param element
     * @return index of the first occurrence of the passed element
     */
    @Override
    public int indexOf(E element) {
        if(isEmpty()){
            System.out.println("Tried to use indexOf on an empty list.");
            return -1;
        }
        else if (contains(element)){
            return currentIndex;
        }
        else{
            return -1;
        }
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
     * Increases the size of our array.
     */
    void enlarge(){
        defaultSize *=  2;

        E[] biggerArray = (E[]) new Object[defaultSize];
        //System.arraycopy(elements, 0, biggerArray, elements.length - 1, elements.length);
        for (int i = 0; i < elements.length; i++){
            biggerArray[i] = elements[i];
        }
        elements = biggerArray;
    }

    /**
     * Returns true if the list is empty.  Otherwise, returns false.
     *
     * @return true if the list is empty
     */
    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    private boolean indexIsOutOfBounds(int index){
        return (index < 0) || (index > size());
    }

    /** Returns a string representation of our list.
     *
     * @return string representation of our list
     */
    public String toString(){
        String fullString = "";
        if (isEmpty()){
            fullString = "Tried to print an empty stack.";
        }
        else{
            for(int i = 0; i < size(); i++){
                fullString += elements[i].toString();
            }
        }
        return fullString;
    }
}
