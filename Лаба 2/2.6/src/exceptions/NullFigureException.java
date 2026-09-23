package exceptions;

public class NullFigureException extends IllegalArgumentException {
    public NullFigureException(String msg) {
        super(msg);
    }
}
