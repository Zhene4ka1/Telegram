package com.exam.telegrambot1.response;

import com.exam.telegrambot1.entity.BookEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
public class BookResponse extends BaseResponse{
    private BookEntity book;

   /* public BookResponse(BookEntity data) {
        this.data = data;
    }*/

    public BookResponse(boolean success, String message, BookEntity book) {
        super(success, message);
        this.book = book;
    }


    @Override
    public String toString() {
        return "Данные о книге: " + book;
    }
}
