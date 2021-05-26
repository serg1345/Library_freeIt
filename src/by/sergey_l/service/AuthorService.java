package by.sergey_l.service;

import by.sergey_l.entity.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();
    Author getAuthorsByID(int id);
}
