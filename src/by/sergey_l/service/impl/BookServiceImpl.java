package by.sergey_l.service.impl;

import by.sergey_l.dao.BookDao;
import by.sergey_l.dao.impl.BookDaoImpl;
import by.sergey_l.entity.Book;
import by.sergey_l.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public List<Book> getAllBooks() {
        BookDao bookDao = new BookDaoImpl();
        return bookDao.getAllBooks();
    }
}
