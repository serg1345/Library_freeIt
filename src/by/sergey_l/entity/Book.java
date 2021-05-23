package by.sergey_l.entity;

public class Book implements Comparable<Book>{
    private int id;
    private String title;
    private Genre genre;
    private Author author;

    public Book(int id, String title, Genre genre, Author author) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", название: " + title  +
                ", жанр: " + genre.getTitle() +
                ", автор: " + author;
    }

    @Override
    public int compareTo(Book book) {
        return title.compareTo(book.getTitle());
    }
}
