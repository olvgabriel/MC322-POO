package game.error;

public class PositionOcupedException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public PositionOcupedException() {
        super();
    }

    public PositionOcupedException(String message) {
        super(message);
    }
    
    public PositionOcupedException(String message, Throwable cause) {
        super(message, cause);
    } 

    public PositionOcupedException(Throwable cause) {
        super(cause);
    }
}