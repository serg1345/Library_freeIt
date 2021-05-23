package by.sergey_l.dao.impl;

import by.sergey_l.dao.AuthorDao;
import by.sergey_l.dao.MySQLConnection;
import by.sergey_l.entity.Author;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorDaoImpl implements AuthorDao {
    @Override
    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection()) {
            String sql = "SELECT * FROM author;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                authors.add(new Author(id, firstName, lastName));
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return authors;
    }

    @Override
    public void addAuthor(Author author) {

    }

    @Override
    public Author getAuthorById(int id) {
        Author author = null;
        try (Connection connection = MySQLConnection.getConnection()) {
            String sql = "SELECT * FROM author WHERE id=" + id + ";";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            author = new Author(id, firstName, lastName);
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return author;
    }
}
