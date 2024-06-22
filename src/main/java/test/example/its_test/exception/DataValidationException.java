package test.example.its_test.exception;

public class DataValidationException extends RuntimeException {

    public DataValidationException() {
        super();
    }

    public DataValidationException(String message) {
        super(message);
    }
}
