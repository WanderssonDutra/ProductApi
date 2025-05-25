package Product.Api.exceptions;

// Created and trhowed in case the information passed do not exist in the database.
public class DataNotFound extends RuntimeException{

    public DataNotFound(String message){
        super(message);
    }
}
