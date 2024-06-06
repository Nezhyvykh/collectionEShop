public class Book extends Item {
    private String author;
    private String isbn;

    // Constructors, getters, and setters

    public Book() {}

    public Book(Long id, String name, Double price, String description, String author, String isbn) {
        super(id, name, price, description);
        this.author = author;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
