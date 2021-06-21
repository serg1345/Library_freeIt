package by.sergey_l.service.impl;

import by.sergey_l.dao.AuthorDao;
import by.sergey_l.dao.impl.AuthorDaoImpl;
import by.sergey_l.entity.Author;
import by.sergey_l.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    private  AuthorDao authorDao = new AuthorDaoImpl();
    @Override
    public List<Author> getAllAuthors() {
        return authorDao.getAllAuthors();
    }

    @Override
    public Author getAuthorsByID(int id) {
        return authorDao.getAuthorById(id);
    }
}
