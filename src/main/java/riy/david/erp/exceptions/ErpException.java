package riy.david.erp.exceptions;

public class ErpException extends RuntimeException{
    public ErpException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public ErpException(String exMessage) {
        super(exMessage);
    }
}
