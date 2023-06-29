package lt.javau5.bookapp.services;

import lt.javau5.bookapp.entities.Author;
import lt.javau5.bookapp.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository repository;

    public List<Author> getAll() {
        return repository.findAll();
    }

    public void save(Author author) {
        repository.save(author);
    }

    public Author getById(Long id) {
        return repository.findById(id).orElse(new Author());
    }

    public void updateAuthor(Author author) throws AuthorNotFoundException {
        Author found = repository.
                findById(author.getId()).
                orElseThrow(() -> new AuthorNotFoundException("Author not found with such id" ));
        found.setFirstName(author.getFirstName());
        found.setLastName(author.getLastName());
        found.setBooks(author.getBooks());
        repository.save(found);
    }

    public void delete(Author author) {
        repository.delete(author);
    }

}

