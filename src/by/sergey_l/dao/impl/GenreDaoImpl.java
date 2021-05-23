package by.sergey_l.dao.impl;

import by.sergey_l.dao.GenreDao;
import by.sergey_l.dao.MySQLConnection;
import by.sergey_l.entity.Genre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class GenreDaoImpl implements GenreDao {

    @Override
    public List<Genre> getAllGenre() {
        return null;
    }

    @Override
    public void addGenre(Genre genre) {

    }

    @Override
    public Genre getGenreById(int id) {
        Genre genre = null;
        try (Connection connection = MySQLConnection.getConnection()) {
            String sql = "SELECT * FROM genre WHERE id=" + id + ";";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            String genreName = resultSet.getString(2);
            Genre[] genres = Genre.values();
            for (Genre elem : genres) {
               if (genreName.equals(elem.toString())) {
                    genre = elem;
               }
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return genre;
    }
}
