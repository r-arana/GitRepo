package exceptions;

/**
 * Created by REA on 6/12/2017.
 */

public class StackOverflowException extends RuntimeException{

    public StackOverflowException(){
        super();
    }

    public StackOverflowException(String message){
        super(message);
    }
}
