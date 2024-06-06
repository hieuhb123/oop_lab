package hust.soict.globalict.aims.exception;

public class PlayerException extends Exception {
    public PlayerException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}