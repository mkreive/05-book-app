package lt.javau5.bookapp.services;

public class BookNotFoundException extends Exception{

    public BookNotFoundException(String message) {
        super(message);
    }
}