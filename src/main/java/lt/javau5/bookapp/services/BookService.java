package lt.javau5.bookapp.services;

import lt.javau5.bookapp.entities.Author;
import lt.javau5.bookapp.entities.Book;
import lt.javau5.bookapp.entities.Category;
import lt.javau5.bookapp.repositories.AuthorRepository;
import lt.javau5.bookapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public boolean seedBooks() {
        if(bookRepository.count() == 0 && authorRepository.count() == 0) {
            List<Book> books = new ArrayList<>();
//        library.add(new Book( "9786090151044", "Chemistry Lessons", new Author( "Bonnie",  "Garmus"), 2022, Category.HUMOR, 199));
//        library.add(new Book( "9786090152904", "Jonathan Strange & Mr Norrell", new Author( "Susanna", "Clarke"), 2022, Category.FANTASY, 7));
//        library.add(new Book("9780062060624", "The Song of Achilles", new Author( "Madeline",  "Miller"), 2014, Category.FANTASY, 33));

            Author author1 = new Author("Matthew", "McConaughey");
            authorRepository.save(author1);
            Author author2 = new Author( "Guillermo", "Arriaga");
            authorRepository.save(author2);
            Author author3 = new Author( "Madeline",  "Miller");
            authorRepository.save(author3);
            Author author4 = new Author( "Susanna", "Clarke");
            authorRepository.save(author4);
            Author author5 = new Author( "Hallgrimur", "Helgason");
            authorRepository.save(author5);

            books.add(new Book("9786090151235", "Green Lights", author1, 2022, Category.BIOGRAPHY, 10));
            books.add(new Book( "9786090134054", "El Salvaje", author2, 2018, Category.THRILLER, 4));
            books.add(new Book("9786094792144", "Circe", author3, 2022, Category.FANTASY, 33));
            books.add(new Book( "9786090152904", "Piranesi", author4, 2022, Category.FANTASY, 7));
            books.add(new Book( "9786090116845" ,"1000 Woman", author5, 2021, Category.NOVEL, 55));
            bookRepository.saveAll(books);
            return true;
        }
        return false;
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public void save(Book book) {
        Author author = book.getAuthor();
        System.out.println(author);
        authorRepository.save(author);
        bookRepository.save(book);
    }

    public Book getById(Long id) {
        return bookRepository.findById(id).orElse(new Book());
    }

    public void updateBook(Book book) throws BookNotFoundException {
        Book found = bookRepository.
                findById(book.getId()).
                orElseThrow(() -> new BookNotFoundException("Product not found with such id"));
        found.setISBN(book.getISBN());
        found.setName(book.getName());
        found.setAuthor(book.getAuthor());
        found.setCategory(book.getCategory());
        found.setAmount(book.getAmount());
        bookRepository.save(found);
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }

}
