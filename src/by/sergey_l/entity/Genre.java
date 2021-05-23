package by.sergey_l.entity;

public enum Genre {
    MYSTERY ("Мистика"),
    FANTASY ("Фантастика"),
    HORROR ("Ужасы"),
    NOVEL ("Роман");

    private String title;

    Genre(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
