package com.exam.telegrambot1.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class BookEntity {

    private Long id;
    private String title;
    private AuthorEntity author;
    private PublisherEntity publisher;
    private int year;
    private String kind;

    @Override
    public String toString() {
        return "Название: " + title + '\n' +
                "Автор: " + author +'\n'+
                "Издательство: " + publisher +'\n'+
                "Год: " + year +'\n'+
                "Жанр: "  + kind + '\n'+'\n';
    }
}
