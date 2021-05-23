package by.sergey_l.dao;

import by.sergey_l.entity.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> getAllGenre();
    void addGenre(Genre genre);
    Genre getGenreById(int id);
}
