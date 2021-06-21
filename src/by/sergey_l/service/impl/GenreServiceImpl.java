package by.sergey_l.service.impl;

import by.sergey_l.dao.GenreDao;
import by.sergey_l.dao.impl.GenreDaoImpl;
import by.sergey_l.entity.Genre;
import by.sergey_l.service.GenreService;

public class GenreServiceImpl implements GenreService {
    @Override
    public void addGenre(Genre genre) {
        GenreDao genreDao = new GenreDaoImpl();
        genreDao.addGenre(genre);
    }
}
