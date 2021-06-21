package by.sergey_l.dao;

import by.sergey_l.entity.Author;
import java.util.List;

public interface AuthorDao {
    List<Author> getAllAuthors();
    void addAuthor(Author author);
    Author getAuthorById(int id);
}
