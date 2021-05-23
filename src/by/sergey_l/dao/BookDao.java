package by.sergey_l.dao;

import by.sergey_l.entity.Author;
import by.sergey_l.entity.Book;

import java.util.List;

public interface BookDao {
    void addBook(Book book);
    List<Book> getAllBooks();
    List<Book> getBooksByAuthor(Author author);
    void deleteBook(int id);
    void editBook(Book book);
}
