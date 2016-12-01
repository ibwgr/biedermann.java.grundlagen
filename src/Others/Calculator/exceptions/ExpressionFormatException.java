package Others.Calculator.exceptions;

/**
 * Created by dieterbiedermann on 29.10.16.
 */
public class ExpressionFormatException extends RuntimeException {
    public ExpressionFormatException(String message) {
        super(message);
    }
}
