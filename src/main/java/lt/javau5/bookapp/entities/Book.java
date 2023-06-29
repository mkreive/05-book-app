package lt.javau5.bookapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ISBN;
    private String name;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private int year;
    private Category category;
    private int amount;

    public Book() {
    }

    public Book(String ISBN, String name, Author author, int year, Category category, int amount) {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.year = year;
        this.category = category;
        this.amount = amount;
    }

    public String getISBN() {
        return ISBN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", category=" + category +
                ", amount=" + amount +
                '}';
    }
}
