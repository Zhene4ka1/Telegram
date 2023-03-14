package com.exam.telegrambot1.response;

import com.exam.telegrambot1.entity.BookEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BookListResponse extends BaseResponse {

    public BookListResponse(Iterable<BookEntity> data) {
        super(true, "Список книг");
        this.data = data;
    }
    private Iterable<BookEntity> data;

    @Override
    public String toString(){
        return "Книги из библиотеки\n"+ data;
    }
}
