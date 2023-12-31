package lt.javau5.bookapp.controllers;

import lt.javau5.bookapp.entities.Book;
import lt.javau5.bookapp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @Autowired
    BookService service;

    @GetMapping("/index")
    public String getIndexPage(Model model) {
        model.addAttribute("books", service.getAll());
        return "index";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "add-book";
    }

    @PostMapping("/add")
    public String saveBook(Book book) {
        service.save(book);
        return  "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        Book book = service.getById(id);
        model.addAttribute("book", book);
        return "edit-book";
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@PathVariable("id") Long id, Book book)  {
//        Book book = service.getById(id);
        service.save(book);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id)  {
        Book book = service.getById(id);
        service.delete(book);
        return "redirect:/index";
    }

}
