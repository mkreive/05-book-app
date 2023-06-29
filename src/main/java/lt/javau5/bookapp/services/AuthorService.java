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

//    public boolean seedAuthors() {
//        if(repository.count() == 0) {
//            List<Author> authors = new ArrayList<>();
//            authors.add(new Author( "Matthew", "McConaughey"));
//            authors.add(new Author("Guillermo", "Arriaga"));
//            authors.add(new Author( "Madeline",  "Miller"));
//            authors.add(new Author( "Susanna", "Clarke"));
//            authors.add(new Author("Hallgrimur", "Helgason"));
//            authors.add(new Author("Bonnie",  "Garmus"));
//            repository.saveAll(authors);
//            return true;
//        }
//        return false;
//    }

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

