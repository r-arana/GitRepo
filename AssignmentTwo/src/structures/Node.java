package structures;

import java.io.Serializable;

/**
 * Created by REA on 6/18/2017.
 *
 * Two constructors are provided for our node.
 * The default constructor initializes both the element and link to null.
 * The second constructor accepts an object and a reference to set the variables in the node at creation.
 */
public class Node<E> implements Serializable{
    private E element;
    private Node<E> link ;

    public Node(){
        this.element = null;
        this.link = null;
    }

    public Node(E element, Node<E> link) {
        this.element = element;
        this.link = link;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getLink() {
        return link;
    }

    public void setLink(Node<E> link) {
        this.link = link;
    }
}
