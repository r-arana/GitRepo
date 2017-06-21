package exceptions;

/**
 * Created by REA on 6/12/2017.
 */

// Taken from the book on pages 86-87 as a way to make the code easier to understand when throwing exceptions
// You can just throw a RuntimeException if you want to, but giving it a different name through extension
// allows use to specify the issue we want to handle.
public class StackUnderflowException extends RuntimeException {

    public StackUnderflowException(){
        super();
    }

    public StackUnderflowException(String message){
        super(message);
    }

}
