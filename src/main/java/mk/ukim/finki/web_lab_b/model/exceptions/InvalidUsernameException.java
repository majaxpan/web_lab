package mk.ukim.finki.web_lab_b.model.exceptions;

public class InvalidUsernameException extends RuntimeException{

    public InvalidUsernameException() {
        super("You must enter username");
    }
}
