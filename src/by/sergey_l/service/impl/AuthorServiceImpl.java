package by.sergey_l.service.impl;

import by.sergey_l.dao.AuthorDao;
import by.sergey_l.dao.impl.AuthorDaoImpl;
import by.sergey_l.entity.Author;
import by.sergey_l.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    @Override
    public List<Author> getAllAuthors() {
        AuthorDao authorDao = new AuthorDaoImpl();
        return authorDao.getAllAuthors();
    }
}
