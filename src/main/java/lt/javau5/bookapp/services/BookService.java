package lt.javau5.bookapp.services;

import lt.javau5.bookapp.entities.Book;
import lt.javau5.bookapp.entities.Category;
import lt.javau5.bookapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository repository;

    public boolean seedBooks() {
        if(repository.count() == 0) {
        List<Book> library = new ArrayList<>();
        library.add(new Book("9786090151235", "Green Light", "Matthew McConaughey", 2022, Category.BIOGRAPHY, 10));
        library.add(new Book("9786090134054", "Animal", "Guillermo Arriaga", 2018, Category.THRILLER, 4));
        library.add(new Book("9786094792144", "Kirk", "Madeline Miller", 2022, Category.FANTASY, 33));
        library.add(new Book("9786090152904", "Piranesi", "Susanna Clarke", 2022, Category.FANTASY, 7));
        library.add(new Book("9786090116845" ,"1000 Woman", "Hallgrimur Helgason", 2021, Category.NOVEL, 55));
        library.add(new Book("9786090151044", "Chemistry Lessons", "Bonnie Garmus", 2022, Category.HUMOR, 199));
        repository.saveAll(library);
        return true;
        }
        return false;
    }

    public List<Book> getAll() {
        return repository.findAll();
    }

    public void save(Book book) {
        repository.save(book);
    }

    public Book getById(long id) {
        return repository.findById(id).orElse(new Book());
    }

    public void updateBook(Book book) throws BookNotFoundException {
        Book found = repository.
                findById(book.getId()).
                orElseThrow(() -> new BookNotFoundException("Product not found with id " + book.getId()));
        found.setISBN(book.getISBN());
        found.setName(book.getName());
        found.setAuthor(book.getAuthor());
        found.setCategory(book.getCategory());
        found.setAmount(book.getAmount());
        repository.save(found);
    }

    public void delete(Book book) {
        repository.delete(book);
    }

}
