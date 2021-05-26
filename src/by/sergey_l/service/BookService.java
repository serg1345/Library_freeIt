package by.sergey_l.service;

import by.sergey_l.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    void addBook(int bookId, String bookTitle, int authorID);
    boolean emptyBookId(int bookId);
}
