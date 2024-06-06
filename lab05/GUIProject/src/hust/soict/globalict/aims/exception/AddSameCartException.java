package hust.soict.globalict.aims.exception;

public class AddSameCartException extends Exception{
    public AddSameCartException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
