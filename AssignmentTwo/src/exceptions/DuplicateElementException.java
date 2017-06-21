package exceptions;

/**
 * Created by REA on 6/18/2017.
 */
public class DuplicateElementException extends IllegalArgumentException {

    public DuplicateElementException(){
        super();
    }

    public DuplicateElementException(String message){
        super(message);
    }


}
