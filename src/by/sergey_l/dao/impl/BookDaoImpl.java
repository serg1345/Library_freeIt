package by.sergey_l.dao.impl;

import by.sergey_l.dao.AuthorDao;
import by.sergey_l.dao.BookDao;
import by.sergey_l.dao.GenreDao;
import by.sergey_l.dao.MySQLConnection;
import by.sergey_l.entity.Author;
import by.sergey_l.entity.Book;
import by.sergey_l.entity.Genre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public void addBook(int bookId, String bookTitle, int authorId) {
        try (Connection connection = MySQLConnection.getConnection()) {
            String sql = "INSERT INTO book (`id`, `book_name`, `author_id`) VALUES ('" + bookId + "', '" + bookTitle + "', '" + authorId + "');";
            connection.createStatement().executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        System.out.println("Книга добавлена");
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = MySQLConnection.getConnection()) {
            String sql = "SELECT * FROM book;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String bookName = resultSet.getString(2);
                int authorId = resultSet.getInt(3);
                AuthorDao authorDao = new AuthorDaoImpl();
                Author author = authorDao.getAuthorById(authorId);
                int genreId = resultSet.getInt(4);
                Genre genre;
                if (genreId == 0) {
                    genre = Genre.UNKNOWN;
                } else {
                    genre = new GenreDaoImpl().getGenreById(genreId);
                }
                books.add(new Book(id, bookName, genre, author));
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return books;
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return null;
    }

    @Override
    public void deleteBook(int id) {

    }

    @Override
    public void editBook(Book book) {

    }

    @Override
    public boolean emptyBookId(int bookId) {
        try (Connection connection = MySQLConnection.getConnection()) {
            String sql = "SELECT * FROM book WHERE id=" + bookId + ";";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.isBeforeFirst()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return false;
    }


}
