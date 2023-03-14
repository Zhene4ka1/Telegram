package com.exam.telegrambot1.response;

import com.exam.telegrambot1.entity.AuthorEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AuthorResponse extends BaseResponse {
    public AuthorResponse(boolean success, String message, AuthorEntity author){
        super(success,message);
        this.author= author;
    }
    public AuthorResponse(AuthorEntity author){
        super(true,"Данные автора");
    }
    private AuthorEntity author;
}
