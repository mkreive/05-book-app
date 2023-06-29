package lt.javau5.bookapp.services;

public class AuthorNotFoundException extends Exception{

    public AuthorNotFoundException(String message) {
        super(message);
    }
}