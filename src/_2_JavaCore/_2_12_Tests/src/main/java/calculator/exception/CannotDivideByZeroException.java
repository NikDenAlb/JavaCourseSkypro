package calculator.exception;

public class CannotDivideByZeroException extends RuntimeException {
    public CannotDivideByZeroException(String message) {
        super(message);
    }
}
