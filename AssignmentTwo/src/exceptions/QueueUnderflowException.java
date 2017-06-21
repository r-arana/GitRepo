package exceptions;

/**
 * Created by REA on 6/12/2017.
 *
 */
public class QueueUnderflowException extends RuntimeException {

    public QueueUnderflowException(){
        super();
    }

    public QueueUnderflowException(String message){
        super(message);
    }
}
