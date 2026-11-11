package org.example;

import java.util.Objects;

// @Getter
// @Setter
public class Book {
    private String name;
    private String author;
    private int publishingYear;
    private String isbn;
    private String publisher;

    public String getName() { return name; }
    public String getAuthor() { return author; }
    public int getPublishingYear() { return publishingYear; }
    public String getIsbn() { return isbn; }
    public String getPublisher() { return publisher; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publishingYear == book.publishingYear &&
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, publishingYear);
    }
}
