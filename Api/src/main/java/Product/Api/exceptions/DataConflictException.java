package Product.Api.exceptions;

//Exception class created to be trhowed in case some important data that can only exist once
// is trying to be registered again.
public class DataConflictException extends RuntimeException{

    public DataConflictException(String message){
        throw new RuntimeException(message);
    }
}
