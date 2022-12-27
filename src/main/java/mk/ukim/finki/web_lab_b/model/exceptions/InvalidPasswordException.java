package mk.ukim.finki.web_lab_b.model.exceptions;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException() {
        super("You must enter password");
    }
}
