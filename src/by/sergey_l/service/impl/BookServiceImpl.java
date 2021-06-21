package by.sergey_l.service.impl;

import by.sergey_l.dao.BookDao;
import by.sergey_l.dao.impl.BookDaoImpl;
import by.sergey_l.entity.Author;
import by.sergey_l.entity.Book;
import by.sergey_l.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public void addBook(int bookId, String bookTitle, int authorId) {
        if (emptyBookId(bookId)) {
            Author author = new AuthorServiceImpl().getAuthorsByID(authorId);
            if (author != null) {
                bookDao.addBook(bookId, bookTitle, authorId);
            } else {
                System.out.println("автор с ID = " + authorId + " не найден");
            }
        } else {
            System.out.println("Книга с таким ID уже существует. ");
        }
    }

    @Override
    public boolean emptyBookId(int bookId) {
        return bookDao.emptyBookId(bookId);
    }
}
