package exceptions;

/**
 * Created by REA on 6/12/2017.
 */
public class QueueOverflowException extends RuntimeException {

    public QueueOverflowException(){
        super();
    }

    public QueueOverflowException(String message){
        super(message);
    }
}
