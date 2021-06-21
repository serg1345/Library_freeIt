package by.sergey_l.entity;

import com.sun.org.apache.bcel.internal.classfile.Unknown;

public enum Genre {
    MYSTERY ("Мистика"),
    FANTASY ("Фантастика"),
    HORROR ("Ужасы"),
    NOVEL ("Роман"),
    UNKNOWN ("неизвестен");
    private String title;

    Genre(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
