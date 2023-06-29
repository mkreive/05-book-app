package lt.javau5.bookapp.controllers;

import lt.javau5.bookapp.entities.Author;
import lt.javau5.bookapp.entities.Book;
import lt.javau5.bookapp.services.AuthorNotFoundException;
import lt.javau5.bookapp.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    AuthorService service;

    @GetMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", service.getAll());
        return "authors";
    }

    @GetMapping("/author/{id}")
    public String getAuthorBooks(@PathVariable("id") Long id, Model model) throws AuthorNotFoundException {
        Author author = service.getById(id);
        List<Book> books = author.getBooks();
        model.addAttribute("books", books);
        return "author-books";
    }

//    @GetMapping("/add")
//    public String addBook(Model model) {
//        Book book = new Book();
//        model.addAttribute("book", book);
//        return "add-book";
//    }
//
//    @PostMapping("/add")
//    public String saveBook(Book book) {
//        service.save(book);
//        return  "redirect:/index";
//    }



//    @GetMapping("/delete/{id}")
//    public String deleteAuthor(@PathVariable("id") Long id) throws AuthorNotFoundException {
//        Author author = service.getById(id);
//        service.delete(author);
//        return "redirect:/authors";
//    }

}
